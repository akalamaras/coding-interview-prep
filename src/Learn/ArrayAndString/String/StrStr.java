package Learn.ArrayAndString.String;

public class StrStr {

    public int strStr(String haystack, String needle) {

        if(needle == null || needle.length() == 0)
            return 0;

        if(needle.length() > haystack.length())
            return -1;

        int length = needle.length();

        for(int i = 0; i <= haystack.length() - length; i++) {
            String sub = haystack.substring(i,i+length);
            if(needle.equals(sub))
                return i;
        }
        return -1;
    }

    public int noInBuiltStrStr(String haystack, String needle) {

        for(int i = 0; true; i++) {
            for(int j = 0; true; j++) {

                if(j == needle.length())
                    return i;

                if(i + j == haystack.length())
                    return -1;

                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;

            }
        }
    }

}
