package chapter2;

import java.util.List;
import java.util.stream.Collectors;

public class Process {
    public String cleanNames(List<String> names) {
        if (names == null) return "";
        return names.stream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    public String cleanNamesã…–(List<String> names) {
        if (names == null) return "";
        return names.parallelStream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    private String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
    }
}
