public class Circulo extends Forma {
    public int raio;

    public Circulo() {
    }

    public Circulo(Circulo alvo) {
        super(alvo);
        if (alvo != null) {
            this.raio = alvo.raio;
        }
    }

    @Override
    public Forma clone() {
        return new Circulo(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circulo) || !super.equals(object2)) return false;
        Circulo forma2 = (Circulo) object2;
        return forma2.raio == raio;
    }
}