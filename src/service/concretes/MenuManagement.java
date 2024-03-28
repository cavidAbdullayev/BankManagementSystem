package service.concretes;

import enums.ErrorEnum;
import exceptions.GeneralException;
import service.abstracts.MenuService;
import service.abstracts.CustomerService;
import util.MenuUtil;

import java.util.InputMismatchException;

public class MenuManagement implements MenuService {
    private MenuManagement() {
    }

    private static MenuManagement menuManagement;

    public static MenuManagement getInstance() {
        return menuManagement == null ? new MenuManagement() : menuManagement;
    }

    @Override
    public void management() {
        CustomerService customerService = new CustomerManagement();
        while (true) {
            try {
                while (true) {

                    Byte option = MenuUtil.getInstance().mainMenu();
                    switch (option) {
                        case 0 -> customerService.exit();
                        case 1 -> customerService.register();
                        case 2 -> customerService.login();
                        case 3 -> customerService.increaseBalance();
                        default -> throw new GeneralException(ErrorEnum.INVALID_INPUT);
                    }

                }
            } catch (GeneralException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println(ErrorEnum.INVALID_INPUT.getInfo());
            }
        }
    }
}
