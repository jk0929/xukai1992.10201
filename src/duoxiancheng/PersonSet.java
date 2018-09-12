package duoxiancheng;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xk
 * @Date: 2018/9/11
 * @Version 1.0
 * 这个是一个线程安全的类
 */
public class PersonSet {
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
}
