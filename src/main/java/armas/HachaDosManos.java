package armas;

import clases.Personaje;

public class HachaDosManos implements Arma {
    public static final String nombre = "Hacha de Dos Manos";
    private int daño = 45;

    @Override
    public int getDaño() { return daño; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public void usar(Personaje portador, Personaje objetivo) {
        System.out.println("  [" + portador.getNombre() + " blande el " + nombre + "]");
    }
}