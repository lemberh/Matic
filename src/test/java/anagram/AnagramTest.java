package anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Roman on 12/13/2016.
 */
public class AnagramTest {

    Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
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
    }

    @Test
    public void dictionarySetupTest() throws Exception {
        Assert.assertEquals(42930, dictionary.size());
    }

//    @Test
//    public void combinations() throws Exception {
//
//    }
//
//    @Test
//    public void findAnagrams() throws Exception {
//
//    }

}