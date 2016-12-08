package anagram;


import org.junit.Before;

/**
 * Created by Roman on 12/8/2016.
 */
public class DictionaryTest {

    anagram.Dictionary dict;

    @Before
    public void setup() {
        dict = Dictionary.getDictionary("abbc ab abc aa aabc a b c");
    }

    @org.junit.Test
    public void getDictionary() throws Exception {
        System.out.println(dict.getPermutations("ab", "aabc", "abcd"));
    }

    @org.junit.Test
    public void get() throws Exception {

    }

    @org.junit.Test
    public void getPermutations() throws Exception {

    }

    @org.junit.Test
    public void getPermutations1() throws Exception {

    }

    @org.junit.Test
    public void findAnagrams() throws Exception {

    }

}