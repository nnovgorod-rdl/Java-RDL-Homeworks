package io.humb1t;

import java.util.*;

//2.Add numeric field to Order class, use it to filter collection of orders by some criteria (more than 50 order items for example).
public class Task2 {
    public static List<io.humb1t.Main.Order> orders;
    public void main2() {
        io.humb1t.Main.Order orderer = new io.humb1t.Main.Order(io.humb1t.Main.OrderStatus.COMPLETED);
        orders = Collections.singletonList(orderer);
        orders.stream()
                .filter(order -> order.numberOfOrder >= 50)
                .forEach(order -> System.out.println(order.toString()));
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final io.humb1t.Main.OrderStatus status;
        //Added numeric field
        public int numberOfOrder;
        public Order(io.humb1t.Main.OrderStatus status) {
            this.status = status;
        }
        public io.humb1t.Main.OrderStatus getStatus() {
            return status;
        }
    }
}

