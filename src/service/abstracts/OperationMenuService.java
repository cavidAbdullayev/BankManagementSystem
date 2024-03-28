package service.abstracts;

import entity.Customer;

public interface OperationMenuService {
    void management(Byte option, Customer customer);
}