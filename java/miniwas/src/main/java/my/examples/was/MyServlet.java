package my.examples.was;

import java.io.PrintWriter;
// web.xml에 서블릿 설정을 하는데 web.xml 대신에 설정
// class 정보들을 읽어들이고

@WebServlet("/my")
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(Request request, Response response) {
        PrintWriter out = response.getPw();
        for(int i = 0; i < 10; i++)
            out.println("<h1>hello</h1>");
    }
}
