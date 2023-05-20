package so.fine.codingchallenge.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import so.fine.codingchallenge.db.*;
import so.fine.codingchallenge.dto.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoreServiceImpl implements CoreService {

    private final LeadRepository leadRepository;

    private final UserRepository userRepository;

    private final DealRepository dealRepository;

    private final CourtService courtService;

    private final Zipcodes zipcodes;

    public CoreServiceImpl(LeadRepository leadRepository, UserRepository userRepository, DealRepository dealRepository, CourtService courtService, Zipcodes zipcodes) {
        this.leadRepository = leadRepository;
        this.userRepository = userRepository;
        this.dealRepository = dealRepository;
        this.courtService = courtService;
        this.zipcodes = zipcodes;
    }

    @Override
    public List<LeadDto> getLeads() {
        return leadRepository.findAll().stream().map(Conversions::leadEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<LeadDto> getLead(long id) {
        return leadRepository.findById(id).map(Conversions::leadEntityToDto);
    }

    @Override
    public LeadDto createLead(LeadDto leadDto) {
        Lead entity = Conversions.leadDtoToEntity(leadDto);
        entity = leadRepository.save(entity);
        return Conversions.leadEntityToDto(entity);
    }

    @Override
    @Transactional
    public UserDto convertLead(long leadId) {
        Optional<Lead> optional = leadRepository.findById(leadId);
        if (optional.isEmpty()) {
            throw new ConvertNonexistingLeadException(leadId);
        }
        return convertLeadInternal(optional.get());
    }

    private UserDto convertLeadInternal(Lead lead) {
        User user = new User();
        user.setFirstname(lead.getFirstname());
        user.setLastname(lead.getLastname());
        user.setAddress(lead.getAddress());
        user.setCity(lead.getCity());
        user.setZipcode(lead.getZipcode());
        user.setPhoneNumber(lead.getPhoneNumber());
        user.setEmailAddress(lead.getEmailAddress());
        user.setState(zipcodes.get(lead.getZipcode()));
        user.setCourt(courtService.get(lead.getZipcode()));
        user = userRepository.save(user);
        return Conversions.userEntityToDto(user);
    }

    @Override
    @Transactional
    public DealDto createDeal(DealDto dealDto, long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isEmpty()) {
            throw new DealForNonexistingUserException(userId);
        }
        if (dealDto.getDealType() == null) {
            throw new NoDealTypeException();
        }
        AbstractDeal deal;
        switch (dealDto.getDealType()) {
            case DEAL_A:
                DealA dealA = new DealA();
                dealA.setWithdrawals(dealDto.getWithdrawals());
                dealA.setDeposits(dealDto.getDeposits());
                deal = dealA;
                break;
            case DEAL_B:
                DealB dealB = new DealB();
                dealB.setSalary(dealDto.getSalary());
                dealB.setContractStart(dealDto.getContractStart());
                deal = dealB;
                break;
            default:
                throw new NoDealTypeException();
        }
        deal.setUser(optional.get());
        deal.setName(dealDto.getName());
        deal.setDescription(dealDto.getDescription());
        deal.setAmount(dealDto.getAmount());
        deal.setStatus(dealDto.getStatus());
        deal = dealRepository.save(deal);
        return Conversions.dealEntityToDto(deal);
    }

    @Override
    @Transactional
    public List<DealDto> getDeals(long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isEmpty()) {
            return List.of();
        }
        User user = optional.get();
        return user.getDeals().stream().map(Conversions::dealEntityToDto).collect(Collectors.toList());
    }
}
