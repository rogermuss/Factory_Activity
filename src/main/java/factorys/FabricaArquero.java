package factorys;

import clases.Arquero;
import clases.Personaje;

public class FabricaArquero implements FabricaPersonajes {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Arquero(nombre);
    }
}
