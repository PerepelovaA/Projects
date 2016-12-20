import com.google.gson.Gson;
import java.lang.Object;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by user on 13.10.2016.
 */
public class SearchingServlet extends HttpServlet {
    private IvertIndex invertIndex;
    @Override
    public void init() {
        invertIndex = new IvertIndex();
        //Logger log = Logger.getLogger(BaseServlet.class.getName());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        String result;
        if (ajax) {
            String searchText = request.getParameter("text");
            Writer writer = response.getWriter();
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            try {
                String[] docsNames = invertIndex.getDocNames(searchText);
                String[] textInDocs = invertIndex.getTextInDocs(searchText, docsNames);
                if (docsNames.length != 0) {
                    writer.write(new Gson().toJson(new JsonPackage("found", docsNames, textInDocs)));
                    String[] arr=invertIndex.getTextInDocs(searchText,docsNames);
                    result="";
                    for(int i=0;i<arr.length;i++)
                    result = result+"<"+arr[i]+"> ";
                    HttpSession session = request.getSession();
                    session.setAttribute("results",result);
                } else {
                    writer.write(new Gson().toJson(new JsonPackage("Not found")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
