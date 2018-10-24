package examples.first.io;

import java.io.File;

public class IoQuiz01 {
    public static void main(String args[]){
        String filePath = "/first_api";
        int lengthTotal = filesLength(filePath);
        System.out.println("총 사이즈 = "+lengthTotal);


    }
    public static int filesLength(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        int lengthTotal=0;

        for(File f:files) {
            if (f.isDirectory()) {
                System.out.println("[DIR]" + f.getAbsolutePath());
                System.out.println("---------------------------------------------");
                lengthTotal+=filesLength(f.getAbsolutePath()); // 재귀호출
            } else {
                System.out.println(f.getAbsolutePath());
                lengthTotal+=f.length();
            }
        }

        return lengthTotal;
    }
}
