import com.sun.org.apache.xpath.internal.operations.Or;
import io.humb1t.Main;
import io.humb1t.Task2;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task2test {
    static List<Main.Order> list = new ArrayList<>();

    @BeforeClass
    public static void beforeClass() {
        Main.Order order1 = new Main.Order(Main.OrderStatus.COMPLETED);
        Main.Order order2 = new Main.Order(Main.OrderStatus.COMPLETED);
        Main.Order order3 = new Main.Order(Main.OrderStatus.COMPLETED);
        Main.Order order4 = new Main.Order(Main.OrderStatus.COMPLETED);
        order1.numberOfOrder = 40;
        order2.numberOfOrder = 60;
        order3.numberOfOrder = 70;
        order4.numberOfOrder = 80;
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
    }

    @Test
    public void testMain1Filter() throws Exception {
        assertEquals(3, new Task2().main2());
    }
}
