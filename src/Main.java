
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "Vous faites un TP d’informatique en ce moment";
//        CodeCesar codeCesar = new CodeCesar('T', s, true);
//        System.out.println(codeCesar);
//        codeCesar = new CodeCesar('F', "Atzx kfnyjx zs YU i’nsktwrfynvzj js hj rtrjsy", false);
//        System.out.println(codeCesar);

        CodeVigenere codeVigenere = new CodeVigenere("TPFI", s, true );
        System.out.println(codeVigenere);
        codeVigenere = new CodeVigenere("TPFI", "Odza ypnbxh zv ME i’qgutzfpyqjjj mg rj uhbjvm", false );
        System.out.println(codeVigenere);
    }
}