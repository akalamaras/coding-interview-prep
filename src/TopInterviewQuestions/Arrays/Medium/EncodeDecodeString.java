package TopInterviewQuestions.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {

            if(strs.size() == 0)
                return Character.toString((char) 258);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < strs.size(); i++) {
                sb.append(strs.get(i));
                if(i < strs.size() - 1)
                    sb.append((char) 257);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {

            if(s.equals(Character.toString((char) 258)))
                return new ArrayList<>();

            return Arrays.asList(s.split(Character.toString((char) 257), -1));
        }
    }
}
