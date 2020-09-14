import java.util.*;

/**
 * Plena Data challenge
 */
public class Solution {
    public static void main(String[] args) {
        String str = getInputString();

        String result = reorder(str);
        System.out.println(result.charAt(0));
        System.out.println(result);
    }

    /**
     * Reads the input given by the user
     * @return input string
     */
    public static String getInputString() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your string: ");
        String str = input.nextLine();

        if (str == null || str.isEmpty() || !str.matches("^[a-zA-z]*$")) {
            System.out.println("Not a valid string");
            getInputString();
        }

        return str;
    }

    /**
     * Reorders string in ascending order of occurrence of characters
     * @param str input string
     * @return reordered string
     */
    public static String reorder(String str) {
        str = str.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] list = new List[str.length()];
        for (char c : map.keySet()) {
            int occur = map.get(c);
            if (list[occur] == null) {
                list[occur] = new ArrayList<>();
            }
            list[occur].add(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            if (list[i] != null) {
                for (Character c : list[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}