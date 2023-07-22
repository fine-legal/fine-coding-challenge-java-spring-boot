package so.fine.codingchallenge.endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import so.fine.codingchallenge.types.Lead;
import so.fine.codingchallenge.service.LeadService;

@RestController
public class LeadEndpoint {

    private LeadService leadService;

    @Autowired
    public LeadEndpoint(LeadService leadService){
        this.leadService = leadService;
    }

    @GetMapping
    public Lead getLead(@RequestParam Long id){
        return leadService.getLead(id);
    }
    
}
