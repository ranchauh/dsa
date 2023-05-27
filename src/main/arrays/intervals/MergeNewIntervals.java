package arrays.intervals;


import java.util.ArrayList;

public class MergeNewIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        for(int i=0; i<n; i++) {
            Interval currInterval = intervals.get(i);
            if(newInterval.start >= currInterval.end) { // newInterval is on the right of the current one
                // add the curren interval and wait to compare the newInterval with upcoming intervals
                result.add(currInterval);
            } else if(currInterval.start >= newInterval.end) { // newInterval is on the left of the current one
                // add the new interval
                result.add(newInterval);
                // copy the rest of the intervals as is and return
                while(i < n) {
                    result.add(intervals.get(i));
                    i++;
                }
                result = mergeIntervals(result);
                return result;
            } else {
                newInterval.start = Math.min(currInterval.start, newInterval.start);
                newInterval.end = Math.max(currInterval.end, newInterval.end);
            }
        }
        // finally add the newInterval and return
        result.add(newInterval);

        result = mergeIntervals(result);

        return result;
    }

    private ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        int n = intervals.size();
        Interval prevInterval = intervals.get(0);
        ArrayList<Interval> result = new ArrayList<>();
        for(int i=1; i<n; i++) {
            Interval curInterval = intervals.get(i);
            if(prevInterval.end < curInterval.start) {
                result.add(prevInterval);
                prevInterval = curInterval;
            } else {
                prevInterval.end = curInterval.end;
            }
        }
        result.add(prevInterval);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        MergeNewIntervals mergeNewIntervals = new MergeNewIntervals();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3,4 ));
        intervals.add(new Interval(5,6 ));

        System.out.println(mergeNewIntervals.insert(intervals, new Interval(4, 5)));
    }
}
