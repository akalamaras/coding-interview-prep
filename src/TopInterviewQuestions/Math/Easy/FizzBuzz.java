package TopInterviewQuestions.Math.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            if(i % 3 == 0)
                sb.append("Fizz");
            if(i % 5 == 0)
                sb.append("Buzz");
            if(sb.length() == 0)
                sb.append(i);

            list.add(sb.toString());
        }
        return list;
    }

    public List<String> fizzBuzzJazz(int n) {

        List<String> list = new ArrayList<>();
        HashMap<Integer,String> dictionary = new HashMap<>() {{
            put(3,"Fizz");
            put(5,"Buzz");
            put(7,"Jazz");
        }};

        for(int i = 1; i <= n; i++) {

            StringBuilder sb = new StringBuilder();

            for(Integer key : dictionary.keySet()) {
                if(n % key == 0)
                    sb.append(dictionary.get(key));
            }

            if(sb.length() == 0)
                sb.append(i);

            list.add(sb.toString());
        }
        return list;
    }
}
