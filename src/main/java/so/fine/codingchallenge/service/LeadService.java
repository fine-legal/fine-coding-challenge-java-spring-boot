package so.fine.codingchallenge.service;

import org.springframework.stereotype.Service;
import so.fine.codingchallenge.types.Lead;

@Service
public class LeadService {
    
    public Lead getLead(Integer id){
        return new Lead();
    }
}
