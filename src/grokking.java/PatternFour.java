package grokking.java;

import java.util.*;

// Interval problems
public class PatternFour {

    // interval class
    static class Interval {
        int start;
        int end;

        public  Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    // problem - merge intervals
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        List<Interval> merged = new ArrayList<>();
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                // merge them
                Interval interval = new Interval(intervals.get(i).start, Math.max(intervals.get(i).end, intervals.get(i + 1).end));
                merged.add(interval);
            }
        }
        return merged;

    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : PatternFour.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : PatternFour.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : PatternFour.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
