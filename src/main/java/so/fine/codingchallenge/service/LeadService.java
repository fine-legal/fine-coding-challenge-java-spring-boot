package so.fine.codingchallenge.service;

import org.springframework.stereotype.Service;
import so.fine.codingchallenge.types.Lead;
import so.fine.codingchallenge.repository.LeadRepository;
import java.util.List;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository){
        this.leadRepository = leadRepository;
    }
    
    public Lead getLead(Long id){
        return leadRepository.getReferenceById(id);
    }

    public List<Lead> getLeads(){
        return leadRepository.findAll();
    }
}
