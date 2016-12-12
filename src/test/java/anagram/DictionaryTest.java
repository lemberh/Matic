package anagram;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Roman on 12/8/2016.
 */
public class DictionaryTest {
    private final static String ANAGRAMS = "least setal slate stale steal stela taels tales teals tesla";

    private anagram.Dictionary dict;
    private anagram.Dictionary longDict;
    private anagram.Dictionary dict_aabcd;
    private Occurrences occ_aabcd;
    private Occurrences occ_abc;

    @Before
    public void setup() {
        dict = Dictionary.getDictionary("abbc ab ba abc aa aabc a b c");
        longDict = Dictionary.getDictionary(ANAGRAMS);

        occ_abc = Occurrences.occurrencesMap("abc");
        occ_aabcd = Occurrences.occurrencesMap("aabcd");
        dict_aabcd = new Dictionary();
        dict_aabcd.put(occ_aabcd, new HashSet<>(Arrays.asList("aabcd", "bcdaa", "acabd")));
        dict_aabcd.put(occ_abc, new HashSet<>(Arrays.asList("abc", "cba", "bac")));
    }

    @Test
    public void getDictionary() throws Exception {
        Assert.assertEquals(dict_aabcd, Dictionary.getDictionary("aabcd", "bcdaa", "acabd", "abc", "cba", "bac"));
        Assert.assertNotEquals(dict_aabcd, Dictionary.getDictionary("aabcd", "bcdaa", "acabd", "abcd", "cba", "bac"));
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new HashSet<>(Arrays.asList(ANAGRAMS.split(" "))), longDict.getAnagrams("slate"));
        Assert.assertEquals(new HashSet<>(Arrays.asList("ab", "ba")), dict.getAnagrams("ab"));
    }

    @Test
    public void getPermutations() throws Exception {
        Assert.assertEquals(new HashSet<>(Arrays.asList(ANAGRAMS.split(" "))), longDict.getAnagrams("slate"));
        Assert.assertEquals(new HashSet<>(Arrays.asList(ANAGRAMS.split(" "))), longDict.getAnagrams("slate"));
    }
}