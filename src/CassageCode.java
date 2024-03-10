import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CassageCode {
    String caractereEncode;
    LinkedHashMap<Character, Double> frOccurences;
    double[] t = {7.97, 1.07, 3.47, 4, 17.9, 1.01, 1.04, 1.35, 7.34, 0.3, 0.069, 5.48, 3.17, 7.02, 5.27, 2.8, 1.13, 6.64, 7.72, 7.28, 5.74, 1.17, 0.059, 0.449, 0.309, 0.04};

    CassageCode(String code){
        this.caractereEncode = code;
        frOccurences = new LinkedHashMap<Character, Double>();

    }

    public LinkedHashMap<Character, Double> frequenceApparition(String s){
        LinkedHashMap<Character, Double> occurences = new LinkedHashMap<Character, Double>();
        int j = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                j++;
                c = Character.toLowerCase(c);
                if(occurences.containsKey(c)){
                    occurences.put(c, occurences.get(c)+1);
                }
                else{
                    occurences.put(c, 1.0);
                }
            }
        }
//        for(char c: occurences.keySet()){
//            occurences.put(c, occurences.get(c)/j);
//        }
        return occurences;
    }

    public char carreDifference(String s){
        LinkedHashMap<Character, Double> occ = this.frequenceApparition(s);
        System.out.println(occ);
        LinkedHashMap<Character, Double> newOcc = new LinkedHashMap<Character, Double>();
        for(int i=0; i<26; i++){
            double v = 0;
            if(occ.containsKey((char)('a'+i))){
                v = occ.get((char)('a'+i));
            }
            newOcc.put((char)('a'+i), (v-this.t[i])*(v-this.t[i]));
        }
        System.out.println(newOcc);
        Map.Entry<Character, Double> min = null;
        for (Map.Entry<Character, Double> entry : newOcc.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        return min.getKey();
    }
}
