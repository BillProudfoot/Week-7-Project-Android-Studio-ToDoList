package example.codeclan.com.todolist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 23/04/2017.
 */

public class TaskTest {

    Task task;

    @Before
    public void before() { task = new Task("High","Cut Hedge", "Front hedge needs trimming", R.drawable.chore, false, "");}

    @Test
    public void getPriorityTest(){
        assertEquals("High", task.getPriority());
    }

    @Test
    public void getToDoTest(){
        assertEquals("Cut Hedge", task.getTask());
    }

    @Test
    public void getDetailTest(){
        assertEquals("Front hedge needs trimming", task.getDetail());
    }

}
