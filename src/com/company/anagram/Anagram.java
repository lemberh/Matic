package com.company.anagram;

import java.util.*;

import static com.company.anagram.Anagram.OccMap.occurrencesMap;

public class Anagram {

    static class Dictionary extends HashMap<OccMap,Set<String>> {

        public static Dictionary getDictionary(String dict){
            Dictionary wordsMap = new Dictionary();
            String [] words = dict.split(" ");
            for (String word : words) {
                OccMap key = occurrencesMap(word);
                Set<String> set = wordsMap.get(key);
                if (set == null){
                    set = new HashSet<>();
                }
                set.add(word);
                wordsMap.put(occurrencesMap(word),set);
            }
            return wordsMap;
        }

        public Dictionary(Dictionary dictionary) {
            super(dictionary);
        }

        public Dictionary() {
            super();
        }

        public Set<String> get(String word){
            return get(occurrencesMap(word));
        }

        public String getPermutations (List<String> words){
            return getPermutations((String[]) words.toArray(new String[words.size()]));
        }

        public String getPermutations (String ... words){
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                Set<String> anagrams = get(word);
                if (anagrams == null || anagrams.size() == 0){
                    return "";
                }
                sb.append(Arrays.toString(anagrams.toArray()));
            }
            return sb.toString();
        }

        public Set<String> findAnagrams(String word){
            Set<String> anagrams = new HashSet<>();
            for (List<String> row: combinations(word)){
                String anagram = getPermutations(row);
                if (!anagram.isEmpty()) {
//                System.out.println(anagram);
                    anagrams.add(anagram);
                }
            }
            return anagrams;
        }


    }


    public static class OccMap extends HashMap<Character,Integer> {

        static public OccMap occurrencesMap(String word){
            OccMap map = new OccMap();
            char [] chars = word.toCharArray();
            for (char ch : chars) {
                Integer count = map.get(ch);
                if (count == null){
                    count = 0;
                }
                map.put(ch,count+1);
            }
            return map;
        }

        public OccMap() {
            super();
        }

        public OccMap(OccMap occurrences) {
            super(occurrences);
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof OccMap ? compare((OccMap) o) : super.equals(o);
        }

        public boolean compare (OccMap to){
            for (Character key:to.keySet()) {
                if (get(key) == null || !get(key).equals(to.get(key))){
                    return false;
                }
            }
            return true;
        }
    }

    public static void combinations(String pref,List<String> s,Set<List<String>> result){
        if (s.isEmpty()){
//            System.out.println("END --- ");
            return;
        }

        List<String> row = new ArrayList<>(s);
        row.add(0,pref);
        result.add(row);
//        System.out.println(pref + ',' + String.join(",",s));

        Iterator<String> iter = s.iterator();
        for (int i = 0; i < s.size(); i++) {
            List<String> subset = new LinkedList<>(s);
            subset.remove(i);
            combinations(pref + iter.next(),subset,result);
        }
    }

    public static Set<List<String>> combinations(String s){
        if (s.isEmpty()) return Collections.singleton(Collections.singletonList(""));
        List<String> chars = new LinkedList<>(Arrays.asList(s.split("")));
        String pref = chars.get(0);
        chars.remove(0);

        Set<List<String>> res = new HashSet<>(chars.size()*chars.size()/2);
        res.add(Collections.singletonList(s));
        combinations(pref,chars,res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinations("aelst"));
//        Dictionary dict = Dictionary.getDictionary("a b c ab abc");
//        System.out.println(dict);
//        System.out.println(combinations("aabc"));
//        System.out.println("For --aabc--");
//        System.out.println(dict.findAnagrams("aabc"));
//        System.out.println("For --aabcd--");
//        System.out.println(dict.findAnagrams("aabcd"));
        Dictionary d2 = Dictionary.getDictionary("least setal slate stale steal stela taels tales teals tesla es tla");
        System.out.println(d2.findAnagrams("aelst"));
//        System.out.println(dict.getPermutations("a","a","b","c"));
//        System.out.println(dict.getPermutations("abc","a"));
//        System.out.println(dict.getPermutations("cbd","c","dba"));
//        System.out.println(Dictionary.occurrencesMap("aabc"));
//        System.out.println(Dictionary.getDictionary("abc").get(Dictionary.occurrencesMap("cba")));
    }
}
