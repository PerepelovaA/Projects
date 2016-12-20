/**
 * Created by user on 20.12.2016.
 */
public class JsonPackage {
    private String action;

    private String[] docsName;

    private String[] textInDocs;



    public JsonPackage(String action, String[] docsName, String[] textInDocs) {

        this.action = action;

        this.docsName = docsName;

        this.textInDocs = textInDocs;

    }



    public JsonPackage(String action) {

        this.action = action;

    }
}
