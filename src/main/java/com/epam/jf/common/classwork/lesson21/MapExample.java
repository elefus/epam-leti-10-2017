package com.epam.jf.common.classwork.lesson21;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println(map);

        System.out.println(map.put(1, "AA"));
        System.out.println(map);

        System.out.println(map.remove(3));
        System.out.println(map.remove(2));

        String value = map.get(4);
        if (value == null) {
            value = "Default";
        }
        System.out.println(map.getOrDefault(4, "Default"));

        map.replace(1, "AAA");
        System.out.println(map);

        map.replace(1, "AAA", "AAAA");
        System.out.println(map);

        map.replace(1, "AAA", "AAAAA");
        System.out.println(map);

        map.computeIfAbsent(2, integer -> integer.toString());
        map.computeIfAbsent(2, integer -> "!@#");
        System.out.println(map);

        map.computeIfPresent(2, (key, oldValue) -> "!@#");
        System.out.println(map);

        map.computeIfPresent(2, (key, oldValue) -> null);
        System.out.println(map);

        map.compute(4, (key, oldValue) -> "4");
        System.out.println(map);

        map.merge(4, "4", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);

        map.forEach((key, mapValue) -> System.out.println(key + " | " + mapValue));

        Map<Integer, String> anotherMap = new HashMap<>(33);
        anotherMap.put(1, "B");
        anotherMap.put(2, "C");

        Map<Integer, String> result = new HashMap<>(map);
        anotherMap.forEach((key, val) -> result.merge(key, val, (oldVal, newVal) -> oldVal + newVal));
        System.out.println(result);


        Map<Integer, Integer> map1 = new HashMap<>(4, 1);
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
        map1.put(4, 4);
        map1.put(5, 5);


        Map<String, Integer> lhm = new LinkedHashMap<>(16, 0.75f, true);
        lhm.put("Smith", 30);
        lhm.put("Anderson", 31);
        lhm.put("Lewis", 29);
        lhm.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + lhm.get("Lewis"));
        System.out.println(lhm);


        System.getProperties().forEach((key, val) -> System.out.println(key + " = " + val));
    }
}
