package modulo;

/*

 */
public class DivisibleBy8 {
    public int solve(String A) {
        int num = 0;
        int mul = 1;
        for(int i=A.length()-1; i>A.length()-4 && i>=0; i--) {
            num = num + Character.getNumericValue(A.charAt(i)) * mul;
            mul = mul * 10;
        }
        return num % 8 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        DivisibleBy8 obj = new DivisibleBy8();
        int res = obj.solve("24344");
        assert res == 1 : "Fail";
        System.out.println(res);

        res = obj.solve("24344");
        assert res == 0 : "Fail";
        System.out.println(res);
    }
}
