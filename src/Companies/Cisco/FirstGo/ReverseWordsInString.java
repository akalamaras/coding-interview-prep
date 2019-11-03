package Companies.Cisco.FirstGo;


public class ReverseWordsInString {

    /**
     * Given an input string, reverse the string word by word
     * Your reversed string should not contain leading or trialing spaces
     * You need to reduce multiple spaces between two words to a single space
     *   in the reversed string
     */


    // Approach #1 Mine ( Accepted, O(n) time complexity, O(n) space complexity)
    public String reverseWords(String s) {
        String ret = "";
        // split the string
        String[] split = s.split(" ");
        
        // trim every word
        for(int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        
        for(int i = split.length-1; i >= 0; i--) {
            // a 'word' in split could be "   " so we want to avoid those
            if(split[i].equals("")) continue;
            ret += split[i].trim() + " ";

        }
        return ret.trim();
    }

    // Approach #2 Two Pointers Overkill
    public String reverseWordsOverkill(String s) {
        if(s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1 : Reverse the whole string
        reverse(a,0,n-1);
        // step 2 : Reverse each word
        reverseSingleWords(a,n);
        // step 3 : Clean up spaces
        return cleanSpaces(a,n);
    }

    // reverse a from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while(i < j) {
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }

    private void reverseSingleWords(char[] a, int n) {
        int i = 0, j = 0;

        while(i < n) {
            while(i < j || i < n && a[i] == ' ')
                i++; // skip the spaces
            while(j < i || j < n && a[j] != ' ')
                j++; // now skip the non spaces to find the end of the word
            reverse(a,i,j-1);
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while(j < n) {
            while(j < n && a[j] == ' ')
                j++; // skip spaces
            while(j < n && a[j] != ' ')
                a[i++] = a[j++]; // keep non spaces
            while(j < n && a[j] == ' ')
                j++; // skip spaces
            if(j<n) a[i++] = ' '; // keep only one space
        }
        return new String(a).substring(0,i);
    }

    public static void main(String[] args) {

        ReverseWordsInString rev = new ReverseWordsInString();
        System.out.println(rev.reverseWords("a good   example"));
    }
}
