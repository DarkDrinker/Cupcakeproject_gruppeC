package app.persistence;

import app.entities.Order;
import app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<Order> getAllOrdersPerUser(int userid, ConnectionPool connectionPool) throws DatabaseException {
        List<Order> orderList = new ArrayList<>();
        String sql = "select * from Orders where user_id=? order by id";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, userid);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String date = rs.getString("date");
                        String status = rs.getString("status");
                        orderList.add(new Order(id, date, status, userid));
                    }
                }

            } catch (SQLException e) {
                throw new DatabaseException("Fejl i Orders");
            }
            return orderList;
        }



    public static void addOrder(int id,String date, String status, int userID, ConnectionPool connectionPool){
    }


    public static void update(int orderId, String status, ConnectionPool connectionPool) {
    }
}