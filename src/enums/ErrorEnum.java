package enums;

public enum ErrorEnum {
    INVALID_INPUT(100, "Invalid input!"),
    CUSTOMER_BLOCKED(101, "Account blocked!"),
    CUSTOMER_EXISTS(102, "Customer is exists!"),
    CUSTOMER_NOT_FOUND(103, "Customer not found!"),
    OUT_OF_BALANCE(104, "There are less amount than required!");
    private final int code;
    private final String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getInfo() {
        return code + " " + message;
    }
}