package practice;

import java.io.*;

public class DefaultServlet {

    public void service(Request request, Response response) {
        String path = request.getPath();
        String context = "/tmp";
        if (path.equals("/"))
            path += "index.html";

        File file = new File(context + path);
        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();

        if (file.exists()) {
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush();


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount=0;
                if((readCount=fis.read(buffer))!=-1){
                    out.write(buffer, 0,readCount);
                    out.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();

        }

    }
}
