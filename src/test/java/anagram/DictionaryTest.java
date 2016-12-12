package anagram;


import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Roman on 12/8/2016.
 */
public class DictionaryTest {

    anagram.Dictionary dict;
    anagram.Dictionary dict_aabcd;
    Occurrences occ_aabcd;
    Occurrences occ_abc;

    @Before
    public void setup() {
        dict = Dictionary.getDictionary("abbc ab abc aa aabc a b c");

        occ_abc = Occurrences.occurrencesMap("abc");
        occ_aabcd = Occurrences.occurrencesMap("aabcd");
        dict_aabcd = new Dictionary();
        dict_aabcd.put(occ_aabcd, new HashSet<>(Arrays.asList("aabcd", "bcdaa", "acabd")));
        dict_aabcd.put(occ_abc, new HashSet<>(Arrays.asList("abc", "cba", "bac")));
    }

    @org.junit.Test
    public void getDictionary() throws Exception {
        Assert.assertEquals(Dictionary.getDictionary("aabcd", "bcdaa", "acabd", "abc", "cba", "bac"), dict_aabcd);
        Assert.assertNotEquals(Dictionary.getDictionary("aabcd", "bcdaa", "acabd", "abcd", "cba", "bac"), dict_aabcd);
    }

    @org.junit.Test
    public void testOccurrences() {
        Occurrences correctValues = new Occurrences();
        correctValues.put('a', 2);
        correctValues.put('b', 1);
        correctValues.put('c', 1);
        correctValues.put('d', 1);
        Assert.assertEquals(occ_aabcd, correctValues);
    }

    @org.junit.Test
    public void getSubtraction() {
        Occurrences occ = new Occurrences(occ_aabcd);
        Assert.assertEquals(occ.subtracts(Occurrences.occurrencesMap("abc")), Occurrences.occurrencesMap("ad"));
        Assert.assertEquals(occ.subtracts(Occurrences.occurrencesMap("aabcd")), new Occurrences());
        Assert.assertNotEquals(occ.subtracts(Occurrences.occurrencesMap("abc")), Occurrences.occurrencesMap("abc"));
    }

    @org.junit.Test
    public void getPermutations() throws Exception {

    }

    @org.junit.Test
    public void findAnagrams() throws Exception {

    }

}