package my.examples.huestbook.servlet;

import my.examples.huestbook.dao.GuestbookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/write")
public class GuestbookWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 이름과 내용을 읽어들린다. form 데이터
        String name=req.getParameter("name");
        String content = req.getParameter("content");

        System.out.println(name+" // "+content);

        // 이름과 내용을 검사한다.

        // DB에 이름과 내용을 저장한다.
        Guestbook guestbook = new Guestbook(name, content);
        GuestbookDAO guestbookDao = new GuestbookDAO();
        guestbookDao.addGuestbook(guestbook);

        // /guestbook/list 로 리다이렉트
        resp.sendRedirect("/guestbook/list");
    }
}
