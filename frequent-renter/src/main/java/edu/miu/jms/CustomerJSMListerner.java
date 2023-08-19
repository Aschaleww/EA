package edu.miu.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.entity.CustomerFrequentRenter;
import edu.miu.logger.ILogger;
import edu.miu.repository.FrequentRenterRepository;
import edu.miu.service.FrequentRenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerJSMListerner {
    @Autowired
    private FrequentRenterService frequentRenterService;

    @Autowired
    private FrequentRenterRepository frequentRenterRepository;


    @Autowired
    private ILogger logger;


    @JmsListener(destination = "frequentRent")
    public void onCarRentEvent(String data) throws JsonProcessingException {

        System.out.println("-> onCarRentEvent"+  data);
        ObjectMapper mapper = new ObjectMapper();
        CustomerEventData customerReceived = mapper.readValue(data, CustomerEventData.class);

//        logger.info("-> JMS message received: " + data);
        System.out.println(customerReceived.getCustomerId() + "  " + customerReceived.getPoint());

        CustomerFrequentRenter customerDBSearch = frequentRenterRepository.findByCustomerId(customerReceived.getCustomerId());

        if (customerDBSearch == null) {
            System.out.println("-> Creating a customer for frequent rent");
            CustomerFrequentRenter newCustomer = new CustomerFrequentRenter(
                    customerReceived.getCustomerId(),
                    customerReceived.getUsername(),
                    "123"
            );

            frequentRenterRepository.save(newCustomer);
            frequentRenterService.addPoint(newCustomer.getCustomerId(), customerReceived.getPoint());
        } else {
            System.out.println("-> Updating a exited customer for frequent rent");
            frequentRenterService.addPoint(customerReceived.getCustomerId(), customerReceived.getPoint());
        }


    }


    private boolean verification() {

        return true;
    }

}

