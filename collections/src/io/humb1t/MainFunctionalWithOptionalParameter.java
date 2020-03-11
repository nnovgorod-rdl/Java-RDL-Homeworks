package io.humb1t;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MainFunctionalWithOptionalParameter {
    enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static void main(String[] args) {
        /*
        Modify your Order class, create method which would return boolean depends
        on the value of numeric field (which was added in previous task).
        Modify your filter algorithm, use new method and Streams API.
         */

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(OrderStatus.COMPLETED, Optional.of(70)));
        orders.add(new Order(OrderStatus.NOT_STARTED, Optional.of(30)));
        orders.add(new Order(OrderStatus.PROCESSING, Optional.of(5)));
        orders.add(new Order(OrderStatus.NOT_STARTED, Optional.of(100)));
        orders.add(new Order(OrderStatus.NOT_STARTED, Optional.of(29)));
        orders.add(new Order(OrderStatus.COMPLETED, Optional.of(51)));
        orders.add(new Order(OrderStatus.PROCESSING, Optional.of(73)));
        orders.add(new Order(OrderStatus.NOT_STARTED, Optional.of(3)));
        orders.add(new Order(OrderStatus.COMPLETED, Optional.of(1)));
        orders.add(new Order(OrderStatus.COMPLETED, Optional.empty()));

        orders.stream()
                .filter(order -> order.moreThenFiftyItemInOrder(order))
                .forEach(order -> System.out.println(order.toString()));
    }

    static class Order {
        public final OrderStatus status;
        private int itemsInOrder;

        /*
        We use Optional for return values, is it a good idea to use it as
        incoming parameters? Write down your thoughts.

        В данном применении Optional, есть как плюсы, так и минусы. По поводу этого даже, как я понял, идет "холивар".
        Вот что лично я думаю. Нужно решать использовать Optional,
        Плюсы: можно сделать значение метода, в том числе, конструктора (он ведь тоже метод) по умолчанию.
        Минус - более "громозкий" код.
        Самый "потрясный" топик - https://ru.stackoverflow.com/a/825409 - полностью согласен с автором
         */

        public Order(OrderStatus status, Optional<Integer> optionalInteger) {
            int itemsInOrderForCreate= optionalInteger.orElse(1);

            if (status == null || itemsInOrderForCreate == 0) {
                throw new IllegalArgumentException();
            }

            this.status = status;
            this.itemsInOrder = itemsInOrderForCreate;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public int getItemsInOrder() {
            return itemsInOrder;
        }

        public boolean moreThenFiftyItemInOrder(Order order) {
            return order.getItemsInOrder() > 50;
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