package io.humb1t.functional.factory;

import io.humb1t.OrderStatus;

/*
Как уже обсуждали, использовать optional на вход метода или как поле не очень хорошая идея.
Еще раз повторю, что писал, там где использовал Optional в конструкторе:

        We use Optional for return values, is it a good idea to use it as
        incoming parameters? Write down your thoughts.

        В данном применении Optional, есть как плюсы, так и минусы. По поводу этого даже, как я понял, идет "холивар".

        Плюсы: можно сделать значение метода, в том числе, конструктора (он ведь тоже метод) по умолчанию.
        Минус - более "громозкий" код.

        Самый "потрясный" топик - https://ru.stackoverflow.com/a/825409 - полностью согласен с автором

Плюс хотелось бы видеть три различных дефотных метода для каждого из состояний в фабрике

Сделал три дефолтных метода.
 */

public interface OrderFactory {
    default OrderForFactory createOrder(OrderStatus orderStatus, int itemsInOrderForFactory) {
        switch (orderStatus) {
            case NOT_STARTED:
                return (OrderForFactory) createOrderNotStarted(itemsInOrderForFactory);

            case PROCESSING:
                return (OrderForFactory) createOrderProcessing(itemsInOrderForFactory);

            case COMPLETED:
                return (OrderForFactory) createOrderCompleted(itemsInOrderForFactory);
        }
        /*
        Если ничего не подходит null
         */
        return null;
    }

    default OrderFactory createOrderNotStarted(int itemsInOrderForFactory) {
        return new OrderForFactory(OrderStatus.NOT_STARTED, itemsInOrderForFactory);
    }

    default OrderFactory createOrderCompleted(int itemsInOrderForFactory) {
        return new OrderForFactory(OrderStatus.COMPLETED, itemsInOrderForFactory);
    }

    default OrderFactory createOrderProcessing(int itemsInOrderForFactory) {
        return new OrderForFactory(OrderStatus.PROCESSING, itemsInOrderForFactory);
    }
}
