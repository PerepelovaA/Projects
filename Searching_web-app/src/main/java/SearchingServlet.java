import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 13.10.2016.
 */
public class SearchingServlet extends HttpServlet {
    public SearchingServlet() {
        super();
    }
    private static final Logger LOG = Logger.getLogger(SearchingServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String list=Indexer.getInstance().search(req.getParameter("search_results"));
        String results=results(req.getParameter("search_results"),list);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Search results</title></head>");
        writer.println("<body>" + results + "</body>");
        writer.println("</html>");
        writer.close();

    }
    private String results(String words, String results){
        LOG.log(Level.INFO, "Search for words: [" + words + "], result: " + results);
        String header = "<b>Search result for words: [" + words + "]</b><br><br>";
        if (results == null || results.length() == 0){
            LOG.log(Level.INFO, "Nothing found for words: [" + words + "]");
            return header + "<font color=\"red\"><b>NOTHING FOUND</b></font>";
        }
        StringBuilder result = new StringBuilder();
        return header + result.toString();
    }


}
