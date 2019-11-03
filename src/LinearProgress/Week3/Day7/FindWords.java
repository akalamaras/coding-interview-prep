package LinearProgress.Week3.Day7;

import java.util.*;

public class FindWords {

    HashSet<Character> firstRow;
    HashSet<Character> secondRow;
    HashSet<Character> thirdRow;

    public FindWords() {

        firstRow = new HashSet<>();
        firstRow.add('q'); firstRow.add('w'); firstRow.add('e');
        firstRow.add('r'); firstRow.add('t'); firstRow.add('y');
        firstRow.add('u'); firstRow.add('i'); firstRow.add('o');
        firstRow.add('p');
        secondRow = new HashSet<>();
        secondRow.add('a'); secondRow.add('s'); secondRow.add('d');
        secondRow.add('f'); secondRow.add('g'); secondRow.add('h');
        secondRow.add('j'); secondRow.add('k'); secondRow.add('l');
        thirdRow = new HashSet<>();
        thirdRow.add('z'); thirdRow.add('x'); thirdRow.add('c');
        thirdRow.add('v'); thirdRow.add('b'); thirdRow.add('n');
        thirdRow.add('m');

    }

    private List<String> findWords( String[] words) {
        List<String> ret = new ArrayList<>();
        for(String w: words) {
            if( onlyOne(w,firstRow) || onlyOne(w,secondRow) || onlyOne(w,thirdRow)) ret.add(w);
        }
        return ret;
    }

    public String[] findWordsString(String[] words) {
        String[] array = new String[words.length];
        int i = 0;
        for(String w : words) {
            if( onlyOne(w,firstRow) || onlyOne(w,secondRow) || onlyOne(w,thirdRow)) {
                array[i] = w;
                i++;
            }
        }
        String[] ret = Arrays.copyOfRange(array,0,i);
        return ret;
    }

    private boolean onlyOne(String word, HashSet<Character> row) {
        word = word.toLowerCase();
        for(int i=0;i<word.length();i++) {
            if(!row.contains(word.charAt(i))) return false;
        }
        return true;
    }



    public static void main(String[] args) {

        FindWords f = new FindWords();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        List<String> list = f.findWords(words);
        for(String l : list) System.out.println(l);
    }
}
