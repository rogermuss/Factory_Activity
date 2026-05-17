package armaduras;

import clases.Personaje;

public class ArmaduraCueroMetal implements Armadura {
    public static final String nombre = "Armadura de Cuero y Metal";
    private int defensa = 30;
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
