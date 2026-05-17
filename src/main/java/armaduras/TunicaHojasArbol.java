package armaduras;

import clases.Personaje;

public class TunicaHojasArbol implements Armadura {
    public static final String nombre = "Tunica de Hojas de Arbol";
    private int defensa = 20;
    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void proteger(Personaje portador, int daño) {

    }
}
