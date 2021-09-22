package hw5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneDirectory {
    private HashMap<String, ArrayList<String>> personalTelephones = new HashMap<>();

    public void add(String key, String value) {
        if (personalTelephones.containsKey(key)) {
            personalTelephones.put(key, addPhone(key, value));
        } else {
            personalTelephones.put(key, new ArrayList<>());
        }
    }

    private ArrayList<String> addPhone(String key, String value) {
        ArrayList<String> telephoneArr;
        telephoneArr = personalTelephones.get(key);
        telephoneArr.add(value);
        return telephoneArr;
    }

    public List<String> get(String key){
        return personalTelephones.get(key);
    }
}
