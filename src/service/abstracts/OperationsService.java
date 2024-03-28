package service.abstracts;

import entity.Customer;

public interface OperationsService {
    void showBalance(Customer customer);

    void cashingOut(Customer customer);
}