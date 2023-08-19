package edu.miu.carfleet.DTO;

import edu.miu.carfleet.Domain.Customer;

public class CustomerAdapter {

    public CustomerDTO convertToDto(Customer customer){
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setCustomernumber(customerDTO.getCustomernumber());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());

        return  customerDTO;
    }
}
