package algorithm.leetcode.binarySearch;

public class Quiz744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int end = letters.length-1;
        int start = 0;
        if (target >= letters[end] || target < letters[0])
            return letters[0];

        while (true) {
            int mid = (start + end)+1 / 2;
            if (letters[mid - 1] <= target && letters[mid] > target)
                return letters[mid];
            else if (letters[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }

//        for (char c : letters)
//            if (c > target)
//                return c;
//        return letters[0];
    }

    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.println(nextGreatestLetter(letters, 'a'));
    }
}
