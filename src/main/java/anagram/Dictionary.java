package anagram;

import java.util.*;

import static anagram.Occurrences.occurrencesMap;

/**
 * Created by Roman on 12/8/2016.
 */
public class Dictionary extends HashMap<Occurrences, Set<String>> {

    public static Dictionary getDictionary(String... words) {
        Dictionary wordsMap = new Dictionary();
        for (String word : words) {
            Occurrences key = occurrencesMap(word);
            Set<String> set = wordsMap.get(key);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(word);
            wordsMap.put(occurrencesMap(word), set);
        }
        return wordsMap;
    }

    public static Dictionary getDictionary(String dict) {
        return getDictionary(dict.split(" "));
    }

    public Dictionary(Dictionary dictionary) {
        super(dictionary);
    }

    public Dictionary() {
        super();
    }

    /**
     * @param word
     * @return anagrams of word that exists in the dictionary
     */
    public Set<String> get(String word) {
        return get(occurrencesMap(word));
    }

    /**
     * @see #getAnagrams(String...)
     */
    public Set<String> getAnagrams(List<String> words) {
        return getAnagrams((String[]) words.toArray(new String[words.size()]));
    }

    /**
     * @param words to look for anagrams
     * @return Set of all anagrams of the given words
     * (if at least one word doesn't have anagrams then return empty set)
     */
    public Set<String> getAnagrams(String... words) {
        Set<String> anagrams = new HashSet<>();
        for (String word : words) {
            Set<String> singleWordAnagrams = get(word);
            if (singleWordAnagrams == null || singleWordAnagrams.size() == 0) {
                return Collections.emptySet();
            }
            anagrams.addAll(singleWordAnagrams);
        }
        return anagrams;
    }
}