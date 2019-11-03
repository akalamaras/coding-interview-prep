package Practice.Expedia;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int total_tank = 0;
        int current_tank = 0;
        int starting_position = 0;

        for(int i = 0; i < n; i++) {

            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];

            if(current_tank < 0) {
                starting_position = i + 1;
                current_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_position : -1;
    }
}
