package anagram;

import java.util.*;

public class Anagram {

    public static void combinations(String pref, List<String> s, Set<List<String>> result) {
        if (s.isEmpty()) {
//            System.out.println("END --- ");
            return;
        }

        List<String> row = new ArrayList<>(s);
        row.add(0, pref);
        result.add(row);

        for (int i = 1; i < s.size(); i++) {
            List<String> subset = new LinkedList<>(s);
            String n = subset.get(0) + subset.get(i);
            subset.remove(i);
            subset.remove(0);
            subset.add(0, n);
            row = new ArrayList<>(subset);
            row.add(0, pref);
            result.add(row);
        }
//        System.out.println(pref + ',' + String.join(",",s));

        Iterator<String> iter = s.iterator();
        for (int i = 0; i < s.size(); i++) {
            List<String> subset = new LinkedList<>(s);
            subset.remove(i);
            combinations(pref + iter.next(), subset, result);
        }
    }

    public static Set<List<String>> combinations(String s) {
        if (s.isEmpty()) return Collections.singleton(Collections.singletonList(""));
        List<String> chars = new LinkedList<>(Arrays.asList(s.split("")));
        String pref = chars.get(0);
        chars.remove(0);

        Set<List<String>> res = new HashSet<>(chars.size() * chars.size() / 2);
        res.add(Collections.singletonList(s));
        combinations(pref, chars, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinations("aabc").size());
        System.out.println(combinations("aabc"));
//        Dictionary dict = Dictionary.getDictionary("a b c ab abc");
//        System.out.println(dict);
//        System.out.println(combinations("aabc"));
//        System.out.println("For --aabc--");
//        System.out.println(dict.findAnagrams("aabc"));
//        System.out.println("For --aabcd--");
//        System.out.println(dict.findAnagrams("aabcd"));
//        Dictionary d2 = Dictionary.getDictionary("least setal slate stale steal stela taels tales teals tesla es tla");
//        System.out.println(d2.findAnagrams("aelst"));
//        System.out.println(dict.getPermutations("a","a","b","c"));
//        System.out.println(dict.getPermutations("abc","a"));
//        System.out.println(dict.getPermutations("cbd","c","dba"));
//        System.out.println(Dictionary.occurrencesMap("aabc"));
//        System.out.println(Dictionary.getDictionary("abc").get(Dictionary.occurrencesMap("cba")));
    }
}
