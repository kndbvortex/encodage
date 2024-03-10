public class CodeCesar extends EncodageDecodage {
    char cle;

    CodeCesar(char cle, String msg, boolean encodage){
        super(msg, encodage);
        this.cle = cle;
    }

    @Override
    public String encoder() {
        int pas = this.cle < 'A'? this.cle-'a': this.cle-'A';
        StringBuilder s = new StringBuilder();
        for(int i=0; i<this.message.length(); i++){
            char c = this.message.charAt(i);
            if(Character.isAlphabetic(c)){
                if(c >= 'A' && c<='Z'){
                    s.append((char)('A' + (c-'A'+pas)%26));
                }else {
                    s.append((char)('a' + (c-'a'+pas)%26));
                }
            }else{
                s.append(c);
            }
        }
        return s.toString();
    }
    @Override
    public String decoder() {
        int pas = this.cle < 'A'? this.cle-'a': this.cle-'A';
        StringBuilder s = new StringBuilder();
        for(int i=0; i<this.message.length(); i++){
            char c = this.message.charAt(i);
            if(Character.isAlphabetic(c)){
                if(c >= 'A' && c<='Z'){
                    s.append((char)('A' + (((c-'A'-pas)%26)+26) %26 ));
                }else {
                    s.append((char)('a' + (((c-'a'-pas)%26)+26) %26 ));
                }
            }else{
                s.append(c);
            }
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "Code Cesar\n" + super.toString();
    }

}
