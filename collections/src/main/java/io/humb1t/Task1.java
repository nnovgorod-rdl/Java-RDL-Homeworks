package io.humb1t;

import static io.humb1t.Main.orders;

public class Task1 {
    /* 1. Open io.humb1t.Main.java and compare different approaches in iterations.
    Write down your thoughts, what is your favourite option? Which one is easier to read and which one is easier to write? Why?*/
    public void main1() {
        for (Main.Order order : orders) {
            System.out.println(order.toString());
        }
        /* this is my favorite option for iteration collections
         * Read this option is easier to write and read, I use this option offer than others!
         */
    }
}
