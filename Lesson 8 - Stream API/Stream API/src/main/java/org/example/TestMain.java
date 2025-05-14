package src.main.java.org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        Consumer<Integer> consumer =
                num -> {
                    System.out.println(num);
                };

        consumer.consume(10);

        Predicate<Integer> evenPredicate = num -> num % 2 == 0;
        System.out.println(
                filter(
                        List.of(1, 2, 3, 4, 5, 6),
                        evenPredicate
                ));

        System.out.println(
                map(
                        List.of(
                                "askbd", "v", "vbajs", "abc", "phjkasnd"
                        ),
                        TestMain::mapper
                )
        );



    }

    public static int mapper(String text) {
        System.out.println(text);

        return text.length();
    }

    public static <T> List<T> filter(Collection<T> data,
                                     Predicate<T> predicate) {
        List<T> res = new ArrayList<>();

        for (T item : data) {
            if (predicate.check(item)) {
                res.add(item);
            }
        }

        return res;
    }

    public static <T, R> List<R> map(Collection<T> data,
                                     Function<T, R> mapper) {
        List<R> res = new ArrayList<>();

        for (T item : data) {
            R mappedItem = mapper.map(item);

            res.add(mappedItem);
        }

        return res;
    }
}
