package my.examples.huestbook.servlet;


import my.examples.huestbook.dao.GuestbookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/guestbook/delete")
public class GuestbookDeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // id를 읽어들인다. query parameter ?id=100
        String id = req.getParameter("id");
        System.out.println(id);

        // 세션에서 관리자 로그인 정보가 있는지 확인한다.
        HttpSession session = req.getSession();
        String admin = (String)session.getAttribute("admin");
        if(session!=null && admin.equals("true")){
            System.out.println(id+"를 삭제합니다.");
            GuestbookDAO guestbookDao = new GuestbookDAO();
            guestbookDao.deleteGuestbook(Long.parseLong(id));
        }

        // id에 해당하는 방명록을 삭제한다.

        resp.sendRedirect("/guestbook/list");
    }
}