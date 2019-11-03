package LinearProgress.Week5.Day7;


import java.util.*;


public class RepeatedDNASequences {

    public List<String> findRepeatedDNASequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args) {

        RepeatedDNASequences dna = new RepeatedDNASequences();
        List<String> list = dna.findRepeatedDNASequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for(String n: list)
            System.out.println(n);
    }
}
