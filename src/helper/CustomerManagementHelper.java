package helper;

import entity.Customer;
import enums.ErrorEnum;
import exceptions.GeneralException;
import global.GlobalData;

public class CustomerManagementHelper {
    private CustomerManagementHelper() {
    }

    private static CustomerManagementHelper customerManagementHelper;

    public static CustomerManagementHelper getInstance() {
        return customerManagementHelper == null ? new CustomerManagementHelper() : customerManagementHelper;
    }

    public boolean isPasswordCorrect(String password, String email) {
        Customer customer = null;
        for (Customer customer2 : GlobalData.customers) {
            if (customer2.getEmail().equals(email)) {
                customer = customer2;
                break;
            }
        }
        return customer.getPassword().equals(password);
    }

    public Customer isCustomerExist(String email) {
        Customer customer = null;
        for (Customer customer1 : GlobalData.customers) {
            if (customer1.getEmail().equals(email)) {
                customer = customer1;
                break;
            }
        }
        if (customer != null)
            return customer;
        else {
            throw new GeneralException(ErrorEnum.CUSTOMER_NOT_FOUND);
        }
    }
}