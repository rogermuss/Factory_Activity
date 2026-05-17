package armaduras;

import clases.Personaje;

public interface Armadura {
    int getDefensa();
    String getNombre();
    void proteger(Personaje portador, int daño);
}

