package io.humb1t;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = Collections.EMPTY_LIST;
        List<String> list = new ArrayList<>(c);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(OrderStatus.COMPLETED, 70));
        orders.add(new Order(OrderStatus.NOT_STARTED, 30));
        orders.add(new Order(OrderStatus.PROCESSING, 5));
        orders.add(new Order(OrderStatus.NOT_STARTED, 100));
        orders.add(new Order(OrderStatus.NOT_STARTED, 29));
        orders.add(new Order(OrderStatus.COMPLETED, 51));
        orders.add(new Order(OrderStatus.PROCESSING, 73));
        orders.add(new Order(OrderStatus.NOT_STARTED, 3));
        orders.add(new Order(OrderStatus.COMPLETED, 1));

        orders.stream()
                .filter(order -> order.status == OrderStatus.COMPLETED)
                .forEach(order -> System.out.println(order.toString()));
        System.out.println("__________");
        System.out.println("");


        /* Вопрос 2 - Collections
        Отбор заказов где itemsInOrder >=50
         */
        orders.stream()
                .filter(order -> order.getItemsInOrder() >= 50)
                .forEach(order -> System.out.println(order.toString()));
        System.out.println("__________");
        System.out.println("");

        //Ну или так - Вопрос 2  - Collections (но тут сделал меньше 10)
        for (Order order : orders) {
            if (order.getItemsInOrder() < 10) {
                System.out.println(order.toString());
            }
        }
        System.out.println("__________");
        System.out.println("");

        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
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
        private int itemsInOrder;

        public Order(OrderStatus status, int itemsInOrder) {
            if (status == null || itemsInOrder <= 0) {
                throw new IllegalArgumentException();
            }
            this.status = status;
            this.itemsInOrder = itemsInOrder;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public int getItemsInOrder() {
            return itemsInOrder;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "status=" + status +
                    ", itemsInOrder=" + itemsInOrder +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return itemsInOrder == order.itemsInOrder &&
                    status == order.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(status, itemsInOrder);
        }
    }
}


        /* Вопрос 1 - Collections
        Лично мне, пока больше нравиться for, который с (int i = 0...), хотя все чаще, переделываю его на Enhanced for -
        for (Order order : orders). Из здесь представленных больше нравиться Enhanced for. Пока мне его проше писать,
        читать, понимать... Конструкция for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); )
        как я думаю более громозкая и неудобная.
         */

        /* Вопрос 4 - Collections
        Что бы избавиться от дубликатов колекции достаточно просто "запихнуть" ее в Set
         */
