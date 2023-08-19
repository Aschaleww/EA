package edu.miu;

import edu.miu.entity.CustomerFrequentRenter;
import edu.miu.repository.FrequentRenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class App implements CommandLineRunner {
    @Autowired
    FrequentRenterRepository frequentRenterRepository;

    @Autowired
    JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CustomerFrequentRenter customerFrequentRenter = new CustomerFrequentRenter(1l,"pancho","123");
        frequentRenterRepository.save(customerFrequentRenter);

        customerFrequentRenter = new CustomerFrequentRenter(2l,"pancho","123");
        frequentRenterRepository.save(customerFrequentRenter);
//
//        //activate activemq in mac -> ./activemq start
//        jmsTemplate.convertAndSend("rentalsystem", "rentalsystem");
    }
}