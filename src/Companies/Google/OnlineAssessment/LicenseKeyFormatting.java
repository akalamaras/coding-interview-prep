package Companies.Google.OnlineAssessment;


public class LicenseKeyFormatting {

    public static void main(String[] args) {

        LicenseKeyFormatting lkf = new LicenseKeyFormatting();
        System.out.println(lkf.licenseKeyFormatting("2-5g-3-J",2));
    }



    public String licenseKeyFormatting(String s, int k) {

        s = s.replaceAll("[-]", "").toUpperCase();
        StringBuilder sb = new StringBuilder(s);

        int i = sb.length() - k;
        while (i > 0) {
            sb.insert(i, '-');
            i -= k;
        }
        return sb.toString();
    }


}
