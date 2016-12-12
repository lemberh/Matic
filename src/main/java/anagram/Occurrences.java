package anagram;

import java.util.HashMap;

/**
 * Created by Roman on 12/8/2016.
 */
public class Occurrences extends HashMap<Character, Integer> {

    public Occurrences(int size) {
        super(size);
    }

    public Occurrences(Character key, Integer value) {
        super();
        put(key, value);
    }

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

    /**
     * @param other others should be a subset of current set
     * @return all elements from current set except elements in <b>other</b>
     */
    public Occurrences subtracts(Occurrences other) {
        Occurrences resulting = new Occurrences(other.size());
        forEach((key, value) -> {
            int newValue = value - other.getOrDefault(key, 0);
            if (newValue > 0) {
                resulting.put(key, newValue);
            }
        });
        return resulting;
    }
}