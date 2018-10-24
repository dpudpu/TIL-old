package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread{
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("SocketHandler Start");
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.name = in.readLine(); // 첫줄은 무조건 이름이다.
            chatServer.broadcast(this.name + "님이 입장했어요.");

            chatServer.addPrintWriter(out);

            String line = null;

            while((line = in.readLine()) != null){ // 네트워 연결이 끊어질때지 null이 나오면 끝.
                chatServer.broadcast(this.name + " : " + line);
            }
        }catch(Exception ex){
            System.out.println("Chat Handler close");
        }finally {
            chatServer.removePrintWriter(out);
            chatServer.broadcast(this.name + "님이 퇴장했어요.");
            System.out.println("Chat Handler finally");
            try{ in.close(); }catch(Exception e){}
            try{ out.close(); }catch(Exception e){}
        }
    }
}