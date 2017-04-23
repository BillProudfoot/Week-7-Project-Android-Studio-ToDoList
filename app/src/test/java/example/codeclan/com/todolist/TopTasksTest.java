package example.codeclan.com.todolist;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 23/04/2017.
 */

public class TopTasksTest {

    @Test
    public void getListTest(){
        TopTasks topTasks = new TopTasks();
        assertEquals(3, topTasks.getList().size());
    }
}
