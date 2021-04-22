package com.arthur.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

//        map.forEach((id, val) -> System.out.print(val));//val0 val1 val2 val3 val4 val5 val6 val7 val8 val9
        System.out.println(map);
        System.out.println();
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));             // val33

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));     // false

        System.out.println(map);

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));    // true
        System.out.println(map.get(23));

        map.computeIfAbsent(33, num -> "val");
        System.out.println(map.get(3));             // val33

        System.out.println(map);


//        在Map里删除一个键值全都匹配的项
        map.remove(3, "val3");
        System.out.println(map.get(3));             // val33
        map.remove(3, "val33");
        System.out.println(map.get(3));             // null
        System.out.println(map);

        map.getOrDefault(42, "not found");  // not found

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
        System.out.println(map);
    }
}
