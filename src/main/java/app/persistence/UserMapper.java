package app.persistence;

import app.entities.User;
import app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User login(String name, String password, ConnectionPool connectionPool) throws DatabaseException{
       String sql = "select * from \"user\" where username=? and password=?";

       try(Connection connection = connectionPool.getConnection())
       {
           try(PreparedStatement ps = connection.prepareStatement(sql))
           {
               ps.setString(1,name);
               ps.setString(2,password);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                   int id = rs.getInt("id");
                   return new User(id,name, password);
               } else {
                throw new DatabaseException("Login er desværre forkert");
               }
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


    }
}
