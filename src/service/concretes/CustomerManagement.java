package service.concretes;

import entity.Customer;
import enums.ErrorEnum;
import exceptions.GeneralException;
import global.GlobalData;
import helper.CustomerManagementHelper;
import service.abstracts.CustomerService;
import util.InputUtil;
import util.MenuUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class CustomerManagement implements CustomerService {
    @Override
    public void exit() {
        System.exit(-1);
    }

    @Override
    public void register() {
        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String surname = InputUtil.getInstance().inputString("Enter the surname: ");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        for (Customer customer : GlobalData.customers) {
            if (customer.getEmail().equals(email))
                throw new GeneralException(ErrorEnum.CUSTOMER_EXISTS);
        }
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        String cardNumber = InputUtil.getInstance().inputString("Enter the card number: ");
        GlobalData.customers.add(new Customer(name, surname, email, password, cardNumber));
    }
    @Override
    public void login() {
        Customer customer;
        int i = 0;
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        customer = CustomerManagementHelper.getInstance().isCustomerExist(email);
        if (customer != null) {
            String password;
            do {
                password = InputUtil.getInstance().inputString("Enter the password: ");
                if (CustomerManagementHelper.getInstance().isPasswordCorrect(password, email)) {
                    System.out.println("Welcome dear " + customer.getName());
                    Byte option = MenuUtil.getInstance().loginMenu();
                    LoginMenuManagement.getInstance().management(option, customer);
                    return;
                } else {
                    if (i != 2)
                        System.err.println("Password is incorrect. Try again.");
                }
            } while (!customer.getPassword().equals(password) && i++ < 2);
            throw new GeneralException(ErrorEnum.CUSTOMER_BLOCKED);
        }
    }
    @Override
    public void increaseBalance() {
        String cardNumber = InputUtil.getInstance().inputString("Enter the card number: ");
        Customer customer = null;
        for (Customer customer1 : GlobalData.customers) {
            if (customer1.getCartNumber().equals(cardNumber))
                customer = customer1;
        }
        if (customer == null)
            throw new GeneralException(ErrorEnum.CUSTOMER_NOT_FOUND);
        else {
            Double amount = InputUtil.getInstance().inputDouble("Enter the amount: ");
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Success!");
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
            for (String s : Arrays.asList("Card number: " + cardNumber, "Amount: +" + amount, "Total balance: ", "Data & Time: " + customer.getBalance())) {
                System.out.println(s);
            }
        }
    }
}