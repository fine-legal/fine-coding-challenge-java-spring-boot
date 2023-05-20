package so.fine.codingchallenge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import so.fine.codingchallenge.db.*;
import so.fine.codingchallenge.dto.DealDto;
import so.fine.codingchallenge.dto.DealType;
import so.fine.codingchallenge.dto.LeadDto;
import so.fine.codingchallenge.dto.UserDto;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CoreServiceTest {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @MockBean
    @Qualifier("fakeCourtService")
    private CourtService courtService;

    @Captor
    private ArgumentCaptor<Integer> courtServiceCaptor;

    @Autowired
    private CoreService coreService;

    @BeforeEach
    public void before() {
        when(courtService.get(anyInt())).thenReturn("Mocked_court");
        dealRepository.deleteAll();
        userRepository.deleteAll();
        leadRepository.deleteAll();
    }

    @Test
    public void createLeadTest() {
        LeadDto lead = new LeadDto();
        lead = coreService.createLead(lead);
        Assertions.assertThat(leadRepository.findAll()).hasSize(1);
        Assertions.assertThat(leadRepository.findAll().get(0).getId()).isEqualTo(lead.getId());
    }

    @Test
    public void getLeadTest() {
        LeadDto lead = new LeadDto();
        lead.setFirstname("Cosmo");
        lead = coreService.createLead(lead);
        Assertions.assertThat(coreService.getLead(lead.getId()).isPresent());
        Assertions.assertThat(coreService.getLead(lead.getId()).get().getFirstname()).isEqualTo("Cosmo");
    }

    @Test
    public void getLeadsTest() {
        LeadDto lead = new LeadDto();
        lead.setFirstname("Cosmo");
        lead = coreService.createLead(lead);
        Assertions.assertThat(coreService.getLeads()).hasSize(1);
        Assertions.assertThat(coreService.getLeads().get(0).getFirstname()).isEqualTo("Cosmo");
    }

    @Test
    public void convertLeadsTest() {
        LeadDto lead = new LeadDto();
        lead.setFirstname("Cosmo");
        lead.setZipcode(1234);
        lead = coreService.createLead(lead);
        UserDto user = coreService.convertLead(lead.getId());
        Assertions.assertThat(userRepository.findAll()).hasSize(1);
        User userEntity = userRepository.findAll().get(0);
        Assertions.assertThat(user.getFirstname()).isEqualTo("Cosmo");
        Assertions.assertThat(user.getState()).isEqualTo("Berlin");
        Assertions.assertThat(user.getCourt()).isEqualTo("Mocked_court");
        Assertions.assertThat(userEntity.getFirstname()).isEqualTo("Cosmo");
        Assertions.assertThat(userEntity.getState()).isEqualTo("Berlin");
        Assertions.assertThat(userEntity.getCourt()).isEqualTo("Mocked_court");

        verify(courtService).get(courtServiceCaptor.capture());
        Assertions.assertThat(courtServiceCaptor.getValue()).isEqualTo(1234);
    }

    @Test
    public void convertNonexistingLeadsTest() {
        Assertions.assertThatThrownBy(() -> coreService.convertLead(-1))
                .isInstanceOf(ConvertNonexistingLeadException.class);
    }

    @Test
    public void createDealTest() {
        LeadDto lead = coreService.createLead(new LeadDto());
        UserDto user = coreService.convertLead(lead.getId());
        DealDto deal = new DealDto();
        deal.setDealType(DealType.DEAL_A);
        deal = coreService.createDeal(deal, user.getId());
        Assertions.assertThat(dealRepository.findAll()).hasSize(1);
        Assertions.assertThat(dealRepository.findAll().get(0)).isInstanceOf(DealA.class);
        Assertions.assertThat(dealRepository.findAll().get(0).getUser().getId()).isEqualTo(user.getId());
    }

    @Test
    public void getDealsTest() {
        LeadDto lead = coreService.createLead(new LeadDto());
        UserDto user = coreService.convertLead(lead.getId());
        DealDto deal = new DealDto();
        deal.setDealType(DealType.DEAL_A);
        deal = coreService.createDeal(deal, user.getId());
        Assertions.assertThat(coreService.getDeals(user.getId())).hasSize(1);
        Assertions.assertThat(coreService.getDeals(user.getId()).get(0).getDealType()).isEqualTo(DealType.DEAL_A);
    }

    @Test
    public void createDealWithoutTypeTest() {
        LeadDto lead = coreService.createLead(new LeadDto());
        UserDto user = coreService.convertLead(lead.getId());
        Assertions.assertThatThrownBy(() -> coreService.createDeal(new DealDto(), user.getId()))
                        .isInstanceOf(NoDealTypeException.class);
    }

    @Test
    public void createDealWithoutUserTest() {
        DealDto dealDto = new DealDto();
        dealDto.setDealType(DealType.DEAL_A);
        Assertions.assertThatThrownBy(() -> coreService.createDeal(new DealDto(), -1))
                .isInstanceOf(DealForNonexistingUserException.class);
    }
}
