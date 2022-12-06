import java.util.Objects;

public abstract class Forma {
    public int x;
    public int y;
    public String cor;

    public Forma() {
    }

    public Forma(Forma alvo) {
        if (alvo != null) {
            this.x = alvo.x;
            this.y = alvo.y;
            this.cor = alvo.cor;
        }
    }

    public abstract Forma clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Forma)) return false;
        Forma forma2 = (Forma) object2;
        return forma2.x == x && forma2.y == y && Objects.equals(forma2.cor, cor);
    }
}