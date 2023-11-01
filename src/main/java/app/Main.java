package app;

import app.config.ThymeleafConfig;
import app.controllers.CartController;
import app.controllers.OrderController;
import app.controllers.UserController;
import app.persistence.ConnectionPool;
import app.persistence.OrderMapper;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;
public class Main {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/%s?currentSchema=public";
    private static final String DB = "CupCakeProject";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);

    public static void main(String[] args) {
        // Initializing Javalin and Jetty webserver

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            JavalinThymeleaf.init(ThymeleafConfig.templateEngine());
        }).start(7070);

        // Routing

        app.get("/", ctx -> ctx.render("cupcakes.html"));
        app.get("/cupcakes", ctx -> ctx.render("cupcakes.html"));
        app.post("/cupcakes", ctx -> ctx.render("cupcakes.html"));
        app.get("/cart", ctx -> ctx.render("cart.html"));
        app.get("/login", ctx -> ctx.render("login.html"));
        app.post("/login", ctx -> UserController.login(ctx ,connectionPool) );
        app.get("/logout", ctx -> UserController.logout(ctx));
        app.get("/orders/{id}", ctx -> OrderController.getorders(ctx, connectionPool));

        // Virker ikke korrekt endnu.
        app.get("/createuser", ctx -> ctx.render("createuser.html"));
        app.post("/createuser",ctx -> UserController.createuser(ctx, connectionPool ));



        app.get("/updatedhomepage", ctx -> ctx.render("cupcakes.html"));
        app.post("/addToCart", ctx-> CartController.addToCart(ctx, connectionPool));
    }
}