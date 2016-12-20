import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 13.10.2016.
 */
public class SearchingServlet extends HttpServlet {
    public SearchingServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Indexer.getInstance().search(req.getParameter("search_words"));
        List<String> list =Indexer.getInstance().search("работает");
        HttpSession session = req.getSession();
        session.setAttribute("listOfdocs",list.toString());
        System.out.println("File: "+list.get(0));
    }
}
