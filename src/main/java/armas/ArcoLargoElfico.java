package armas;

import clases.Personaje;

public class ArcoLargoElfico implements Arma {
    public static final String nombre = "Arco Largo Elfico";
    private int daño = 35;
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
