package examples.first.io;

import java.io.File;

public class FileExam04 {
    public static void main(String args[]){
        File file = new File("\\tmp\\a\\b\\c\\d\\e");
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
