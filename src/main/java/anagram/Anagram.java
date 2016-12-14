package anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Anagram {

    private Dictionary dict;

    public Anagram(Dictionary dict) {
        this.dict = dict;
    }

    public List<List<String>> findAnagrams(String word) {
        Occurrences occ = Occurrences.occurrencesMap(word);
        return anagramsCombinations(occ);
    }

    private List<List<String>> anagramsCombinations(Occurrences occ) {
        List<List<String>> result = new ArrayList<>();
        List<Occurrences> combinations = combinations(occ);
        combinations.forEach(combination -> {
            Set<String> anagrams = dict.get(combination);
            if (anagrams != null) {
                Occurrences subset = occ.subtracts(combination);
                if (subset.isEmpty()) {
                    anagrams.forEach(anagram -> {
                        List<String> set = new ArrayList<>();
                        set.add(anagram);
                        result.add(set);
                    });
                } else {
                    List<List<String>> anagramCombinations = anagramsCombinations(subset);
                    anagrams.forEach(anagram -> anagramCombinations.forEach(anagramCombination -> {
                        List<String> r = new ArrayList<>(anagramCombination);
                        r.add(anagram);
                        result.add(r);
                    }));
                }
            }
        });
        return result;
    }


    /**
     * @param occ - Occurrence map of word of sentence
     * @return return all possible combinations of elements in <b>occ</b>
     */
    private List<Occurrences> combinations(Occurrences occ) {
        if (occ.isEmpty()) {
            return new ArrayList<>();
        }
        List<Occurrences> result = new ArrayList<>();
        Occurrences acc = new Occurrences();
        occ.forEach((key, value) -> {
            acc.put(key, value);
            for (int i = 1; i <= value; i++) {
                List<Occurrences> combinations = combinations(occ.subtracts(acc));
                Occurrences currentEl = new Occurrences(key, i);
                combinations.forEach(occurrences -> occurrences.putAll(currentEl));
                combinations.add(currentEl);
                result.addAll(combinations);
            }
        });
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(combinations("aabc").size());
        Anagram a = new Anagram(Dictionary.getDictionary("aabc", "abc", "bca", "cb", "a", "ba", "c"));
        System.out.println("findAnagrams(\"aabc\")");
        a.findAnagrams("aabc").forEach(System.out::println);
        System.out.println(a.findAnagrams("aabc").size());
        System.out.println("a.anagramsCombinations(Occurrences.occurrencesMap(\"aabc\"))");
        a.anagramsCombinations(Occurrences.occurrencesMap("aabc")).forEach(System.out::println);
        System.out.println("a.combinations(Occurrences.occurrencesMap(\"aabc\"))");
        a.combinations(Occurrences.occurrencesMap("aabc")).forEach(System.out::println);
//        Dictionary dict = Dictionary.getDictionary("a b c ab abc");
//        System.out.println(dict);
//        System.out.println(combinations("aabc"));
//        System.out.println("For --aabc--");
//        System.out.println(dict.findAnagrams("aabc"));
//        System.out.println("For --aabcd--");
//        System.out.println(dict.findAnagrams("aabcd"));
//        Dictionary d2 = Dictionary.getDictionary("least setal slate stale steal stela taels tales teals tesla es tla");
//        System.out.println(d2.findAnagrams("aelst"));
//        System.out.println(dict.getAnagrams("a","a","b","c"));
//        System.out.println(dict.getAnagrams("abc","a"));
//        System.out.println(dict.getAnagrams("cbd","c","dba"));
//        System.out.println(Dictionary.occurrencesMap("aabc"));
//        System.out.println(Dictionary.getDictionary("abc").get(Dictionary.occurrencesMap("cba")));
    }
}
