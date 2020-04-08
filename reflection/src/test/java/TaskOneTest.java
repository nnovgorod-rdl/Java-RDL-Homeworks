import io.humb1t.CurrentClass;
import io.humb1t.DepCurrentClass;
import io.humb1t.Task1Implementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class TaskOneTest extends Assert {
     public static List<Object> listOfObject = new ArrayList<>(5);

    @Before
    public void setUpList() {
        listOfObject.add(new CurrentClass());
        listOfObject.add(new DepCurrentClass());
    }

    @Test
    public void testTaskOneTest() {
        Task1Implementation task1Implementation = new Task1Implementation();
        try {
            task1Implementation.filterMethod(listOfObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(task1Implementation.list.size(), 1);
    }
}