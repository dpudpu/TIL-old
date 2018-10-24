package examples.first.io;

import java.io.*;

public class CopyUtil {
    public static void copy(InputStream in, OutputStream out){
        try {
            byte[] buffer = new byte[1024];
            int readCount = 0;
            // 예를 들어 파일크기가 3000이라면 3번읽어들인다.
            while((readCount = in.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            }catch(IOException ex){}
            try {
                out.close();
            }catch(IOException ex){}
        }
    }
}
