package so.fine.codingchallenge.endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import so.fine.codingchallenge.types.Lead;
import so.fine.codingchallenge.endpoints.dto.LeadDTO;
import so.fine.codingchallenge.service.LeadService;
import so.fine.codingchallenge.endpoints.dto.EntityToDTOConverter;

@RestController
public class LeadEndpoint {

    private LeadService leadService;

    @Autowired
    public LeadEndpoint(LeadService leadService){
        this.leadService = leadService;
    }

    @GetMapping("/leads")
    public ResponseEntity<LeadDTO> getLead(@RequestParam Long id) {
        Lead lead = leadService.getLead(id);
        if(lead != null) {
            EntityToDTOConverter<Lead, LeadDTO> leadConverter = new EntityToDTOConverter<>();
            LeadDTO leadDTO = leadConverter.convertToDto(lead, LeadDTO.class);
            return ResponseEntity.ok(leadDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
