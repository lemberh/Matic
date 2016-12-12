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

    public String getPermutations(List<String> words) {
        return getPermutations((String[]) words.toArray(new String[words.size()]));
    }

    public String getPermutations(String... words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            Set<String> anagrams = get(word);
            if (anagrams == null || anagrams.size() == 0) {
                return "";
            }
            sb.append(Arrays.toString(anagrams.toArray()));
        }
        return sb.toString();
    }
}