package Companies.Bloomberg.ArraysAndStrings;

public class StringCompression {

    public int compress(char[] characters) {

        int anchor = 0, write = 0;
        for(int read = 0; read < characters.length; read++) {

            if(read + 1 == characters.length || characters[read + 1] != characters[read]) {
                characters[write++] = characters[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        characters[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
