package so.fine.codingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import so.fine.codingchallenge.types.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    // more queries
}