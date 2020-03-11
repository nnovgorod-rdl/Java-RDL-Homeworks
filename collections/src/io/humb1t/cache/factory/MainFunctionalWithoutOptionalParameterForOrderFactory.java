package io.humb1t.cache.factory;

import io.humb1t.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class MainFunctionalWithoutOptionalParameterForOrderFactory {
    public static void main(String[] args) {

        /*
        Скорее всего я не понял задание
        Create new interface called OrderFactory. Interface should provide methods for creation of Orders with different
        OrderStatuses. For each status create default method. What method should provide implementation of this
        interface? Write your own implementation.

        Подсказочку бы... :-)
         */
        OrderFactory orderFactory = new OrderFactory() {
        };

        List<OrderForFactory> orders = new ArrayList<>();
        orders.add(orderFactory.createOrder(OrderStatus.COMPLETED, 70));
        orders.add(orderFactory.createOrder(OrderStatus.NOT_STARTED, 30));
        orders.add(orderFactory.createOrder(OrderStatus.PROCESSING, 5));
        orders.add(orderFactory.createOrder(OrderStatus.NOT_STARTED, 100));
        orders.add(orderFactory.createOrder(OrderStatus.NOT_STARTED, 29));
        orders.add(orderFactory.createOrder(OrderStatus.COMPLETED, 51));
        orders.add(orderFactory.createOrder(OrderStatus.PROCESSING, 73));
        orders.add(orderFactory.createOrder(OrderStatus.NOT_STARTED, 3));
        orders.add(orderFactory.createOrder(OrderStatus.COMPLETED, 1));
//        orders.add(orderFactory.createOrder(OrderStatus.COMPLETED, -3));

        orders.stream()
                .filter(order -> order.moreThenFiftyItemInOrder(order))
                .forEach(order -> System.out.println(order.toString()));
    }

}