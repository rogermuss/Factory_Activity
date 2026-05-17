package factorys;

import clases.Guerrero;
import clases.Personaje;

public class FabricaGuerrero implements FabricaPersonajes {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Guerrero(nombre);
    }
}
