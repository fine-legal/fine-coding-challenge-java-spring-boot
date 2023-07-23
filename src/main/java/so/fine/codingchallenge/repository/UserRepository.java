package so.fine.codingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import so.fine.codingchallenge.types.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // more queries
}