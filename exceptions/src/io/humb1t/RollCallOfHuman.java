package io.humb1t;

import java.util.ArrayList;

/*
Create your own implementation of java.lang.AutoCloseable interface. Test it.
Не пойму, как только потом проверить, закрылось все таки или нет...
А в интернете как это проверить не нахожу :-(
 */

public class RollCallOfHuman implements AutoCloseable {

     void rollCall() {
        ArrayList<Human> humanArrayList = new ArrayList<>();
        humanArrayList.add(new Human(10, Gender.MALE));
        humanArrayList.add(new Human(15, Gender.FEMALE));
        humanArrayList.add(new Human(20, Gender.MALE));
        humanArrayList.add(new Human(33, Gender.FEMALE));
        humanArrayList.add(new Human(40, Gender.MALE));
        humanArrayList.add(new Human(29, Gender.FEMALE));
        humanArrayList.add(new Human(16, Gender.MALE));
        humanArrayList.add(new Human(18, Gender.FEMALE));
        humanArrayList.add(new Human(10, Gender.MALE));
        humanArrayList.add(new Human(22, Gender.FEMALE));

        for (int i = 0; i < humanArrayList.size(); i++) {
            System.out.println("I am Human number " + (i + 1));
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource RollCallOfHuman");
    }
}
