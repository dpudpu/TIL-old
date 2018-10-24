package examples.first.io;

import java.io.File;

public class FileExam01 {
    public static void main(String args[]){
        // 윈도우는 \가 사용되고, 유닉스계열(linux, mac_는 /가 된다.
        // 운영체제와 사관없는 경로명을 지정하겠다.
         String fileName=File.separator+"C:\\fastcampus\\"+File.separator+"readme.md.txt";
//         fileName에 해당하는 파일이나 폴더가 있을 수도 있고, 없을 수도 있다.

        File file = new File(fileName); // \\되야 파일명

        // 파일이 존재한다면
        if(file.exists())
            System.out.println(fileName+"이 있어요.");
        else
            System.out.println("없다");

    }
}
