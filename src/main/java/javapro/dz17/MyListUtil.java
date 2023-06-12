package javapro.dz17;

import java.util.ArrayList;
import java.util.List;

public class MyListUtil {
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();

        for (T element : array) {
            list.add(element);
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = MyListUtil.toList(array);
        System.out.println(list);
    }
}
