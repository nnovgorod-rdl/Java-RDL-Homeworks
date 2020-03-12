import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = Collections.EMPTY_LIST;
        List<String> list = new ArrayList<>(c);
        Main.Order orderer = new Main.Order(OrderStatus.COMPLETED);
        List<Order> orders = Collections.singletonList(orderer);

        orders.stream()
                //Method references and Streams
                .filter(Order::myChecker) //do something
                .forEach(order -> System.out.println(order.toString()));

        for (Order order : orders) {
            if (order.numberOfOrder >= 50) {
                //do something
            }
            System.out.println(order.toString());
        }
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next().toString());
        }

        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order implements OrderFactory {
        public final OrderStatus status;
        public int numberOfOrder;


        /*
        Create new interface called OrderFactory.
        Interface should provide methods for creation of Orders with different OrderStatuses.
        For each status create default method. What method should provide implementation of this interface? Write your own implementation.
        i dont understand, what you want from me. Maybe i need implements pattern Factory, then implementation below:
        */
        public Order orderFactory(int chapter) {
            Order createdOrder = null;
            if (chapter == 1) {
                createdOrder = orderCreatedNOT_STARTED();
            } else if (chapter == 2) {
                createdOrder = orderCreatedPROCESSING();
            } else if (chapter == 3) {
                createdOrder = orderCreatedCOMPLETED();
            }
            return createdOrder;
        }

        public Order(OrderStatus status) {
            this.status = status;
        }

        public boolean myChecker() {
            return this.numberOfOrder % 2 == 0;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }
}