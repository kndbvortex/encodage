public class CodeVigenere extends EncodageDecodage{
    String cle;

    CodeVigenere(String cle, String msg, boolean encodage){
        super(msg, encodage);
        this.cle = cle;
    }

    private Character encodeChar(char c, int position){
        int pas = this.cle.charAt(position) < 'A'? this.cle.charAt(position)-'a': this.cle.charAt(position)-'A';
        if(Character.isAlphabetic(c)){
            if(c >= 'A' && c<='Z'){
                return ((char)('A' + (c-'A'+pas)%26));
            }else {
                return ((char)('a' + (c-'a'+pas)%26));
            }
        }else{
            return c;
        }
    }

    private Character decodeChar(char c, int position){
        int pas = this.cle.charAt(position) < 'A'? this.cle.charAt(position)-'a': this.cle.charAt(position)-'A';
        if(Character.isAlphabetic(c)){
            if(c >= 'A' && c<='Z'){
                return ((char)('A' + (((c-'A'-pas)%26)+26) %26 ));
            }else {
                return ((char)('a' + (((c-'a'-pas)%26)+26) %26 ));
            }
        }else{
            return c;
        }
    }

    @Override
    public String encoder() {
        StringBuilder s = new StringBuilder();
        int j = -1;
        for(int i=0; i<this.message.length(); i++){
            if(Character.isAlphabetic(this.message.charAt(i))){
                j++;
            }
            s.append(this.encodeChar(this.message.charAt(i), j%this.cle.length()));
        }
        return s.toString();
    }
    @Override
    public String decoder() {
        StringBuilder s = new StringBuilder();
        int j = -1;
        for(int i=0; i<this.message.length(); i++){
            if(Character.isAlphabetic(this.message.charAt(i))){
                j++;
            }
            s.append(this.decodeChar(this.message.charAt(i), j%this.cle.length()));
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "Code Vigenere\n" + super.toString();
    }
}
