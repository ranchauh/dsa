package search.binary;

/**
 * Given arr[n] distinct elements, find any local minima.
 * Local Minima: any element that is smaller than its adjacent neighbours.
 */
public class LocalMinima {
    static int findLocalMinima(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        if(arr[0] < arr[1]) return arr[0];
        if(arr[n-1] < arr[n-2]) return arr[n-1];
        int s = 1, e = n-2;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
                return arr[mid];
            } else if(arr[mid] > arr[mid-1]) {
                // if mid is greater than mid-1, it is 100 % guaranteed that
                // we can find local minima is available to the left.
                // ex: 20 5 15 18 20 7 11:
                // Here arr[mid]=18. If we go to the left of it we are sure going to find 5 as local minima
                // ex: 5 18 20: here also 5 is local minima
                e = mid - 1;
            } else {
                // Exactly opposite logic of the above logic applies here.
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findLocalMinima(new int[]{3, 6, 1, 9, 15, 8})); // 1
        System.out.println(findLocalMinima(new int[]{21, 20, 19, 17, 15, 9, 7})); // 7
        System.out.println(findLocalMinima(new int[]{5, 8, 12, 3})); // 5
    }
}
