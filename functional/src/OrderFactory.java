public interface OrderFactory {
    default Main.Order orderCreatedNOT_STARTED() {
        return new Main.Order(Main.OrderStatus.NOT_STARTED);
    }

    default Main.Order orderCreatedPROCESSING() {
        return new Main.Order(Main.OrderStatus.PROCESSING);
    }

    default Main.Order orderCreatedCOMPLETED() {
        return new Main.Order(Main.OrderStatus.COMPLETED);
    }
}
