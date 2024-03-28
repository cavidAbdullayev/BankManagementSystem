package service.abstracts;

import entity.Customer;

public interface CustomerService {
    void exit();

    void register();

    void login();

    void increaseBalance();
}