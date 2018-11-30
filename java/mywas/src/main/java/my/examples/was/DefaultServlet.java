package my.examples.was;

import java.io.*;

public class DefaultServlet {
    public void service(Request request, Response response) {
        // 응답하기
        String webpath = request.getPath();
        String context = "/tmp/miniwas";
        if ("/".equals(webpath))
            webpath = webpath + "index.html";

        File file = new File(context + webpath);
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
                int readCount = 0;
                if ((readCount = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount);
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
