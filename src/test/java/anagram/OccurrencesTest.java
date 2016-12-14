package anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Roman on 12/12/2016.
 */
public class OccurrencesTest {

    private Occurrences occ_aabcd;
    private Occurrences occ_abc;

    @Before
    public void setup() {
        occ_abc = Occurrences.occurrencesMap("abc");
        occ_aabcd = Occurrences.occurrencesMap("aabcd");
    }

    @Test
    public void occurrencesMap() throws Exception {
        Occurrences correctValues = new Occurrences();
        correctValues.put('a', 2);
        correctValues.put('b', 1);
        correctValues.put('c', 1);
        correctValues.put('d', 1);
        Assert.assertEquals(occ_aabcd, correctValues);
    }

    @Test
    public void equals() throws Exception {
        Assert.assertEquals(occ_abc, Occurrences.occurrencesMap("abc"));
        Assert.assertEquals(occ_abc, Occurrences.occurrencesMap("cab"));
        Assert.assertNotEquals(occ_abc, Occurrences.occurrencesMap("abcd"));
        Assert.assertEquals(occ_aabcd, Occurrences.occurrencesMap("aabcd"));
        Assert.assertEquals(occ_aabcd, Occurrences.occurrencesMap("bacad"));
        Assert.assertNotEquals(occ_aabcd, Occurrences.occurrencesMap("a"));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Assert.assertEquals(occ_abc.hashCode(), Occurrences.occurrencesMap("abc").hashCode());
        Assert.assertEquals(occ_abc.hashCode(), Occurrences.occurrencesMap("cab").hashCode());
        Assert.assertEquals(occ_aabcd.hashCode(), Occurrences.occurrencesMap("aabcd").hashCode());
        Assert.assertEquals(occ_aabcd.hashCode(), Occurrences.occurrencesMap("bacad").hashCode());
    }

    @Test
    public void subtracts() throws Exception {
        Occurrences occ = new Occurrences(occ_aabcd);
        Assert.assertEquals(occ.subtracts(Occurrences.occurrencesMap("abc")), Occurrences.occurrencesMap("ad"));
        Assert.assertEquals(occ.subtracts(Occurrences.occurrencesMap("aabcd")), new Occurrences());
        Assert.assertNotEquals(occ.subtracts(Occurrences.occurrencesMap("abc")), Occurrences.occurrencesMap("abc"));
    }

}