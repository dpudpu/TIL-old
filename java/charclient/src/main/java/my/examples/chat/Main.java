package my.examples.chat;

public class Main {
    public static void main(String args[]){
        ChatClient chatClient = new ChatClient("127.0.0.1", 1200);
        chatClient.start();
    }
}
