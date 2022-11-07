package util;

public class ArrayUtil {

    static public String changeBracket(String s) {
        return s.replaceAll("\\[", "{").replaceAll("]", "}");
    }
}
