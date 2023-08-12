package javapractice;

import java.util.*;

public class DataStoragePracticeTest {
    public static void main(String[] args) {
        int[] array = new int[3];

        array[0] = 10;
        array[1] = 20;
        array[2] = 30;

        System.out.println(array.length);

        String[] cars = new String[2];

        cars[0] = "BMW";
        cars[1] = "Porsche";
        System.out.println(cars[1]);

        List<Object> shoppingList = new ArrayList<>();
        shoppingList.add("Apple");
        shoppingList.add("Bananas");
        shoppingList.add("Pineapple");
        System.out.println(shoppingList);

        List<Object> abc = new ArrayList<>();
        abc.add("String");
        abc.add(1000);
        abc.add(true);
        System.out.println(abc);
        System.out.println(abc.size());
        abc.remove(2);
        System.out.println(abc);
        System.out.println(abc.contains(1000));

        Map<String, String> friendsWithProfessions = new HashMap<>();
        friendsWithProfessions.put("Adam", "Plumber");
        friendsWithProfessions.put("Alice", "Driver");
        friendsWithProfessions.put("Dylan", "Painter");
        System.out.println(friendsWithProfessions);
        System.out.println(friendsWithProfessions.get("Adam"));
        friendsWithProfessions.remove("Alice");
        System.out.println(friendsWithProfessions);


    }
}
