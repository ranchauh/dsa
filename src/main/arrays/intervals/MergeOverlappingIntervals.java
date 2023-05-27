package arrays.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        sortIntervals(intervals);
        int n = intervals.size();
        Interval prevInterval = intervals.get(0);
        ArrayList<Interval> result = new ArrayList<>();
        for(int i=1; i<n; i++) {
            Interval curInterval = intervals.get(i);
            if(prevInterval.end < curInterval.start) {
                result.add(prevInterval);
                prevInterval = curInterval;
            } else {
                prevInterval.end = Math.max(prevInterval.end, curInterval.end);
            }
        }
        result.add(prevInterval);
        return result;
    }

    private ArrayList<Interval> sortIntervals(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        return intervals;
    }

    private ArrayList<Interval> arrayToIntervals(int[] arr) {
        int n = arr[0];
        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i=1; i<n; i += 2) {
            intervals.add(new Interval(arr[i], arr[i+1]));
        }
        return intervals;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,10));
        intervals.add(new Interval(2,9));
        intervals.add(new Interval(3,8));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(6,6));
        MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
        System.out.println(obj.merge(intervals));

        // An array of intervals. First number represents the number of intervals to follow. Then for every interval we get a pair of integers.
        int[] arr = {73, 4,100,48,94,16,21,58,71,36,53,49,68,18,42,37,90,68,75,6,57,25,78,58,79,18,29,69,94,5,31,10,87,21,35,1,32,7,24,17,85,30,95,5,63,1,17,67,100,53,55,30,63,7,76,33,51,62,68,78,83,12,24,31,73,64,74,33,40,51,63,17,31,14,29,9,15,39,70,13,67,27,100,10,71,18,47,48,79,70,73,44,59,68,78,24,67,32,70,29,94,45,90,10,76,12,28,31,78,9,44,29,83,21,35,46,93,66,83,21,72,29,37,6,11,56,87,10,26,11,12,15,88,3,13,56,70,40,73,25,62,63,73,47,74,8,36};
        intervals = obj.arrayToIntervals(arr);
        System.out.println(obj.merge(intervals));
    }
}
