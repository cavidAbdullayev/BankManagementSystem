package service.concretes;

import entity.Customer;
import service.abstracts.OperationMenuService;
import service.abstracts.OperationsService;

public class OperationMenuManagement implements OperationMenuService {
    private final OperationsService operationsService = new OperationManagement();

    @Override
    public void management(Byte option, Customer customer) {
        switch (option) {
            case 1 -> operationsService.showBalance(customer);
            case 2 -> operationsService.cashingOut(customer);
        }
    }
}