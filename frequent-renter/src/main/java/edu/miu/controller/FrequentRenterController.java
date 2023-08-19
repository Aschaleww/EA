package edu.miu.controller;

import edu.miu.dto.AccountLoginDTO;
import edu.miu.dto.FrequentRenterAdapter;
import edu.miu.dto.FrequentRenterDTO;
import edu.miu.entity.CustomerFrequentRenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import edu.miu.service.FrequentRenterService;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/api/frequent_rentals")
public class FrequentRenterController {
    private Logger logger = LoggerFactory.getLogger(FrequentRenterController.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    FrequentRenterAdapter frequentRenterAdapter;

    @Autowired
    private FrequentRenterService frequentRenterService;

    @GetMapping("/accounts")
    public ResponseEntity<?> getAccounts() {
        logger.info("-> frequent_rentals");
        //activate activemq in mac -> ./activemq start
//        jmsTemplate.convertAndSend("rentalsystem", "requesting ACCOUNTS ");

        Collection<CustomerFrequentRenter> accountList = frequentRenterService.getAccountList();
        Collection<FrequentRenterDTO> accountDTOList= frequentRenterAdapter.getFrequentRentDTOListFromFrequentRentList(accountList);
        return new ResponseEntity< >(accountDTOList, HttpStatus.OK);
    }

    @GetMapping("/accounts/{customerId}")
    public ResponseEntity<?> getAccount(@PathVariable long customerId) {
        logger.info("-> frequent_rentals");
        CustomerFrequentRenter account = frequentRenterService.getAccount(customerId);
        FrequentRenterDTO accountDTO = frequentRenterAdapter.getFrequentRenterDTOFromFrequentRenter(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    // http://localhost:8081/api/frequent_rentals/accounts?customerId=12&username=chancho&password=123
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody CustomerFrequentRenter customer) {
        logger.info("-> createAccount");
        long customerId = customer.getCustomerId();
        String username = customer.getUsername();
        String password = customer.getPassword();
        CustomerFrequentRenter account = frequentRenterService.createAccount(customerId, username, password);
        FrequentRenterDTO accountDTO = frequentRenterAdapter.getFrequentRenterDTOFromFrequentRenter(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    //    Request example
//    http://localhost:8081/points?customerId=10&point=100
//    http://localhost:8081/api/frequent_rentals/points?customerId=10&point=100
    @PostMapping("/points")
    public ResponseEntity<?> addPoint(
            @RequestParam long customerId,
            @RequestParam int point) {
        logger.info("-> Endpoint addPoint");
        CustomerFrequentRenter account = frequentRenterService.addPoint(customerId, point);
        FrequentRenterDTO accountDTO = frequentRenterAdapter.getFrequentRenterDTOFromFrequentRenter(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    //  http://localhost:8081/api/frequent_rentals/login
    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody AccountLoginDTO accountLogin){

        logger.info("-> Endpoint login : " + accountLogin.getUsername() + "password " + accountLogin.getPassword());
        CustomerFrequentRenter account = frequentRenterService.login(accountLogin.getUsername(), accountLogin.getPassword());
        if (account == null) {
            return new ResponseEntity<String>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
        }
        FrequentRenterDTO accountDTO = frequentRenterAdapter.getFrequentRenterDTOFromFrequentRenter(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}
