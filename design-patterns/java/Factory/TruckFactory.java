package Factory;

public class TruckFactory {
    public Truck makeTruck(KindOfTruck kind) {
        Truck toReturn = null;
        switch (kind) {
            case WAGON:
                toReturn = new Wagon();
                break;
            case LORRY:
                toReturn = new Lorry();
                break;
            case MINIVAN:
                toReturn = new Minivan();
                break;
            default:
                throw new IllegalArgumentException("Net takoi mashina: " + kind);
        }
        return toReturn;
    }
}
