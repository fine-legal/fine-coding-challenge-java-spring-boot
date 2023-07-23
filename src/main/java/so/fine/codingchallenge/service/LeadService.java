package so.fine.codingchallenge.service;

import org.springframework.stereotype.Service;
import so.fine.codingchallenge.types.*;
import so.fine.codingchallenge.repository.LeadRepository;
import so.fine.codingchallenge.repository.UserRepository;
import java.util.*;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    private final UserRepository userRepository;

    public LeadService(LeadRepository leadRepository, UserRepository userRepository){
        this.leadRepository = leadRepository;
        this.userRepository = userRepository;
    }
    
    public Lead getLead(Long id){
        return leadRepository.getReferenceById(id);
    }

    public List<Lead> getLeads(){
        return leadRepository.findAll();
    }

    public Lead createLead(Lead lead){
        return leadRepository.save(lead);
    }

    public User convertLead(Long id) throws IllegalArgumentException{
        Lead lead = leadRepository.getReferenceById(id);
        if(lead != null){
            User user = new User(lead);
            User newUser = userRepository.save(user);
            leadRepository.deleteById(id);
            return newUser;
        } else {
            throw new IllegalArgumentException();
        }

    }
}
