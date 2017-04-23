package example.codeclan.com.todolist;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 23/04/2017.
 */

public class TopToDosTest {

    @Test
    public void getListTest(){
        TopToDos topToDos = new TopToDos();
        assertEquals(3, topToDos.getList().size());
    }
}
