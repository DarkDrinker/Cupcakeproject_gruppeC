package app.persistence;

import app.entities.Order;
import app.entities.Task;
import app.entities.User;
import app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<Order> getAllOrdersPerUser(int user_id, ConnectionPool connectionPool) throws DatabaseException
    {
        List<Order> orderList = new ArrayList<>();
        String sql = "select * from Orders where user_id=? order by id";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String date = rs.getString("date");
                    String status = rs.getString("status");
                    int userId = rs.getInt("userId");
                    orderList.add(new Order(id, date, status, userId));
                }
            }

        }
        catch (SQLException e)
        {
            throw new DatabaseException("Fejl!!!!");
        }
        return orderList;
    }


    public static void addOrder(int id,String date, String status, int userID, ConnectionPool connectionPool){
    }


    public static void update(int orderId, String status, ConnectionPool connectionPool) {
    }
}
