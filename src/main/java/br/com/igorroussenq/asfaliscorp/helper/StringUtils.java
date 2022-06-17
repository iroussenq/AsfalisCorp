package br.com.igorroussenq.asfaliscorp.helper;

import java.util.Objects;

public class StringUtils {

    private StringUtils() { }

    public static String extractNumbers(final String val){
        if(Objects.nonNull(val)) {
            return val.replaceAll("\\D+", "");
        }
        return "";
    }

}
