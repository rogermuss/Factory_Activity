package factorys;

import clases.Mago;
import clases.Personaje;

public class FabricaMago implements FabricaPersonajes {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Mago(nombre);
    }
}
