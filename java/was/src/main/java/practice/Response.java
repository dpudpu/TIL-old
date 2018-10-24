package practice;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
    private OutputStream out;
    private PrintWriter pw;

    public Response(OutputStream out, PrintWriter pw) {
        this.out=out;
        this.pw=pw;
    }


    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
}
