import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BRock {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            BRock.matchBenchmark(line);
        }
    }

    public static void matchBenchmark(String input) {
        // Access your code here. Feel free to create other classes as required

        String[] portofolioBenchmark = input.split(":");
        // I need to escape my '|' character to split the string
        String[] portofolioAssets = portofolioBenchmark[0].split("\\|", 0);
        String[] benchmarkAssets = portofolioBenchmark[1].split("\\|", 0);

        // Get all portofolio assets and their numbers
        Map<String, Asset> portofolioMap = new HashMap<>();
        for(String n: portofolioAssets) {
            String[] info = n.split(",");
            Asset asset = new Asset(info[0], info[1], Integer.parseInt(info[2]));
            String name = info[0] + info[1];
            portofolioMap.put(name, asset);
        }

        // Get all benchmark assets and their numbers
        Map<String, Asset> benchmarkMap = new HashMap<>();
        for(String n: benchmarkAssets) {
            String[] info = n.split(",");
            Asset asset = new Asset(info[0], info[1], Integer.parseInt(info[2]));
            String name = info[0] + info[1];
            benchmarkMap.put(name, asset);
        }

        // Iterate through my portofolio assets and look for transactions
        List<Transaction> list = new ArrayList<>();
        for(Map.Entry<String, Asset> entry : portofolioMap.entrySet()) {

            String key = entry.getKey();

            if(benchmarkMap.containsKey(key)) {

                int portNumber = entry.getValue().getNumber();
                int benchNumber = benchmarkMap.get(key).getNumber();

                if(portNumber < benchNumber) {
                    list.add(new Transaction("BUY", entry.getValue(), benchNumber - portNumber));
                }
                else if(portNumber > benchNumber)
                    list.add(new Transaction("SELL", entry.getValue(), portNumber - benchNumber));
            } else
                // sell the extra assets that are not in the benchmark
                list.add(new Transaction("SELL", entry.getValue(), entry.getValue().getNumber()));
        }

        // iterate throgh the benchmark to find any assets that don't exist in my portofolio
        for(Map.Entry<String, Asset> entry : benchmarkMap.entrySet()) {

            String key = entry.getKey();

            if(!portofolioMap.containsKey(key))
                list.add(new Transaction("BUY", entry.getValue(), entry.getValue().getNumber()));
        }

        list = sortList(list);
        for(Transaction t: list)
            System.out.println(t.toString());



    }

    public static List<Transaction> sortList(List<Transaction> list) {

        for(int i = 0; i < list.size() - 1; i++) {

            Transaction a = list.get(i);
            Transaction b = list.get(i + 1);

            if(a.getAsset().getCompany().equals(b.getAsset().getCompany())) {


                if(a.getAsset().getShareType().equals("STOCK") && b.getAsset().getShareType().equals("BOND")) {
                    list.set(i, b);
                    list.set(i + 1, a);
                }
            }

        }
        return list;
    }



    static class Transaction {

        public String type;
        public Asset asset;
        public int number;

        public Transaction(String type, Asset asset, int number) {
            this.type = type;
            this.asset = asset;
            this.number = number;
        }

        public String getType() { return this.type;}
        public Asset getAsset() { return this.asset;}
        public int getNumber() { return this.number;}

        public String toString() {
            return this.type +"," + this.asset.getCompany() + "," + this.asset.getShareType() + "," + this.number;
        }
    }




    static class Asset {

        public String company;
        public String shareType;
        public int number;


        public Asset(String company, String shareType, int number) {
            this.company = company;
            this.shareType = shareType;
            this.number = number;
        }

        public String getCompany() { return this.company;}
        public String getShareType() { return this.shareType;}
        public int getNumber() { return this.number;}

        public boolean equals(Asset asset) {
            return this.company == asset.getCompany() && this.shareType == asset.getShareType();
        }

        public String toString() {
            return this.company +" "+this.shareType;
        }
    }

}
