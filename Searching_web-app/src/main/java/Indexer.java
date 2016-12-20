import sun.security.jca.GetInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by user on 13.10.2016.
 */
public class Indexer {

    private static Indexer instance;
    private HashMap<String,TreeSet<Integer>> wordToDocument;
    FileManager fm = new FileManager();

    public HashMap<String,TreeSet<Integer>> getWordToDocument(){
        return wordToDocument;
    }
    private void Indexer(){

     wordToDocument = new HashMap<String, TreeSet<Integer>>();
        int index=0;
        String[] arr;
        Integer i=1;
       TreeSet values= new TreeSet() ;
       // for(int i=0;i<10;i++){
                arr = fm.getFull_files().get(i).split(" ");
                values.add(i);
                for(int j=0;j<arr.length;j++) {
                    if(wordToDocument.get(arr[j])==null)
                        wordToDocument.put(arr[j],values);
                    else
                        wordToDocument.get(arr[j]).add(i);
                }
                values.clear();
    }
    public static Indexer getInstance(){

        if( instance==null)
            instance = new Indexer();
        return instance;
    }
    public List<String> search(String word){

        String Word = word.toLowerCase();
        ArrayList<String> results = new ArrayList<String>();
        TreeSet<Integer> file_num = new TreeSet<Integer>();
        if(wordToDocument.get(Word)!=null)
            file_num = wordToDocument.get(word);
        else
            System.out.println("No file which contains this word!!");
        for (Integer i:file_num) {
           results.add(i.toString()+",");
        }
        return results;
    }
}
