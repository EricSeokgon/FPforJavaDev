package chapter2;

import java.util.List;

public class TheCompanyProcess {
    public String cleanNames(List<String> listOfnames) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfnames.size(); i++) {
            if (listOfnames.get(i).length() > 1) {
                result.append(capitalizeString(listOfnames.get(i))).append(",");
            }
        }
        return result.substring(0, result.length() - 1).toString();
    }

    public String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }
}
