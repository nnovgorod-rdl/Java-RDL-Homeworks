import Decorator.*;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;


public class MakeMatreshkaTest {
    Matreshka matr1 = new Matreshka();
    Matreshka matr2 = new MatrioshkaBlue(new Matreshka());
    Matreshka matr3 = new MatrioshkaRed(new Matreshka());
    Matreshka matr4 = new MatrioshkaPurple(new Matreshka());
    Matreshka matr5 = new BigBlueMatr(new MatrioshkaBlue(new Matreshka()));
    Matreshka matr6 = new BigRedMatr(new MatrioshkaRed(new Matreshka()));


@Test
public void testTatreshkaOne() throws Exception {
    assertEquals(matr1.printName(), " matreshka");
}
    public void testTatreshkaTwo() throws Exception {
        assertEquals(matr2.printName(), " blue matreshka");
    }
    public void testTatreshkaThree() throws Exception {
        assertEquals(matr3.printName(), " red matreshka");
    }
    public void testTatreshkaFour() throws Exception {
        assertEquals(matr4.printName(), " purple matreshka");
    }
    public void testTatreshkaFive() throws Exception {
        assertEquals(matr5.printName(), "Big blue matreshka");
    }
    public void testTatreshkaSix() throws Exception {
        assertEquals(matr6.printName(), "Big red matreshka");
    }
} 
