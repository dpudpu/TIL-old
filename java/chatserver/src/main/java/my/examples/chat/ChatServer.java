package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread{
    private int port; // 서버가 실행되는 port
    private Set<PrintWriter> socketSet = null;

    public ChatServer(int port){
        this.port=port;
        this.socketSet = new CopyOnWriteArraySet();
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }
    public void removePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }
    public void broadcast(String msg){
        for(PrintWriter out : socketSet){
                out.println(msg);
                out.flush();
            }
    }

    @Override
    public void run() {
        // 채팅 서버가 해야할 작업을 코딩\
        ServerSocket serverSocket =null;


        try {
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept(); // 블러킹 메소드
                SocketHandler handler = new SocketHandler(this, socket);
                handler.start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try{
                serverSocket.close();
            }catch (Exception ex){}
        }

    }
}
