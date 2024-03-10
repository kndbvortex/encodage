import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CodeCesar codeCesar = new CodeCesar('F', "Vous faites un TP d’informatique en ce moment", true);
        System.out.println(codeCesar);
        codeCesar = new CodeCesar('F', "Atzx kfnyjx zs YU i’nsktwrfynvzj js hj rtrjsy", false);
        System.out.println(codeCesar);
    }
}