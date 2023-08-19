package edu.miu.service;

import edu.miu.entity.CustomerFrequentRenter;

import java.util.Collection;

public interface IFrequentRenterService {
    public Collection<CustomerFrequentRenter> getAccountList();
    CustomerFrequentRenter createAccount(long customerId, String username, String password);
    CustomerFrequentRenter addPoint(long customerId, int point);
    CustomerFrequentRenter getAccount(long customerId);
    CustomerFrequentRenter login(String username, String password);
}
