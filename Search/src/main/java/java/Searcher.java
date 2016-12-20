package java;
import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 21.12.2016.
 */
public class Searcher extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        String search = request.getParameter("search");
        if (search == null || search.length() == 0) {
            response.getWriter().println("Enter request");
            return;
        }
        String search1 = "он сказал";
        String[] parts1 = search1.split("\\P{L}+");
        String[] parts = search.split("\\P{L}+");
        if (parts.length > 2) {
            response.getWriter().println("just 2 words");
            return;
        }
        String document = Library.getInstance().getDocument(parts);
         if (document == null) {
             response.getWriter().println("Nothing found=(");
            return;
        }
        response.getWriter().println(document);
        HttpSession session=request.getSession();
        session.setAttribute("result",Library.getInstance().getDocument(parts1));
        System.out.println(Library.getInstance().getDocument(parts1));
    }

}
