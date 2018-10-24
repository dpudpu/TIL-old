package my.examples.chat;

public class Main {
    public static void main(String args[]){
        ChatServer chatServer = new ChatServer(12000);
        chatServer.start();

    }
}
