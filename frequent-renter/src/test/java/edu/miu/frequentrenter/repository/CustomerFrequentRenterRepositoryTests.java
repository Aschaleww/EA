package edu.miu.frequentrenter.repository;

import edu.miu.entity.CustomerFrequentRenter;
import edu.miu.repository.FrequentRenterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerFrequentRenterRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FrequentRenterRepository frequentRenterRepository;

    @Test
    public void whenFindByCustomerId_thenReturnCustomer() {
        final long testCustomerId = 1234;
        final String testUsername = "user1234";
        CustomerFrequentRenter customer = new CustomerFrequentRenter(testCustomerId, testUsername, "pass1234");
        entityManager.persist(customer);
        entityManager.flush();

        CustomerFrequentRenter foundCustomer = frequentRenterRepository.findByCustomerId(testCustomerId);

        assertThat(foundCustomer.getCustomerId()).isEqualTo(testCustomerId);
        assertThat(foundCustomer.getUsername()).isEqualTo(testUsername);
    }

    @Test
    public void whenFindByUsername_thenReturnCustomer() {
        final long testCustomerId = 1234;
        final String testUsername = "user1234";

        CustomerFrequentRenter customer = new CustomerFrequentRenter(testCustomerId, testUsername, "pass1234");
        entityManager.persist(customer);
        entityManager.flush();

        CustomerFrequentRenter foundCustomer = frequentRenterRepository.findByUsername(testUsername);

        assertThat(foundCustomer.getCustomerId()).isEqualTo(testCustomerId);
        assertThat(foundCustomer.getUsername()).isEqualTo(testUsername);
    }
}
