public abstract class EncodageDecodage {
    String message;
    boolean encodage;

    public static String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public EncodageDecodage(){
        this.message= new String("");
        this.encodage = true;
    }

    public EncodageDecodage(String msg, boolean encodage){
        this.message = msg;
        this.encodage = encodage;
    }
    public boolean isEncodage() {
        return encodage;
    }

    public abstract String encoder();
    public abstract String decoder();

    @Override
    public String toString(){
        String s = this.encodage? "Codage": "Décodage";
        s += String.format("\nChaine d'origine : << %s >>\n%s : <<%s>>\n", this.message, s, this.encodage?this.encoder():this.decoder());
        return s;
    }
}
