package service.abstracts;

import entity.Customer;

public interface LoginService {

    void showDetails(Customer customer);

    void update(Customer customer);

    void showOperations(Customer customer);

    void logOut();

}