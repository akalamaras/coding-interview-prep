package Companies.Uber.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> lines = new ArrayList<>();

        int index = 0;
        while(index < words.length) {

            int count = words[index].length();
            int last = count + 1;
            while(last < words.length) {

                if(words[last] .length() + count + 1 > maxWidth)
                    break;

                count += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);

            int difference = last - index - 1;

            // Left Justified
            if(last == words.length || difference == 0) {

                for(int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i = sb.length(); i < maxWidth; i++)
                    sb.append(" ");

            } else {
                // Middle Justified
                int spaces = (maxWidth - count) / difference;
                int r = (maxWidth - count) % difference;

                for(int i = index + 1; i < last; i++) {

                    for(int k = spaces; k > 0; k--)
                        sb.append(" ");

                    if(r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
}
