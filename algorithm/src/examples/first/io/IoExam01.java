package examples.first.io;

import java.io.*;

public class IoExam01 {
    public static void main(String args[]){
        InputStream in = null;
        OutputStream out = null;

        //한번에 묶어서 클로즈하면 하나가 먼저 클로즈 나면 다른것이 실행이 안되서
        // 같이 하지 말고 따로따로 해주는게 좋다
        try{
            File file = new File("\\fastcampus\\readme.md.txt");
            if(!file.isDirectory() && file.exists()) {
                in = new FileInputStream(file);
                out = new FileOutputStream("\\tmp\\readme.out");
                int readData=0;
                while((readData=in.read())!=-1){
                    out.write(readData);
                }

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (IOException ex){}
            try{
                out.close();
            }catch(IOException ex){}
        }
    }
}
