package app.entities;

public class Order {

    private int id;
    private String date;
    private String status;
    private int userId;

    public Order(int id, String date, String status, int userId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }
}
