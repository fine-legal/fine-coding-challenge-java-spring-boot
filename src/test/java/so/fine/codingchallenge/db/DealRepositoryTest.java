package so.fine.codingchallenge.db;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
public class DealRepositoryTest {

    private DealRepository dealRepository;

    @Autowired
    public DealRepositoryTest(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @BeforeEach
    public void before() {
        dealRepository.deleteAll();
    }

    @Test
    public void dealsTest() {
        DealA dealA = new DealA();
        dealA.setName("dealA");
        dealA.setDescription("dealA_description");
        dealA.setAmount(42);
        dealA.setStatus(DealStatus.IN_PROGRESS);
        dealA.setWithdrawals(142);
        dealA.setDeposits(242);

        AbstractDeal abstractDealA = dealRepository.save(dealA);

        DealB dealB = new DealB();
        dealB.setName("dealB");
        dealB.setDescription("dealB_description");
        dealB.setAmount(43);
        dealB.setStatus(DealStatus.NEW);
        dealB.setSalary(123);
        dealB.setContractStart(LocalDate.of(2022, 1, 1));

        AbstractDeal abstractDealB = dealRepository.save(dealB);

        Assertions.assertThat(abstractDealA).hasSameClassAs(dealA);
        Assertions.assertThat(abstractDealB).hasSameClassAs(dealB);

        List<AbstractDeal> deals = dealRepository.findAll();
        deals.sort(Comparator.comparing(AbstractDeal::getName));

        Assertions.assertThat(deals).hasSize(2);
        Assertions.assertThat(deals.get(0)).usingRecursiveComparison().isEqualTo(dealA);
        Assertions.assertThat(deals.get(1)).usingRecursiveComparison().isEqualTo(dealB);
    }
}
