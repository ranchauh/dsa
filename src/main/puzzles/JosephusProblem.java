package puzzles;

/**
 * There are A people standing in a circle. Person 1 kills their immediate clockwise neighbour and pass the knife to the next person standing in circle.
 * This process continues till there is only 1 person remaining. Find the last person standing in the circle.
 */
public class JosephusProblem {
    public int solve(int A) {
        /*
        If we are killing the immediate person then the below condition will hold good.
        if A == some power of 2 (as the knife is passed on skipping two persons) then
            whoever start will win
        else kill only those many people so that we reach some power of two.
        Now, apply the power of 2 rule as stated in above if condition.
         */
        int i = 0;
        while(A >= Math.pow(2, i)) i++;
        double pow = Math.pow(2, i-1);
        double diffToReachPowOf2 = A - pow;
        return (int) diffToReachPowOf2 * 2 + 1;
    }

    public static void main(String[] args) {
        JosephusProblem obj = new JosephusProblem();
        System.out.println(obj.solve(9)); //3
        System.out.println(obj.solve(8)); //1
    }
}
