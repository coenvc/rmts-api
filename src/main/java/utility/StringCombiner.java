package utility;

import java.util.List;

public class StringCombiner {
    public static String combineList(List<String> input) {
        StringBuilder result = new StringBuilder();
        for (String current : input) {
            result.append(current);
            int i = input.indexOf(current);
            if (i == input.size() - 2) {
                result.append(" and ");
            } else if (i != input.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
