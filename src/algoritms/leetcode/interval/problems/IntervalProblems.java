package algoritms.leetcode.interval.problems;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalProblems {


    public static void main(String[] args) {

    //    System.out.println(Arrays.toString(new Interval[] {0,30},{5,10},{15,20}));
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
     * Approach :: Sort it by the start number in the array
     *          :: remove the interval with the highest end interval in order to get to the minimum intervals
     *
     *          https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[0][1] > intervals[0][2]) {
                count++;
            }

        }
return count;

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
