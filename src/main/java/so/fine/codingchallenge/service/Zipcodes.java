package so.fine.codingchallenge.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "zipcodes")
public class Zipcodes {

    private final Map<Integer, String> codesMap;

    public Zipcodes(int berlin, int brandenburg) {
        codesMap = new HashMap<>();
        codesMap.put(berlin, "Berlin");
        codesMap.put(brandenburg, "Brandenburg");
    }

    public String get(int zipcode) {
        return codesMap.getOrDefault(zipcode, "Deutschland");
    }
}
