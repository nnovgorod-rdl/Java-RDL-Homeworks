package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.humb1t.Task5.main5;

public class Main {
    public static List<Order> orders;
    public static void main(String[] args) {
        main5();
//        Collection<String> c = Collections.EMPTY_LIST;
//        List<String> list = new ArrayList<>(c);
//        Main.Order orderer = new Main.Order(OrderStatus.COMPLETED);
//        orders = Collections.singletonList(orderer);
////2.Add numeric field to Order class, use it to filter collection of orders by some criteria (more than 50 order items for example).
//        orders.stream()
//                .filter(order -> order.numberOfOrder >= 50) //do something
//                .forEach(order -> System.out.println(order.toString()));
//
//        for (Order order : orders) {
//            if(order.numberOfOrder>=50)
//            {
//                //do something
//            }
//            System.out.println(order.toString());
//        }
//        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();){
//            System.out.println(iterator.next().toString());
//        }
//
//        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
//                .collect(Collectors.groupingBy(Order::getStatus));
    }


    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;
        public int numberOfOrder;

        public Order(OrderStatus status) {
            this.status = status;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }



}

/*
* 1. Open io.humb1t.Main.java and compare different approaches in iterations. Write down your thoughts, what is your favourite option? Which one is easier to read and which one is easier to write? Why?
*         for (Order order : orders) {
            System.out.println(order.toString());
        }
        * this is my favorit option for iteration collections
        * Rthis option is easer to write and read, I use this option offer than others!
        *
        *
* */

/*
* 3. Imagine the situation - you need to implement queue) of incoming requests, to process incoming requests we have 3 independent "processors".
* How can we design our application in such a case and what pros and cons we would face in different approaches?
* Write down your thoughts and implement one possible solution.

* for implementation that functional ia can use ConcurrentLinkedQueueExample
*  Queue<Request> queue = new ConcurrentLinkedQueue<Request>();
* or we can use normal list of request, but mark this list like synchronized or create synchronized ArrayList:
* Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>())
*
 * */

/*
* 5.There is an old war between ArrayList and Linked List - choose new fighters and implement your own benchmark (Vector vs Queue for example). Write down your thoughts.
i declare war between ArrayList and all others collection
* ArrayList is very easy to understanding, most often used, does not have unnecessary and confusing functionality
 * */

/*
6. Map is very good in implementation of simple caches). Implement your own cache using Map.
For exemle, is wery simple Exemple:
we put in map some Object, and we take Objects according to a certain sign
HasheMap <Object, Object> cache = new HasheMap();
cache.put("one", 1);
cache.put("str", "Some string");
assertEquals(new Integer(1), cache.get("one", Integer.class));
assertEquals("Some string", cache.get("str", String.class));
*/