package edu.miu.frequentrenter.service;

import edu.miu.entity.CustomerFrequentRenter;
import edu.miu.repository.FrequentRenterRepository;
import edu.miu.service.FrequentRenterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CustomerFrequentRenterServiceTests {
    @MockBean
    private FrequentRenterRepository frequentRenterRepository;

    @Autowired
    private FrequentRenterService frequentRenterService;

    @TestConfiguration
    static class AccountServiceTestConfiguration {
        @Bean
        public FrequentRenterService frequentRenterService() {
            return new FrequentRenterService();
        }
    }

    @Before
    public void setup() {
        CustomerFrequentRenter testCustomer = new CustomerFrequentRenter(1234, "user1234", "pass1234");
        Mockito.when(frequentRenterRepository.findByUsername("user1234")).thenReturn(testCustomer);
        Mockito.when(frequentRenterRepository.findByCustomerId(1234)).thenReturn(testCustomer);
    }

    @Test
    public void whenLoginWithCorrectCredential_thenReturnCustomer() {
        CustomerFrequentRenter customer = frequentRenterService.login("user1234", "pass1234");
        assertThat(customer).isNotNull();
        assertThat(customer.getCustomerId()).isEqualTo(1234);
    }

    @Test
    public void whenLoginWithInCorrectCredential_thenReturnNull() {
        CustomerFrequentRenter customer = frequentRenterService.login("user1234", "1234");
        assertThat(customer).isNull();
    }

    @Test
    public void whenAddingPoints_thenAddPointForCustomer() {
        CustomerFrequentRenter customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(10);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Bronze);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(20);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Bronze);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(30);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Bronze);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(40);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Bronze);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(50);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Bronze);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(10);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Silver);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(30);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Silver);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(50);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Silver);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(70);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Silver);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(90);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Silver);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(10);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Gold);

        customer = frequentRenterService.addPoint(1234, 10);
        assertThat(customer.getPoint()).isEqualTo(40);
        assertThat(customer.getAccountType()).isEqualTo(CustomerFrequentRenter.Gold);
    }
}
