package LinearProgress.Week1.Day1;

public class RomanNumerals {

    private int[] checkNext(String s,int index, char numeral) {
        char fourTimes, nineTimes;
        int multiplier;
        // first a switch to determine what numeral we got
        switch(numeral) {
            case 'C':
                fourTimes = 'D';
                nineTimes = 'M';
                multiplier = 100;
                break;
            case 'X':
                fourTimes = 'L';
                nineTimes = 'C';
                multiplier = 10;
                break;
            case 'I':
                fourTimes = 'V';
                nineTimes = 'X';
                multiplier = 1;
                break;
            default:
                System.out.println("Unrecognized numeral supplied");
                return new int[] {-1,1000};
        }
        try {
            if(s.charAt(index+1)==fourTimes) return new int[] {4*multiplier,2};
            if(s.charAt(index+1)==nineTimes) return new int[] {9*multiplier,2};
        } catch(StringIndexOutOfBoundsException e) {
            switch(numeral) {
                case('C'): return new int[] {100,2};
                case('X'): return new int[] {10,2};
                case('I'): return new int[] {1,2};
            }
        }
        switch(numeral) {
            case('C'): return new int[] {100,1};
            case('X'): return new int[] {10,1};
            case('I'): return new int[] {1,1};


        }
        System.out.println("Error");
        return new int[] {-1,100};
    }

    private int romanToInt(String s) {
        int index = 0;
        int sum = 0;
        while(index<s.length()) {
            switch(s.charAt(index)) {
                case 'C': case 'X': case 'I':
                    int[] results = checkNext(s,index,s.charAt(index));
                    sum += results[0];
                    index += results[1];
                    continue;
                case 'V':
                    sum += 5;
                    index++;
                    continue;
                case 'L':
                    sum += 50;
                    index++;
                    continue;
                case 'D':
                    sum += 500;
                    index++;
                    continue;
                case 'M':
                    sum += 1000;
                    index++;
                    continue;
                default:
                    System.out.println("String supplied is not a roman numeral");
                    return -1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        RomanNumerals rom = new RomanNumerals();
        System.out.println(rom.romanToInt("MMCDXVII"));
    }
}
