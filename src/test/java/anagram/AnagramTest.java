package anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by Roman on 12/13/2016.
 */
public class AnagramTest {

    private static final int CORRECT_DICTIONARY_SIZE = 42253;

    private static Dictionary dictionary;
    private static Anagram anagram;

    @BeforeClass
    public static void setupDictionary() throws Exception{
//        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("linuxwords.txt");
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
//            String line;
//
//            List<String> l = new LinkedList<>();
//            while ((line = in.readLine()) != null) {
//                l.add(line);
//            }
//            String[] s = l.toArray(new String[l.size()]);
//            dictionary = Dictionary.getDictionary(s);
//            in.close();
//        }
//        anagram = new Anagram(dictionary);
    }

    @Test
    public void dictionarySetupTest() throws Exception {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("linuxwords.txt");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;

            List<String> l = new LinkedList<>();
            while ((line = in.readLine()) != null) {
                l.add(line);
            }
            String[] s = l.toArray(new String[l.size()]);
            dictionary = Dictionary.getDictionary(s);
            in.close();
        }
        anagram = new Anagram(dictionary);
        Assert.assertEquals(CORRECT_DICTIONARY_SIZE, dictionary.size());
    }

    @Test
    public void combinations() throws Exception {

    }

//    @Test
//    public void findAnagrams() throws Exception {
//        List<List<String>> expected = new ArrayList<>(Arrays.asList(
//                Arrays.asList("Rex", "Lin", "Zulu"),
//                Arrays.asList("nil", "Zulu", "Rex"),
//                Arrays.asList("Rex", "nil", "Zulu"),
//                Arrays.asList("Zulu", "Rex", "Lin"),
//                Arrays.asList("null", "Uzi", "Rex"),
//                Arrays.asList("Rex", "Zulu", "Lin"),
//                Arrays.asList("Uzi", "null", "Rex"),
//                Arrays.asList("Rex", "null", "Uzi"),
//                Arrays.asList("null", "Rex", "Uzi"),
//                Arrays.asList("Lin", "Rex", "Zulu"),
//                Arrays.asList("nil", "Rex", "Zulu"),
//                Arrays.asList("Rex", "Uzi", "null"),
//                Arrays.asList("Rex", "Zulu", "nil"),
//                Arrays.asList("Zulu", "Rex", "nil"),
//                Arrays.asList("Zulu", "Lin", "Rex"),
//                Arrays.asList("Lin", "Zulu", "Rex"),
//                Arrays.asList("Uzi", "Rex", "null"),
//                Arrays.asList("Zulu", "nil", "Rex"),
//                Arrays.asList("rulez", "Linux"),
//                Arrays.asList("Linux", "rulez")
//        ));
//        List<List<String>> actual =  anagram.findAnagrams("Linux","rulez");
//        Collections.sort(expected,(o1, o2) -> String.join("",o1).compareToIgnoreCase(String.join("",o2)));
//        Collections.sort(actual,(o1, o2) -> String.join("",o1).compareToIgnoreCase(String.join("",o2)));
//        Assert.assertEquals(expected,actual);
//    }

}