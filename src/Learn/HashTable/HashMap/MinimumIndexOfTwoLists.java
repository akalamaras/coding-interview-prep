package Learn.HashTable.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Map<String,Integer> map3 = new HashMap<>();


        for(int i = 0; i < list1.length; i++)
            map1.put(list1[i],i);

        for(int i = 0; i < list2.length; i++)
            map2.put(list2[i],i);

        String[] minArray = (list1.length > list2.length) ? list1 : list2;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < minArray.length; i++) {

            if(map1.containsKey(minArray[i]) && map2.containsKey(minArray[i])) {

                map3.put(minArray[i], map1.get(minArray[i]) + map2.get(minArray[i]));
                min = Math.min(min, map3.get(minArray[i]));
            }
        }

        int count = 0;
        for(String key: map3.keySet()) {
            if(map3.get(key) == min)
                count++;
        }

        String[] res = new String[count];
        int i = 0;
        for(Map.Entry entry : map3.entrySet()) {

            String key = (String) entry.getKey();
            System.out.println(key);
            int value = (int) entry.getValue();
            System.out.println(value);

            if(value == min) {
                res[0] = key;
                i++;
            }
        }
        return res;
    }
}
