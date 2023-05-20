package so.fine.codingchallenge.dto;

import so.fine.codingchallenge.db.*;

public class Conversions {

    public static LeadDto leadEntityToDto(Lead lead) {
        LeadDto dto = new LeadDto();
        dto.setId(lead.getId());
        dto.setFirstname(lead.getFirstname());
        dto.setLastname(lead.getLastname());
        dto.setAddress(lead.getAddress());
        dto.setCity(lead.getCity());
        dto.setZipcode(lead.getZipcode());
        dto.setPhoneNumber(lead.getPhoneNumber());
        dto.setEmailAddress(lead.getEmailAddress());
        return dto;
    }

    public static Lead leadDtoToEntity(LeadDto dto) {
        Lead lead = new Lead();
        lead.setId(dto.getId());
        lead.setFirstname(dto.getFirstname());
        lead.setLastname(dto.getLastname());
        lead.setAddress(dto.getAddress());
        lead.setCity(dto.getCity());
        lead.setZipcode(dto.getZipcode());
        lead.setPhoneNumber(dto.getPhoneNumber());
        lead.setEmailAddress(dto.getEmailAddress());
        return lead;
    }

    public static UserDto userEntityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setAddress(user.getAddress());
        dto.setCity(user.getCity());
        dto.setZipcode(user.getZipcode());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setEmailAddress(user.getEmailAddress());
        dto.setState(user.getState());
        dto.setCourt(user.getCourt());
        return dto;
    }

    public static DealDto dealEntityToDto(AbstractDeal deal) {
        DealDto dto = new DealDto();
        if (deal instanceof DealA) {
            dto.setDealType(DealType.DEAL_A);
            dto.setWithdrawals(((DealA) deal).getWithdrawals());
            dto.setDeposits(((DealA) deal).getDeposits());
        } else if (deal instanceof DealB) {
            dto.setDealType(DealType.DEAL_B);
            dto.setSalary(((DealB) deal).getSalary());
            dto.setContractStart(((DealB) deal).getContractStart());
        }
        dto.setName(deal.getName());
        dto.setDescription(deal.getDescription());
        dto.setAmount(deal.getAmount());
        dto.setStatus(deal.getStatus());
        return dto;
    }
}
