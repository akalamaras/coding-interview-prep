package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {

        TimeMap kv = new TimeMap();

        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));
    }

    static class TimeMap {

        private HashMap<String, Set<String>> keyValuePairs;
        private HashMap<Integer, Set<String>> timestampValuePairs;

        /** Initialize your data structure here. */
        public TimeMap() {

            keyValuePairs = new HashMap<>();
            timestampValuePairs = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            // key value pair
            Set<String> set = keyValuePairs.getOrDefault(key, new HashSet<>());
            set.add(value);
            keyValuePairs.put(key, set);

            // timestamp value par
            Set<String> set3 = timestampValuePairs.getOrDefault(timestamp, new HashSet<>());
            set3.add(value);
            timestampValuePairs.put(timestamp, set3);
        }

        public String get(String key, int timestamp) {

            Set<String> potentialValues = keyValuePairs.get(key);
            if(potentialValues == null || potentialValues.isEmpty())
                return "";

            for(int i = timestamp; i >= 0; i--) {

                Set<String> values = timestampValuePairs.get(i);
                if(values != null && !values.isEmpty()) {
                    for (String s : values)
                        if (potentialValues.contains(s))
                            return s;
                }
            }
            return "";
        }
    }
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
