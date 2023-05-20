package so.fine.codingchallenge.service;

import so.fine.codingchallenge.dto.DealDto;
import so.fine.codingchallenge.dto.LeadDto;
import so.fine.codingchallenge.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface CoreService {

    List<LeadDto> getLeads();

    Optional<LeadDto> getLead(long id);

    LeadDto createLead(LeadDto leadDto);

    UserDto convertLead(long leadId);

    DealDto createDeal(DealDto dealDto, long userId);

    List<DealDto> getDeals(long userId);

}
