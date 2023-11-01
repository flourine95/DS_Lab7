package set_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMyPredicates {
    public static void main(String[] args) {

        /*
        I try initialization list with asList so get error "remove" and
        I realized but asList return unmodifiableList
        List<Integer> list = Arrays.asList(1, 2, 4, 6, 5, 2);
        */
        List<Integer> list = new  ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        System.out.println("TEST REMOVE");
        MyPredicates.remove(list, new Even());
        list.forEach(System.out::println);
        list.clear();


        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        System.out.println("TEST RETAIN");
        MyPredicates.retain(list, new Even());
        list.forEach(System.out::println);
        list.clear();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        System.out.println("TEST COLLECT");
        MyPredicates.collect(list, new Even()).forEach(System.out::println);
        list.clear();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        System.out.println("TEST FIND");
        System.out.println(MyPredicates.find(list, new Even()));

    }
}
