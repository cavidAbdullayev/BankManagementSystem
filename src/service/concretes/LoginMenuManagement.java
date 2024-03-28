package service.concretes;

import entity.Customer;
import service.abstracts.LoginMenuService;
import service.abstracts.LoginService;

public class LoginMenuManagement implements LoginMenuService {
    LoginService loginService = new LoginManagement();

    @Override
    public void management(Byte option, Customer customer) {
        switch (option) {
            case 1 -> loginService.showDetails(customer);
            case 2 -> loginService.update(customer);
            case 3 -> loginService.showOperations(customer);
            case 4 -> loginService.logOut();
        }
    }

    private LoginMenuManagement() {
    }

    private static LoginMenuManagement loginMenuManagement;

    public static LoginMenuManagement getInstance() {
        return loginMenuManagement == null ? new LoginMenuManagement() : loginMenuManagement;
    }
}