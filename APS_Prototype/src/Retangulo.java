public class Retangulo extends Forma {
    public int largura;
    public int altura;

    public Retangulo() {
    }

    public Retangulo(Retangulo alvo) {
        super(alvo);
        if (alvo != null) {
            this.largura = alvo.largura;
            this.altura = alvo.altura;
        }
    }

    @Override
    public Forma clone() {
        return new Retangulo(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Retangulo) || !super.equals(object2)) return false;
        Retangulo forma2 = (Retangulo) object2;
        return forma2.largura == largura && forma2.altura == altura;
    }
}