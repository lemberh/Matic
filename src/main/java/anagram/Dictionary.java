package anagram;

import java.util.*;

import static anagram.Anagram.combinations;
import static anagram.Occurrences.occurrencesMap;

/**
 * Created by Roman on 12/8/2016.
 */
public class Dictionary extends HashMap<Occurrences, Set<String>> {

    public static Dictionary getDictionary(String dict) {
        Dictionary wordsMap = new Dictionary();
        String[] words = dict.split(" ");
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

    public Dictionary(Dictionary dictionary) {
        super(dictionary);
    }

    public Dictionary() {
        super();
    }

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

    public Set<String> findAnagrams(String word) {
        Set<String> anagrams = new HashSet<>();
        for (List<String> row : combinations(word)) {
            String anagram = getPermutations(row);
            if (!anagram.isEmpty()) {
                anagrams.add(anagram);
            }
        }
        return anagrams;
    }
}