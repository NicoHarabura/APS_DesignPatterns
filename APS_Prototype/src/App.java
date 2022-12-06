import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();
        List<Forma> formasCopia = new ArrayList<>();

        Circulo circulo = new Circulo();
        circulo.x = 10;
        circulo.y = 20;
        circulo.raio = 15;
        circulo.cor = "vermelho";
        formas.add(circulo);

        Circulo outroCirculo = (Circulo) circulo.clone();
        formas.add(outroCirculo);

        Retangulo retangulo = new Retangulo();
        retangulo.largura = 10;
        retangulo.altura = 20;
        retangulo.cor = "azul";
        formas.add(retangulo);

        adicionarCompararClones(formas, formasCopia);
    }

    private static void adicionarCompararClones(List<Forma> formas, List<Forma> formasCopia) {
        for (Forma forma : formas) {
            formasCopia.add(forma.clone());
        }

        for (int i = 0; i < formas.size(); i++) {
            if (formas.get(i) != formasCopia.get(i)) {
                System.out.println(i + ": As formas são objetos distintos -> Original " + formas.get(i).getClass() + " e Copia " + formasCopia.get(i).getClass());
                if (formas.get(i).equals(formasCopia.get(i))) {
                    System.out.println(i + ": E eles são identicos -> Original " + formas.get(i).cor + " e Copia " +formas.get(i).cor);
                } else {
                    System.out.println(i + ": Mas eles não são identicos -> Original " + formas.get(i).cor + " e Copia " +formas.get(i).cor);
                }
            } else {
                System.out.println(i + ": As formas comparadoas são os mesmos objetos");
            }
        }
    }
}