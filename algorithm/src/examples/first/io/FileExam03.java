package examples.first.io;

import java.io.File;
// 현재경로의 파일들의 목록을 출력하라. (단 디렉토리의 경우 DIR로 표시한다.

public class FileExam03 {
    public static void main(String[] args){
        File file = new File(".");
        File[] files = file.listFiles();

        for(File f:files){
            if(f.isDirectory())
                System.out.println("DIR - "+f.getAbsolutePath());
            else {
                System.out.println(f.length());
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
