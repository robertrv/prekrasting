package org.kata;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rramirez
 * Date: 10/24/13
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class HumanTowers {
    public int level(List<Person> persons) {
        System.out.println("Going with: " + persons);
        if(persons.size() < 2)
            return persons.size();
        else {
            Collections.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if(o1.getHeight() < o2.getHeight())
                        return -1;
                    else if(o1.getHeight() > o2.getHeight())
                        return 1;
                    else return 0;
                }
            });

            System.out.println("After sorting: " + persons);

            Person person1 = persons.get(0);
            Person person2 = persons.get(1);

            if (person1.compatible(person2)) {
                return level(persons.subList(0, persons.size() -1));
            }

            return persons.size();
        }
    }
}
