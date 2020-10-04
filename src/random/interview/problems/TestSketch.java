package random.interview.problems;

import java.util.*;

public class TestSketch {

    class IntervalSequence {
        int end;
        int start;
        char value;


        public IntervalSequence(int start, char value) {
            this.end = end;
            this.start = start;
            this.value = value;
        }

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        List<Integer> lengthEachScene(List<Character> inputList)
        {
            // WRITE YOUR CODE HERE

            List<Integer> result = new ArrayList<>();
            Map<Character, IntervalSequence> sceneMap = new LinkedHashMap<>();

            List<IntervalSequence> sequence = new ArrayList<>();

            for(int i =0; i< inputList.size(); i++ ) {
                char current = inputList.get(i);
                if(sceneMap.containsKey(current)) {
                    sceneMap.get(current).end = i;
                }
                else {
                    sceneMap.put(current, new IntervalSequence(i, current));
                }
            }

            List<IntervalSequence> intervalList = new ArrayList<IntervalSequence>(sceneMap.values());

            IntervalSequence previous = intervalList.get(0);

            for(int i=1; i<intervalList.size(); i++) {

                IntervalSequence current = intervalList.get(i);

                if(previous.end < current.start) {
                    result.add(previous.end - previous.start + 1);
                    previous.start = current.start;
                    previous.end = current.end;
                }
                else {
                    if(previous.end > current.end) {
                        continue;
                    }
                    else {
                        previous.end = current.end;
                    }


                }


            }
            result.add(previous.end - previous.start + 1);
            return result;
        }

    }
    // METHOD SIGNATURE ENDS

}