package example.codeclan.com.todolist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 23/04/2017.
 */

public class ToDoTest {

    ToDo toDo;

    @Before
    public void before() { toDo = new ToDo(4,"Cut Hedge", "Front hedge needs trimming", R.drawable.chore);}

    @Test
    public void getPriorityTest(){
        assertEquals((Integer)4, toDo.getPriority());
    }

    @Test
    public void getToDoTest(){
        assertEquals("Cut Hedge", toDo.getTodo());
    }
    

}
