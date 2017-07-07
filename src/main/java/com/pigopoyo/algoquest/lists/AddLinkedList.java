package com.pigopoyo.algoquest.lists;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Gopiraj Dorairaj on 7/7/2017.
 */
public class AddLinkedList {

    public LinkedList<Integer> addTwoLists(LinkedList<Integer> pFirst,
                                           LinkedList<Integer> qSecond) {

        ListIterator<Integer> pFirstIterator = pFirst.listIterator();
        ListIterator<Integer> qSecondIterator = qSecond.listIterator();
        LinkedList<Integer> finalList = new LinkedList<>();
        int sum = 0;
        while (pFirstIterator.hasNext() || qSecondIterator.hasNext()) {
            sum = sum / 10;

            if (pFirstIterator.hasNext()) {
                sum = sum + pFirstIterator.next();
            }
            if (qSecondIterator.hasNext()) {
                sum = sum + qSecondIterator.next();
            }
            finalList.add(sum%10);
        }
        if (sum/10 > 0) {
            finalList.add(sum/10);
        }
        return finalList;
    }
}
