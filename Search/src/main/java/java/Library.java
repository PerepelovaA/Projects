package java; /**
 * Created by user on 21.12.2016.
 */
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllBytes;

/** @version 1.0
        * @since  1.6.0
        */

public class Library {
    private static Library instance;
    private ArrayList<String> documents;
    private HashMap<String, ArrayList<Integer>> map;
    private Library() {

        documents = new ArrayList<String>();

        map = new HashMap<String, ArrayList<Integer>>();



        File dir = new File("src/main/resources");

        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {

            for (File child : directoryListing) {

                byte[] encoded = new byte[0];

                try {
                    encoded =  readAllBytes(Paths.get(child.getPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String file = new String(encoded, StandardCharsets.UTF_8);
                documents.add(file);
                Integer curDoc = documents.size() - 1;
                String[] words = file.split("\\P{L}+");
                for(int i = 0; i < words.length; i++) {

                    String word = words[i].toLowerCase();

                    if (map.containsKey(word)) {

                        ArrayList<Integer> c = map.get(word);

                        c.add(curDoc);

                        map.put(word, c);

                    } else {

                        ArrayList<Integer> c = new ArrayList<Integer>();

                        c.add(curDoc);

                        map.put(word, c);

                    }

                }

            }

        } else {

        }

    }



    public static Library getInstance() {

        if (instance == null) {

            instance = new Library();

        }

        return instance;

    }



    public String getDocument(String[] words) {

        ArrayList<Integer> docs = new ArrayList<Integer>();

        for(int i = 0; i < documents.size(); i++) {

            docs.add(i);

        }

        for(int i = 0; i < words.length; i++) {

            String word = words[i].toLowerCase();

            ArrayList<Integer> newDocs = new ArrayList<Integer>();

            if (map.containsKey(word)) {

                for(int j = 0; j < docs.size(); j++) {

                    if (map.get(word).contains(docs.get(j))) {

                        newDocs.add(docs.get(j));

                    }

                }

            }

            docs = newDocs;

        }

        if (docs.size() == 0) {

            return null;

        }

        return documents.get(docs.get(0));

    }

}