package app.controllers;

import app.entities.Order;
import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.OrderMapper;
import io.javalin.http.Context;

import java.util.List;

public class OrderController {

    public static void addOrder(Context ctx, ConnectionPool connectionPool)
    {
        User user = ctx.sessionAttribute("currentUser");
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

    }



    public static void update(Context ctx, ConnectionPool connectionPool)
    {
        int orderId = Integer.parseInt(ctx.formParam("order_id"));
        String status = ctx.formParam("status");
        try
        {
            OrderMapper.update(orderId, status, connectionPool);
            User user = ctx.sessionAttribute("currentUser");
            List<Order> orderList = OrderMapper.getAllOrdersPerUser(user.getId(), connectionPool);
            ctx.attribute("orderList", orderList);
            ctx.render("orders.html");
        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }




    }

}
