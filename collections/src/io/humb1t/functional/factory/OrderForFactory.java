package io.humb1t.functional.factory;

import io.humb1t.OrderStatus;

public class OrderForFactory implements OrderFactory {

    private OrderStatus status;
    private int itemsInOrderForFactory;

    public OrderForFactory(OrderStatus status, int itemsInOrderForFactory) {
        if (status == null || itemsInOrderForFactory <= 0) {
            throw new IllegalArgumentException();
        }

        this.status = status;
        this.itemsInOrderForFactory = itemsInOrderForFactory;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getItemsInOrderForFactory() {
        return itemsInOrderForFactory;
    }

    public boolean moreThenFiftyItemInOrder(OrderForFactory order) {
        return order.getItemsInOrderForFactory() > 50;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", itemsInOrder=" + itemsInOrderForFactory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderForFactory order = (OrderForFactory) o;

        if (itemsInOrderForFactory != order.itemsInOrderForFactory) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + itemsInOrderForFactory;
        return result;
    }
}

