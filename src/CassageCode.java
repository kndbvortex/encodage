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
        LinkedHashMap<Character, Double> occ_2 = new LinkedHashMap<>();
        for(int i=0; i<26; i++){
            occ_2.put((char)('a'+i), this.t[i]);
        }
        LinkedHashMap<Character, Double> newOcc = new LinkedHashMap<Character, Double>();
        double d = -1*Double.MAX_VALUE;
        char most_frequent = 'e';
        for(int i=0; i<26; i++){
            double v = 0;
            if(occ.containsKey((char)('a'+i))){
                v = occ.get((char)('a'+i));
            }
            newOcc.put((char)('a'+i), v);
            if (v>d){
                most_frequent=(char)('a'+i);
                d = v;
            }
        }
        System.out.println(occ_2);
        System.out.println(newOcc);
        System.out.println("Lettre probable de l'encodage: " + (char)('a' + most_frequent-'e') +
                " car  <<"+ most_frequent + ">> est la lettre la plus fréquente");

        return most_frequent;
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

    private  double _IC(int p, String s){
        String[] substring = new String[p];
        double[] l = new double[p];
        double[] l_2 = new double[p];
        Arrays.fill(substring, "");
        int k=-1;
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                k++;
                substring[k%p] += s.charAt(i);

            }
        }
        int i = 0;
        for(int j=0; j<p; j++){
            l_2[i] = this.calculIndice(substring[i]);
        }
        while(i < p){
            l[i] = l_2[i]/p;
            for(int j=0; j<i; j++){
                l[i] += l_2[j]/p;
            }
            i++;
        }
        return  Arrays.stream(l).sum();
    }


    private void _indiceCoincidence(int p, String s){
        double icDepart = _IC(1, s);
        if(icDepart > (0.8) *this.icFR){
            System.out.println("Texte codé avec clé de taille 1");
        }else{
            String[] substring = new String[p];
            double[] l = new double[p];
            Arrays.fill(substring, "");
            int k=-1;
            for(int i=0; i<s.length(); i++){
                if(Character.isAlphabetic(s.charAt(i))){
                    k++;
                    substring[k%p] += s.charAt(i);

                }
            }

            int i = 2;

            l[1] = this._IC(1, s);
            while(i < p){
                l[i] = this._IC(i, s);
                if((l[i] > this.icFR) || (l[i] > (1.5)*l[i-1])){
                    System.out.println("Taille optimale "+ (i));
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
