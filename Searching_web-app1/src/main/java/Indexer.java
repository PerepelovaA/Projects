import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sun.reflect.generics.tree.TypeVariableSignature.make;

/**
 * Created by user on 13.10.2016.
 */
public class Indexer {

    private static Indexer instance;
    private HashMap<String,TreeSet<Integer>> wordToDocument;
    private HashMap<Integer,String> fileNames;
    FileManager fm = new FileManager();
    private static final Logger LOG = Logger.getLogger(Indexer.class.getName());

    public HashMap<String,TreeSet<Integer>> getWordToDocument(){
        return wordToDocument;
    }
    private void Indexer(){

        String envVarName = "MY_SEARCH_DIRECTORY";
        LOG.log(Level.INFO, "using environment variable: [" + envVarName + "]");
        String directory = System.getenv(envVarName);
        wordToDocument = new HashMap<String, TreeSet<Integer>>();
        int index=0;
        String[] arr;
        Integer i=1;
        Iterator<String> iterator = fm.getFull_files().iterator();
       TreeSet<Integer> values= new TreeSet() ;
        while (iterator.hasNext()){
            arr = iterator.next().split(" ");
            values.add(i);
            for (int j = 0; j < arr.length; j++) {
                if (wordToDocument.get(arr[j]) == null)
                    wordToDocument.put(arr[j], values);
                else
                    wordToDocument.get(arr[j]).add(i);
            }
            values.clear();
            i++;
        }
    }
    public static Indexer getInstance(){

        if( instance==null)
            instance = new Indexer();
        return instance;
    }
    public String search(String searchText){
        String results="";
        Integer[] all=new Integer[10];
        searchText = searchText.toLowerCase();
        String[] searchWords = searchText.split(" ");
        Set<Integer> file_num = new TreeSet<Integer>();
        file_num = fileNames.keySet();
        for (int j=0;j<searchWords.length;j++){
            if (wordToDocument.get(searchWords[j]) != null)
                file_num = intersection(file_num,wordToDocument.get(searchWords[j]));
            else {
                System.out.println("No file which contains this word!!");
                LOG.log(Level.WARNING,"No file which contains this word!!");
            }

        }
        file_num.toArray(all);
         for(int i=0;i<all.length;i++){
            results = results+fileNames.get(all[i])+"', '";
        }

        return results;
    }
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<T>();
        for (T x : setA)
            if (setB.contains(x))
                tmp.add(x);
        return tmp;
    }

}
