package edu.miu.dto;

import edu.miu.entity.CustomerFrequentRenter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class FrequentRenterAdapter {

        public CustomerFrequentRenter getFrequentRenterFromFrequentRenterDTO(FrequentRenterDTO frequentRenterDTO){
            CustomerFrequentRenter customerFrequentRenter = new CustomerFrequentRenter(
                                                            frequentRenterDTO.getCustomerId(),
                                                            frequentRenterDTO.getUsername(),
                                                            frequentRenterDTO.getPassword());
            return customerFrequentRenter;
        }

    public FrequentRenterDTO getFrequentRenterDTOFromFrequentRenter(CustomerFrequentRenter customerFrequentRenter){
        FrequentRenterDTO frequentRenterDTO= new FrequentRenterDTO(
                customerFrequentRenter.getCustomerId(),
                customerFrequentRenter.getUsername(),
                "",
                customerFrequentRenter.getPoint(),
                customerFrequentRenter.getAccountType());
        return frequentRenterDTO;
    }

    public Collection<FrequentRenterDTO> getFrequentRentDTOListFromFrequentRentList(Collection<CustomerFrequentRenter> customerFrequentRenterList){
            Collection<FrequentRenterDTO> accountDTOList= new ArrayList<>();
            for(CustomerFrequentRenter customerFrequentRenter : customerFrequentRenterList){
                accountDTOList.add(getFrequentRenterDTOFromFrequentRenter(customerFrequentRenter));
            }

            return accountDTOList;
    }
}

