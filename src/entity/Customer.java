package entity;

public class Customer {
    private String name;
    private String surname;
    private String email;


    public String getInfo() {
        return "name=" + name + "\n" +
                "surname=" + surname + "\n" +
                "email=" + email + "\n" +
                "password=" + password + "\n" +
                "cartNumber=" + cartNumber + "\n" +
                "balance=" + balance;
    }

    private String password;
    private String cartNumber;
    private Double balance = 0d;

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Boolean getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(Boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    private Boolean blockStatus = false;

    public Customer() {
    }

    public Customer(String name, String surname, String email, String password, String cartNumber, Double balance) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cartNumber = cartNumber;
        this.balance = balance;
    }

    public Customer(String name, String surname, String email, String password, String cartNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cartNumber = cartNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }


}