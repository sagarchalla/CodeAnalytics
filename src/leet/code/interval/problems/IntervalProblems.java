package leet.code.interval.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalProblems {


    public static void main(String[] args) {
       System.out.println(eraseOverlapIntervals(new int[][] { {1,100} ,{ 11,22 } , {1,11 },{ 2,12 }}));
    }


    /**
     * 252 Meeting Rooms
     * Approach :: Sort the meeting object based on start time
     *             If the beginning of the next meeting starts before the end of the current on
     *             then there is an overlap in the meeting
     *
     */
     private static boolean canAttendMeetings(Interval[] intervals) {
         // TODO :: Fix the sorting here
         Arrays.sort(intervals, Comparator.comparing((i1) -> i1.start));

         for(int i = 0; i < intervals.length - 1; i++ ) {
             if(intervals[i].end  > intervals[i + 1].start) {
                 return false;
             }
         }
         return true;
     }

    /**
     * 435. Non overlapping intervals
     * minimum number to remove to have non overlapping intervals
     *
     * LeetCode: Completed
     *
     * Approach :: Sort it by the start number in the array
     *          :: remove the interval with the highest end interval in order to get to the minimum intervals
     *
     *          https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
     */
    public static int eraseOverlapIntervals(int[][] collection) {


        // base case
        if(collection.length == 0) {
            return 0;
        }
        Arrays.sort(collection, Comparator.comparing(c -> c[1]));

        int elementsRemoved = 0;
        int previousEnd = collection[0][1];

        for (int i = 1; i < collection.length; i++) {
            int currentStart = collection[i][0];

            if (currentStart < previousEnd) {
                elementsRemoved = elementsRemoved + 1;
            }else {
                previousEnd =  collection[i][1];
            }
        }
        return elementsRemoved;
    }


    /**
     * 56. Merge Intervals
     * merge overlapping intervals
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     *
     * Approach :: Sort the input based on the start
     *    if if the first two items overlap - combine the two and add it to a result array
     *    else - just add it to the result array
     *
     *
     */
    public int[][] merge(int[][] intervals) {

        //edge case
        if(intervals.length == 0) {
            return intervals;
        }

        // sort the arrays
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // compare prevoious element
        int[] previousInterval = intervals[0];

        // create a result list
        List<int[]> resultIntervals = new ArrayList<int[]>();

        resultIntervals.add(previousInterval);

        // Loop though once and merge the intervals
        for(int[] interval: intervals) {

            if(previousInterval[1] >= interval[0]) {
                previousInterval[1] = Math.max(previousInterval[1] , interval[1]);
            }
            else {
                previousInterval = interval;
                resultIntervals.add(interval);
            }
        }

        return resultIntervals.toArray(new int[resultIntervals.size()][]);

    }


    class  Interval {
         int start;
         int end;
         public Interval(){
               start = 0;
               end = 0;
        }
        public Interval(int start, int end) {
             this.start = start;
             this.end = end;
        }
    }


}
