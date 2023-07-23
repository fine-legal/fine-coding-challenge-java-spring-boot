package so.fine.codingchallenge.endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import so.fine.codingchallenge.types.Lead;
import so.fine.codingchallenge.endpoints.dto.LeadDTO;
import so.fine.codingchallenge.service.LeadService;
import so.fine.codingchallenge.endpoints.dto.EntityToDTOConverter;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LeadEndpoint {

    private LeadService leadService;

    @Autowired
    public LeadEndpoint(LeadService leadService){
        this.leadService = leadService;
    }

    @GetMapping("/leads/{id}")
    public ResponseEntity<LeadDTO> getLead(@PathVariable Long id) {
        Lead lead = leadService.getLead(id);
        if(lead != null) {
            EntityToDTOConverter<Lead, LeadDTO> leadConverter = new EntityToDTOConverter<>();
            LeadDTO leadDTO = leadConverter.convertToDto(lead, LeadDTO.class);
            return ResponseEntity.ok(leadDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/leads")
    public ResponseEntity<List<LeadDTO>> getLeads() {
        List<Lead> leads = leadService.getLeads();
        List<LeadDTO> leadDTOs = new ArrayList<>();
        EntityToDTOConverter<Lead, LeadDTO> leadConverter = new EntityToDTOConverter<>();
        for(Lead lead: leads){
            leadDTOs.add(leadConverter.convertToDto(lead, LeadDTO.class));
        }
        return new ResponseEntity<List<LeadDTO>>(leadDTOs, HttpStatus.OK);
    }

    @PostMapping("/leads")
    public ResponseEntity<LeadDTO> createLead(@RequestBody LeadDTO leadDTO) {
        EntityToDTOConverter<Lead, LeadDTO> leadConverter = new EntityToDTOConverter<>();
        Lead lead = leadConverter.convertToEntity(leadDTO, Lead.class);

        //do some validation here

        Lead createdLead = leadService.createLead(lead);

        LeadDTO createdLeadDTO = leadConverter.convertToDto(createdLead, LeadDTO.class);

        return new ResponseEntity<>(createdLeadDTO, HttpStatus.CREATED);
    }
    
}
