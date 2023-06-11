package combinatorics;

/**
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 *
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 * NOTE: For this problem, we are considering 1 as a prime.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 106
 * 1 <= B <= A
 * A <= C <= 109+7
 *
 *
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 *
 *
 *
 * Output Format
 * Return the value of nCr % p.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 *  C = 13
 * Input 2:
 *
 *  A = 6
 *  B = 2
 *  C = 13
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  nCr( n=5 and r=2) = 10.
 *  p=13. Therefore, nCr%p = 10.
 */
public class ComputeNCRModP {

    public int solve(int A, int B, int C) {
        return (int) ncrModP(A, B, C);
    }

    long ncrModP(int n, int r, int p) {
        //nCr % p = (n! / ((n-r)! * r!)) % p
        // calc n!
        long nFact = fact(n, p);
        long rFact = fact(r, p);
        long nMinusRFact = fact(n-r, p);
        // applying Fermet Little theorem
        //nCr % p = (n! * ((n-r)!^p-2 * r!^p-2)) % p
        long nMinusRFactPowPMinus2 = pow(nMinusRFact, p-2, p);
        long rFactPowMinus2 = pow(rFact, p-2, p);
        //n! * ((n-r)!^p-2
        long temp = (nFact * nMinusRFactPowPMinus2) % p;
        //(n! * ((n-r)!^p-2 * r!^p-2)) % p
        temp = (temp * rFactPowMinus2) % p;
        //nCr % p = (n! * ((n-r)!^p-2 * r!^p-2)) % p
        return temp % p;
    }

    long pow(long a, long b, int p) {
        if(b == 0) {
            return 1;
        }
        long sa = pow(a, b/2, p);
        if(b%2 == 0) {
            sa = (sa * sa) % p;
        } else {
            sa = (((sa * sa) % p) * a) % p;
        }
        return sa;
    }

    long fact(int n, int p) {
        long fact = 1;
        for(int i=1; i<=n; i++) {
            fact = (fact * i) % p;
        }
        return fact % p;
    }

    public static void main(String[] args) {
        ComputeNCRModP ob = new ComputeNCRModP();
        System.out.println(ob.solve(5, 2, 13)); // 10
        System.out.println(ob.solve(6, 2, 13)); // 2
    }
}
