package my.examples.chat;

import java.io.BufferedReader;

//서버가 보내주는 메시지를 백그라운드에서 읽어들여 화면에 출력.
public class InputHandler extends Thread {
    BufferedReader in;

    public InputHandler(BufferedReader in){
        this.in =in;
    }

    @Override
    public void run(){
        try{
            String line=null;
            while((line =in.readLine())!=null){
                System.out.println(line);
            }

        }catch (Exception ex){
            System.out.println("ex : "+ex.getMessage());
        }finally {
            try{
                in.close();
            }catch (Exception ex){}
        }
    }

}
