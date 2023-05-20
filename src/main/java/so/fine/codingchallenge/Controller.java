package so.fine.codingchallenge;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import so.fine.codingchallenge.dto.DealDto;
import so.fine.codingchallenge.dto.LeadDto;
import so.fine.codingchallenge.dto.UserDto;
import so.fine.codingchallenge.service.ConvertNonexistingLeadException;
import so.fine.codingchallenge.service.CoreService;
import so.fine.codingchallenge.service.DealForNonexistingUserException;
import so.fine.codingchallenge.service.NoDealTypeException;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final CoreService coreService;

    public Controller(CoreService coreService) {
        this.coreService = coreService;
    }

    @GetMapping("/leads")
    public List<LeadDto> getLeads() {
        return coreService.getLeads();
    }

    @GetMapping("/leads/{id}")
    public LeadDto getLead(@PathVariable long id) {
        Optional<LeadDto> optional = coreService.getLead(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optional.get();
     }

    @PostMapping("/leads")
     public LeadDto createLead(@RequestBody LeadDto leadDto) {
        return coreService.createLead(leadDto);
    }

    @PostMapping("/leads/{id}/convert")
    public UserDto convertLead(@PathVariable long id) {
        try {
            return coreService.convertLead(id);
        } catch (ConvertNonexistingLeadException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/{userId}/deals")
    public DealDto createDeal(@RequestBody DealDto dealDto, @PathVariable long userId) {
        try {
            return coreService.createDeal(dealDto, userId);
        } catch (DealForNonexistingUserException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (NoDealTypeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{userId}/deals")
    public List<DealDto> getDeals(@PathVariable long userId) {
        return coreService.getDeals(userId);
    }
}
