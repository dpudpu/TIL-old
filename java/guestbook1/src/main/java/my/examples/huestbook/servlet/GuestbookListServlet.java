package my.examples.huestbook.servlet;

import my.examples.huestbook.dao.GuestbookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/guestbook/list")
public class GuestbookListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // db에서 목록을 읽어온다.
        String pg = "1";
        if(req.getParameter("pg")!=null) {
            pg = req.getParameter("pg");
        }

        GuestbookDAO guestbookDao = new GuestbookDAO();
        List<Guestbook> list = guestbookDao.getGuestbookList(pg);


        int[] page = new int[list.size()/10+1];
        System.out.println("페이지 수 = "+page.length);
        for(int i=0; i<page.length;i++){
            page[i]=i+1;
        }


        // request 는 was에 의해서 만들어지고 sevlet에게 전달
        // request scope - request에 값을 저장하여 jsp까지 값을 전달.
        // 읽어온 결과를 jsp에게 전달하기위해 request에 값을 저장한다.
        req.setAttribute("guestbookList",list);
        req.setAttribute("guestbookSize",list.size());
        req.setAttribute("page",page);


        // jsp에 포워딩(forward)한다. 포워딩은 url은 변경되지 않고 jsp에게 값을 전달.
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(req, resp);
    }
}