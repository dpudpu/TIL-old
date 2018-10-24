package my.examples.huestbook.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/guestbook/logout")
public class GuestbookLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에서 로그인 정보를 삭제한다.
        HttpSession session = req.getSession();
        session.removeAttribute("admin");

        // /guestbook/list로 redirect한다.
        resp.sendRedirect("/guestbook/list");
    }

}