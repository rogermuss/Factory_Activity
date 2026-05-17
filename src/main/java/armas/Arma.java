package armas;

import clases.Personaje;

public interface Arma {
    int getDaño();
    String getNombre();
    void usar(Personaje portador, Personaje objetivo);
}
