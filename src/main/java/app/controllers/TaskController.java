package app.controllers;

import app.entities.Task;
import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.TaskMapper;
import io.javalin.http.Context;

import java.util.List;

public class TaskController
{
    public static void addtask(Context ctx, ConnectionPool connectionPool)
    {
        User user = ctx.sessionAttribute("currentUser");
        String taskName = ctx.formParam("addtask");
        try
        {
            Task newTask = TaskMapper.addTask(user, taskName, connectionPool );
            List<Task> taskList = TaskMapper.getAllTasksPerUser(user.getId(), connectionPool);
            ctx.attribute("taskList", taskList);
            ctx.render("tasks.html");
        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }
    }

    public static void done(Context ctx, boolean done, ConnectionPool connectionPool)
    {
        int taskId = Integer.parseInt(ctx.formParam("task_id"));
        String taskName= ctx.formParam("data-name");
        try
        {
            User user = ctx.sessionAttribute("currentUser");
            TaskMapper.setDoneTo(done, taskId, connectionPool);
            List<Task> taskList = TaskMapper.getAllTasksPerUser(user.getId(), connectionPool);
            ctx.attribute("taskList", taskList);
            ctx.render("tasks.html");

        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }

    }

    public static void delete(Context ctx, ConnectionPool connectionPool)
    {
        int taskId = Integer.parseInt(ctx.formParam("task_id"));
        try
        {
            User user = ctx.sessionAttribute("currentUser");
            TaskMapper.delete(taskId, connectionPool);
            List<Task> taskList = TaskMapper.getAllTasksPerUser(user.getId(), connectionPool);
            ctx.attribute("taskList", taskList);
            ctx.render("tasks.html");

        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }
    }

    public static void edit(Context ctx, ConnectionPool connectionPool)
    {
        int taskId = Integer.parseInt(ctx.formParam("task_id"));
        try
        {
            Task task = TaskMapper.getTaskById(taskId, connectionPool);
            ctx.attribute("task", task);
            ctx.render("edittask.html");
        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }
    }

    public static void update(Context ctx, ConnectionPool connectionPool)
    {
        int taskId = Integer.parseInt(ctx.formParam("task_id"));
        String taskName = ctx.formParam("task_name");
        try
        {
            TaskMapper.update(taskId, taskName, connectionPool);
            User user = ctx.sessionAttribute("currentUser");
            List<Task> taskList = TaskMapper.getAllTasksPerUser(user.getId(), connectionPool);
            ctx.attribute("taskList", taskList);
            ctx.render("tasks.html");
        }
        catch (DatabaseException e)
        {
            ctx.attribute("message", e.getMessage());
            ctx.render("index.html");
        }




    }
}
