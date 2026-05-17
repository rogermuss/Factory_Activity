package armaduras;

import clases.Personaje;

public class ArmaduraEscamasDragon implements Armadura {
    public static final String nombre = "Armadura de Escamas de Dragon";
    private int defensa = 40;
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
