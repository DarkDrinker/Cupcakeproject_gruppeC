package app.entities;

public class User {
    private int id;
    private String name;
    private String password;
    private boolean admin;
    private int balance;


    public User(int id, String name, String password, boolean isAdmin, int balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = isAdmin;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", balance=" + balance +
                '}';
    }
}
