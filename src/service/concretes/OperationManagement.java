package service.concretes;

import entity.Customer;
import enums.ErrorEnum;
import exceptions.GeneralException;
import service.abstracts.OperationsService;
import util.InputUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationManagement implements OperationsService {
    @Override
    public void showBalance(Customer customer) {
        System.out.println(customer.getBalance());
    }

    @Override
    public void cashingOut(Customer customer) {
        Double amount = InputUtil.getInstance().inputDouble("Enter the amount you want to cash out: ");
        if (amount > customer.getBalance())
            throw new GeneralException(ErrorEnum.OUT_OF_BALANCE);
        System.out.println((amount / 500 == 0 ? "" : amount / 500 + " - 500"));
        amount %= 500;
        System.out.println((amount / 200 == 0 ? "" : amount / 200 + " - 200"));
        amount %= 200;
        System.out.println((amount / 100 == 0 ? "" : amount / 100 + " - 100"));
        amount %= 100;
        System.out.println((amount / 20 == 0 ? "" : amount / 20 + " - 20"));
        amount %= 20;
        System.out.println((amount / 5 == 0 ? "" : amount / 5 + " - 5"));
        amount %= 5;
        System.out.println((amount == 0 ? "" : amount + " - 1"));
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        System.out.println("Date & time: " + localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
        System.out.println("Card number: " + customer.getCartNumber().substring(0, 4) + "********" + customer.getCartNumber().substring(12, 16));
        System.out.println("Cash: " + amount);
        System.out.println("Total remaining balance: " + (customer.getBalance() - amount));
        customer.setBalance(customer.getBalance() - amount);
    }
}