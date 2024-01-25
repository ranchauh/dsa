package graph;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * The member states of the UN are planning to send  people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.
 *
 * Example
 *
 *
 *
 * There are  astronauts numbered  through . Astronauts grouped by country are  and . There are  pairs to choose from:  and .
 *
 * Function Description
 *
 * Complete the journeyToMoon function in the editor below.
 *
 * journeyToMoon has the following parameter(s):
 *
 * int n: the number of astronauts
 * int astronaut[p][2]: each element  is a  element array that represents the ID's of two astronauts from the same country
 * Returns
 * - int: the number of valid pairs
 *
 * Input Format
 *
 * The first line contains two integers  and , the number of astronauts and the number of pairs.
 * Each of the next  lines contains  space-separated integers denoting astronaut ID's of two who share the same nationality.
 *
 * Constraints
 *
 * Sample Input 0
 *
 * 5 3
 * 0 1
 * 2 3
 * 0 4
 * Sample Output 0
 *
 * 6
 * Explanation 0
 *
 * Persons numbered  belong to one country, and those numbered  belong to another. The UN has  ways of choosing a pair:
 *
 *
 * Sample Input 1
 *
 * 4 1
 * 0 2
 * Sample Output 1
 *
 * 5
 * Explanation 1
 *
 * Persons numbered  belong to the same country, but persons  and  don't share countries with anyone else. The UN has  ways of choosing a pair:
 */
public class AstronautsPairSDU {
    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    static int[] parent;

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(List<Integer> l : astronaut){
            int a = l.get(0);
            int b = l.get(1);

            union(a,b);
        }

        HashMap<Integer, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
            System.out.print(parent[i]+" ");
        }
        for(int i=0; i<n; i++){
            map.put(parent[i], map.getOrDefault(parent[i],0L)+1L);
        }
        long ans = ((long)n * (n-1))/2;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        for(int i=0; i<list.size(); i++){
            long count = map.get(list.get(i));
            ans -= count * (count - 1)/2;
        }
        return  ans;
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb){
            if(fa > fb){
                parent[fa] = fb;
            }else{
                parent[fb] = fa;
            }
        }
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = AstronautsPairSDU.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}