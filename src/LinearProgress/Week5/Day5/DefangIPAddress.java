package LinearProgress.Week5.Day5;

public class DefangIPAddress {

    public String defang(String address) {

        String[] array = address.split("\\.");
        String ret = "";
        for(int i = 0; i < array.length-1; i++) {
            ret += array[i] + "[.]";
        }
        ret += array[array.length-1];
        return ret;
    }

    public String oneLiner(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {

        DefangIPAddress d = new DefangIPAddress();
        String s = d.defang("250.100.50.0");
        System.out.println(s);


    }
}
