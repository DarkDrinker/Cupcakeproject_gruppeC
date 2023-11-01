package app.controllers;

import app.entities.Cart;
import app.entities.Order;
import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.OrderMapper;
import io.javalin.http.Context;

import java.util.List;

public class CartController {
    public static void addToCart(Context ctx, ConnectionPool connectionPool)
    {
      /*  User user = ctx.sessionAttribute("currentUser");
        String taskName = ctx.formParam("addOrder");
        try
        {
            //Order newOrder = OrderMapper.addOrder(id,date,status, userId, connectionPool);
            List<Order> orderList = OrderMapper.getAllOrdersPerUser(user.getId(), connectionPool);
            ctx.attribute("orderList", orderList);
            ctx.render("orders.html");
        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }
*/
    }
}
