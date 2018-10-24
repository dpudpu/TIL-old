package practice;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread {
    Socket socket;
    public Handler(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run(){
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pw);

            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }
}
