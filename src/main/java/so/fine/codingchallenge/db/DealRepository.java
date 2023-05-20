package so.fine.codingchallenge.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<AbstractDeal, Long> {
}
