import java.text.Normalizer;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String b = "Je viens d’emménager avec ma compagne dans une nouvelle maison à Carlux en Dordogne. C’est une ville à quatorze kilomètres à l’est de Sarlat.\n" +
                "\n" +
                "Elle est vraiment super. Elle fait 120 m2.\n" +
                "\n" +
                "Elle a un grand salon qui sert de pièce principale pour la maison. Nous y avons installé un rétroprojecteur pour faire une petite salle de cinéma. Il y a aussi une bibliothèque où je range ma collection de comics ainsi que mes vinyles.\n" +
                "\n" +
                "La maison est très bien éclairée, car elle dispose de nombreuses fenêtres. Il y a aussi trois grandes chambres. Une pour nous, une qui sert de bureau et une autre qui est une chambre d’amis. Nous avons aussi une grande salle de bain, avec une grande baignoire et une douche.\n" +
                "\n" +
                "La maison a également une terrasse et un grand terrain de cinq hectares.\n" +
                "\n" +
                "Le midi, nous aimons bien nous installer sur la terrasse pour déjeuner ou recevoir des amis.\n" +
                "\n" +
                "Le terrain est plein de mauvaises herbes pour l’instant. Mais nous envisageons de tout couper, pour installer un poulailler et cultiver des fruits et légumes.\n" +
                "\n" +
                "Enfin, la maison a un grand garage, dans lequel nous pouvons garer nos deux voitures en rentrant du travail.";
        String s = "Vous faites un TP d’informatique en ce moment";
//        b = "bébé";

        b = Normalizer.normalize(b, Normalizer.Form.NFD);
        b = b.replaceAll("[^\\p{ASCII}]", "");
//        System.out.println(b);

        CodeCesar codeCesar = new CodeCesar('T', b, true);
        String r = codeCesar.encoder();
//        System.out.println(codeCesar);
//        codeCesar = new CodeCesar('F', "Atzx kfnyjx zs YU i’nsktwrfynvzj js hj rtrjsy", false);
//        System.out.println(codeCesar);
//
        CodeVigenere codeVigenere = new CodeVigenere("TPFIG", b, true );
//        System.out.println(codeVigenere);
//        codeVigenere = new CodeVigenere("TPFI", "Odza ypnbxh zv ME i’qgutzfpyqjjj mg rj uhbjvm", false );
//        System.out.println(codeVigenere);

        CassageCode cassageCode = new CassageCode("");
        System.out.println(cassageCode.carreDifference(r));
        cassageCode.indiceCoincidence(r);
        cassageCode.indiceCoincidence(codeVigenere.encoder());
    }
}