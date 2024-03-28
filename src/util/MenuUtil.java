package util;

public class MenuUtil {

    public Byte mainMenu() {
        return InputUtil.getInstance().inputByte("""
                0-> Exit system
                1-> Register
                2-> Login
                3-> Increase the balance
                """);
    }

    public Byte loginMenu() {
        return InputUtil.getInstance().inputByte("""
                1-> Show my details
                2-> Update my details
                3-> Operations
                4-> Log out
                """);
    }

    public Byte operationMenu() {
        return InputUtil.getInstance().inputByte("""
                1-> Show balance
                2-> cashing out
                """);
    }

    private MenuUtil() {
    }

    private static MenuUtil menuUtil;

    public static MenuUtil getInstance() {
        return menuUtil == null ? new MenuUtil() : menuUtil;
    }
}