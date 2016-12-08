package anagram;

import java.util.HashMap;

/**
 * Created by Roman on 12/8/2016.
 */
public class Occurrences extends HashMap<Character, Integer> {

    static public Occurrences occurrencesMap(String word) {
        Occurrences map = new Occurrences();
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            Integer count = map.get(ch);
            if (count == null) {
                count = 0;
            }
            map.put(ch, count + 1);
        }
        return map;
    }

    public Occurrences() {
        super();
    }

    public Occurrences(Occurrences occurrences) {
        super(occurrences);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Occurrences ? compare((Occurrences) o) : super.equals(o);
    }

    public boolean compare(Occurrences to) {
        for (Character key : to.keySet()) {
            if (get(key) == null || !get(key).equals(to.get(key))) {
                return false;
            }
        }
        return true;
    }
}