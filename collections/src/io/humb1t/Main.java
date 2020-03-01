package io.humb1t;

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
                .filter(order -> order.number >= 50)
                .forEach(order -> System.out.println(order.toString()));

        for (Order order : orders) {
            System.out.println(order.toString());
        }
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();){
            System.out.println(iterator.next().toString());
        }

        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }


    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;
//        Add numeric field to Order class, use it to filter collection of orders by some criteria (more than 50 order items for example).
        public int number;

        public Order(OrderStatus status) {
            this.status = status;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }
}
