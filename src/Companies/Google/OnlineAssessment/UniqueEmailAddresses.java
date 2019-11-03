package Companies.Google.OnlineAssessment;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {

        String[] emails = {"test.email+alex@leetcode.com",
                           "test.e.mail+bob.cathy@leetcode.com",
                           "testemail+david@lee.tcode.com"};
        UniqueEmailAddresses q = new UniqueEmailAddresses();
        System.out.println(q.numEqualsEmails(emails));

    }

    public int numEqualsEmails(String[] emails) {

        Set<String> set = new HashSet<>();
        for(String email : emails) {

            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            if(local.indexOf('+') != -1)
                local = local.substring(0, local.indexOf('+'));

            local = local.replaceAll("\\.", "");

            set.add(local + domain);
        }
        return set.size();
    }
}
