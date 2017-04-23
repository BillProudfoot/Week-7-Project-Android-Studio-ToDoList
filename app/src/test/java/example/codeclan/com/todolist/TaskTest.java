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
    public void before() { task = new Task(4,"Cut Hedge", "Front hedge needs trimming", R.drawable.chore);}

    @Test
    public void getPriorityTest(){
        assertEquals((Integer)4, task.getPriority());
    }

    @Test
    public void getToDoTest(){
        assertEquals("Cut Hedge", task.getTodo());
    }

    @Test
    public void getDetailTest(){
        assertEquals("Front hedge needs trimming", task.getDetail());
    }

}
