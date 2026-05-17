package armas;

import clases.Personaje;

public class EspadaFuegoInfernal implements Arma {
    public static final String nombre = "Espada de Fuego Infernal";
    private int daño = 55;
    @Override
    public int getDaño() {
        return daño;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void usar(Personaje portador, Personaje objetivo) {

    }
}
