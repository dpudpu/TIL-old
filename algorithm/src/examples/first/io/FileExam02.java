package examples.first.io;

import java.io.File;

public class FileExam02 {
    public static void main(String[] args){
        File file = new File(".");//.은 현재 경로를 말한다. JVM이 실행되는 위치
        // 절대경로를 출력한다.
        // 절대경로는 /로 시작하거나 드라이브명으로 시작한다.
        System.out.println(file.getAbsolutePath());

    }
}
