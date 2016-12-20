import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 13.10.2016.
 */
public class FileManager {

    final File catalog = new File("C://Users/user/OneDrive/Doc/Texts");
    private File[] files = catalog.listFiles();
    private List<String> full_files = new ArrayList<String>();

    public FileManager(){
        for (File file:files) {
            try {
                full_files.add(read(file.getAbsolutePath()));
            }catch (Exception e) {
                System.out.println("There is no file!!!");
            }
        }
    }
    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        isexist(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static void isexist(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if(!file.exists())
            throw new FileNotFoundException();
    }
    public List<String> getFull_files(){
        return full_files;
    }
}
