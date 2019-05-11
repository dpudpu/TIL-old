package stream;

import java.util.Arrays;
import java.util.List;

public class StreamExam01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");

        // 기존의 코딩 방식
        long count = 0;
        for (String name : names) {
            if (name.contains("o")) {
                count++;
            }
        }
        System.out.println("Count : " + count); // 2

        // 스트림 이용한 방식
        count = names.stream().filter(x -> x.contains("o")).count();
        System.out.println("Count : " + count); // 2

    }
}