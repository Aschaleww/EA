package edu.miu.service;

import edu.miu.entity.CustomerFrequentRenter;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.miu.repository.FrequentRenterRepository;

import java.util.Collection;

@Service
public class FrequentRenterService implements IFrequentRenterService {

    @Autowired
    private FrequentRenterRepository frequentRenterRepository;

    @Override
    public CustomerFrequentRenter createAccount(long customerId, String username, String password) {
        String hashedPassword = hashPassword(password);
        CustomerFrequentRenter account = new CustomerFrequentRenter(customerId, username, hashedPassword);
        frequentRenterRepository.save(account);
        return account;
    }

    @Override
    public CustomerFrequentRenter login(String username, String password) {
        System.out.println("-> SERVICE LOGGIN METHOD .....");

        CustomerFrequentRenter account = frequentRenterRepository.findByUsername(username);
        if (account == null) return null;

        if (checkPassword(password, account.getPassword())) {
            System.out.println("LOGGIN SUCCESS .....");
            return account;
        }
        System.out.println("LOGGIN ERROR .....");

        return null;
    }

    @Override
    public CustomerFrequentRenter addPoint(long customerId, int point) {
        CustomerFrequentRenter account = getAccount(customerId);
        int updatedPoints = account.getPoint();
        System.out.println("current points " + updatedPoints);

        switch (account.getAccountType()) {
            case CustomerFrequentRenter.Bronze -> {
                updatedPoints += point;
                System.out.println("updating  points " + updatedPoints);

                if (updatedPoints > 50) {
                    account.setAccountType(CustomerFrequentRenter.Silver);
                    updatedPoints -= 50;
                }
            }
            case CustomerFrequentRenter.Silver -> {
                updatedPoints += 2 * point;
                if (updatedPoints > 100) {
                    account.setAccountType(CustomerFrequentRenter.Gold);
                    updatedPoints -= 100;
                }
            }
            case CustomerFrequentRenter.Gold -> updatedPoints += 3 * point;
        }

        account.setPoint(updatedPoints);
        frequentRenterRepository.save(account);
        return account;
    }

    @Override
    public CustomerFrequentRenter getAccount(long customerId) {
        return frequentRenterRepository.findByCustomerId(customerId);
    }

    @Override
    public Collection<CustomerFrequentRenter> getAccountList() {
        return frequentRenterRepository.findAll();
    }

    private String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    private boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
