package java;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
/**
 * Created by user on 21.12.2016.
 */
public class Searcher extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,

                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        response.setStatus(HttpServletResponse.SC_OK);

        String search = request.getParameter("search");

        if (search == null || search.length() == 0) {

            response.getWriter().println("Введите запрос");

            return;
        }
        String[] parts = search.split("\\P{L}+");

        if (parts.length > 2) {

            response.getWriter().println("Не более 2х слов");

            return;

        }

        String document = Library.getInstance().getDocument(parts);

        if (document == null) {

            response.getWriter().println("Для заданных слов документа не найдено");

            return;

        }

        response.getWriter().println(document);

    }

}
