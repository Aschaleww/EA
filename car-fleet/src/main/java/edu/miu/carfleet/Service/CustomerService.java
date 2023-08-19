//package edu.miu.carfleet.Service;
//
//import edu.miu.carfleet.DTO.CustomerDTO;
//import edu.miu.carfleet.Domain.Customer;
//import edu.miu.carfleet.Exception.NotFoundException;
//import edu.miu.carfleet.Repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public CustomerDTO addCustomer(CustomerDTO customerDTO){
//        Customer customer = new Customer();
//        customer.setName(customerDTO.getName());
//        customer.setEmail(customerDTO.getEmail());
//
//       Customer savedCustomer =  customerRepository.save(customer);
//
//        CustomerDTO savedCustomerDTO = new CustomerDTO();
//        savedCustomerDTO.setName(savedCustomer.getName());
//        savedCustomerDTO.setEmail(savedCustomer.getEmail());
//
//        return savedCustomerDTO;
//    }
//    public void removeCustomer(long customernumber){
//        Customer cust= customerRepository.findByCustomerNumber(customernumber);
//        if(cust==null){
//            throw new NotFoundException("there is no customer to delete");
//        }
//        customerRepository.delete(cust);
//
//    }
//
//}
