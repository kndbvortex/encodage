import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CassageCode {
    String caractereEncode;
    double icFR = 0.0745;
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

    private double calculIndice(String s){
        double r = 0;
        int n = s.length();
        LinkedHashMap<Character, Double> occ = this.frequenceApparition(s);
        for(char c: occ.keySet()){
            r += (occ.get(c)*(occ.get(c) - 1))/(n*(n-1));
        }

        return r;
    }


    private void _indiceCoincidence(int p, String s){
        double icDepart = this.calculIndice(s);
        if(icDepart > (0.8) *this.icFR){
            System.out.println("Texte codé avec clé de taille 1");
        }else{
            String[] substring = new String[p];
            double[] l = new double[p];
            double[] absDiffFR = new double[p];
            Arrays.fill(substring, "");
            for(int i=0; i<s.length(); i++){
                substring[i%p] += s.charAt(i);
            }
            l[0] = this.calculIndice(substring[0]);
            int i = 1;
            while(i < p){
                l[i] = this.calculIndice(substring[i])/i;
                for(int j=0; j<i; j++){
                    l[i] += l[j]/i;
                }
                if((l[i] > this.icFR) || (l[i] > (1.5)*l[i-1])){
                    System.out.println("Taille optimale "+ i);
                    break;
                }
                i++;
            }
            if(i == p) {
                System.out.println("Taille optimale.... " + p);

            }
            System.out.println(Arrays.toString(l));

        }
    }

    public void indiceCoincidence(String s){
        this._indiceCoincidence(32, s);
    }
}
