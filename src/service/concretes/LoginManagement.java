package service.concretes;

import entity.Customer;
import service.abstracts.LoginService;
import service.abstracts.OperationMenuService;
import util.InputUtil;
import util.MenuUtil;

public class LoginManagement implements LoginService {
    private final OperationMenuService operationMenuService = new OperationMenuManagement();

    @Override
    public void showDetails(Customer customer) {
        System.out.println(customer.getInfo());
    }

    @Override
    public void update(Customer customer) {
        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String surname = InputUtil.getInstance().inputString("Enter the surname: ");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String oldPassword = InputUtil.getInstance().inputString("Enter the old password: ");
        String cardNumber = InputUtil.getInstance().inputString("Enter the card number: ");
        if (oldPassword.equals(customer.getPassword())) {
            String newPassword = InputUtil.getInstance().inputString("Enter the new password: ");
            customer.setPassword(newPassword);
        }
        customer.setName(name);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setCartNumber(cardNumber);

    }

    @Override
    public void showOperations(Customer customer) {
        Byte option = MenuUtil.getInstance().operationMenu();
        operationMenuService.management(option, customer);
    }

    @Override
    public void logOut() {
        MenuManagement.getInstance().management();
    }
}