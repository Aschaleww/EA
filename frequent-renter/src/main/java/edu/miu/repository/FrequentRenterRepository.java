package edu.miu.repository;

import edu.miu.entity.CustomerFrequentRenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequentRenterRepository extends JpaRepository<CustomerFrequentRenter, Long> {
    public CustomerFrequentRenter findByCustomerId(long customerId);
    public CustomerFrequentRenter findByUsername(String username);
}
