package serach.linear;

public class LinearSearch {
    public static int search(int[] arr, int k) {
        for(int el:arr) {
            if(el == k) {
                return k;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,4,2,5}, 4)); // 4
        System.out.println(search(new int[]{1,4,2,5}, 10)); // -1
    }
}
