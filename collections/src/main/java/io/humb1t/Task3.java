package io.humb1t;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/*
 * 3. Imagine the situation - you need to implement queue) of incoming requests, to process incoming requests we have 3 independent "processors".
 * How can we design our application in such a case and what pros and cons we would face in different approaches?
 * Write down your thoughts and implement one possible solution.
  for implementation that functional ia can use ConcurrentLinkedQueueExample
 */
class Task3 {
    public void main3() {
        Queue<Request> queue = new ConcurrentLinkedQueue<Request>();
        //or we can use normal list of request, but mark this list like synchronized or create synchronized ArrayList:
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
    }
    class Request{}
}