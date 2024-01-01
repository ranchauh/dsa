package greedy;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 */
public class GasStation {
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int totalGas = 0;
        int currentGas = 0;
        int startStation = 0;

        for(int i=0; i<A.length; i++) {
            totalGas += A[i] - B[i];
            if(currentGas < 0) {
                // if current tank is empty, start from the next station
                startStation = i;
                currentGas = A[i] - B[i];
            } else {
                currentGas += A[i] - B[i];
            }
        }

        if(totalGas < 0) {
            // if the total gas available is negative, it's impossible to complete the circuit.
            return -1;
        } else {
            return startStation;
        }
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {3, 4, 5, 1, 2};
        System.out.println(gasStation.canCompleteCircuit(A, B)); // 3
        A = new int[]{959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209};
        B = new int[] { 862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884 };
        System.out.println(gasStation.canCompleteCircuit(A, B)); // -1
    }
}
