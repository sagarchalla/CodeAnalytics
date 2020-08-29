package algoritms.misc.practice.mathematics.solutions;
import java.util.*;

public class LinkedLists {

    public List<String> subStringsKDist(String inputStr, int num) {
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        List<String> inputList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i + num <= inputStr.length(); i++) {
            inputList.add(inputStr.substring(i, i + num));
        }

        for (int j = 0; j < inputList.size(); j++) {
            String str = inputList.get(j);

            boolean isRepeat = false;

            for (char c : str.toCharArray()) {
                if (occurrenceMap.containsKey(c)) {
                    if (!isRepeat)
                        occurrenceMap.put(c, occurrenceMap.get(c) + 1);
                    else
                        break;

                    isRepeat = true;
                } else
                    occurrenceMap.put(c, 1);
            }
            if (isRepeat)
                resultList.add(str);
            occurrenceMap.clear();
        }

        return resultList;


    }











}
