package chapter1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    private Set<String> NON_WORDS = new HashSet<String>(){{
        add("the"); add("add"); add("of"); add("to"); add("a");
        add("i"); add("it"); add("in"); add("or"); add("is");
        add("d"); add("s"); add("as"); add("so"); add("but");
        add("be");
    }};

    public Map wordFreq(String word) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        Matcher m = Pattern.compile("\\w+").matcher(word);
        while (m.find()) {
            String words = m.group().toLowerCase(Locale.ROOT);
            if (!NON_WORDS.contains(words)) {
                if (wordMap.get(words) == null) {
                    wordMap.put(words, 1);
                } else {
                    wordMap.put(words, wordMap.get(words) + 1);
                }
            }
        }
        return wordMap;
    }
}
