import io.humb1t.Task1Implementation;
import io.humb1t.Task2Implementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskTwoTest extends Assert {
    public static List<Object> listOfObject = new ArrayList<>(5);
    @Before
    public void setUpList() {
       listOfObject.add(new DepCurrentClass());
    }
    @Test
    public void testTaskTwoTest() {
        Task2Implementation task2Implementation = new Task2Implementation();
        try {
            task2Implementation.filterMethod(listOfObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(task2Implementation.notDepricatedClasses.size()+task2Implementation.notDepricatedInterfaces.size(), 1);
    }
}
