package anagram;

import java.util.*;

/**
 * Created by Roman on 12/8/2016.
 */
public class Occurrences extends HashMap<Character, Integer> {

    private boolean isHashValid = true;
    private int hashCode = 1;

    public Occurrences(int size) {
        super(size);
    }

    public Occurrences(Character key, Integer value) {
        super();
        put(key, value);
    }

    static public Occurrences occurrencesMap(String ... words) {
        return occurrencesMap(String.join("",words));
    }

    static public Occurrences occurrencesMap(String word) {
        Occurrences map = new Occurrences();
        char[] chars = word.toLowerCase().toCharArray();
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
    public Integer put(Character key, Integer value) {
        isHashValid = false;
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends Character, ? extends Integer> m) {
        isHashValid = false;
        super.putAll(m);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Occurrences ? compare((Occurrences) o) : super.equals(o);
    }

    public boolean compare(Occurrences to) {
        if (this == to) return true;
        if (to.size() != size()) return false;
        for (Character key : to.keySet()) {
            Integer value = get(key);
            if (value == null || !Objects.equals(value, to.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (isHashValid){
            return hashCode;
        }
        hashCode = 1;
        List<Character> keys = new ArrayList<>(keySet());
        Collections.sort(keys);
        for (Character key : keys) {
            Integer valueHash = get(key);
            hashCode = 31 * hashCode + (valueHash == null ? 0 : valueHash);
            hashCode = 31 * hashCode + (key == null ? 0 : key);
        }
        isHashValid = true;
        return hashCode;
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