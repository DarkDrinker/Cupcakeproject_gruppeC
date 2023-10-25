package app.entities;

public class Task
{
    private int id;
    private String name;
    private boolean done;
    private int userId;

    public Task(int id, String name, boolean done, int userId)
    {
        this.id = id;
        this.name = name;
        this.done = done;
        this.userId = userId;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isDone()
    {
        return done;
    }

    public int getUserId()
    {
        return userId;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done=" + done +
                ", userId=" + userId +
                '}';
    }
}
