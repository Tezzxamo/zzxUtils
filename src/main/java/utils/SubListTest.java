package utils;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        List<String> list1 = list.subList(0, list.size());
        System.out.println(list1);

        List<List<String>> lists = new ArrayList<>();
        int number = (int) Math.ceil((double) list.size() / 2);
        for (int i = 0; i < number; i++) {
            System.out.println(number);
            System.out.println("i:" + i);
            if (i + 1 == number) {
                lists.add(list.subList(i * 2, list.size()));
            } else {
                lists.add(list.subList(i * 2, (i + 1) * 2));
            }
        }
        System.out.println(lists);

    }
}
