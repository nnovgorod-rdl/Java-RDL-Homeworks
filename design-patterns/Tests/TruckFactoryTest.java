import Factory.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class TruckFactoryTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }


    @Test
    public void testMakeTruck() throws Exception {
        TruckFactory trnew = new TruckFactory();
        Truck lorry = trnew.makeTruck(KindOfTruck.LORRY);
        Truck wagon = trnew.makeTruck(KindOfTruck.WAGON);
        Truck minivan = trnew.makeTruck(KindOfTruck.MINIVAN);
        String nameOfThreeClassTogether = "LorryWagonMinivan";
        String actualNmaeofThreeClass = lorry.getClass().getSimpleName()+wagon.getClass().getSimpleName()+minivan.getClass().getSimpleName();
        assertEquals(nameOfThreeClassTogether, actualNmaeofThreeClass);
    }

}
