package factorys;

import clases.Personaje;

public interface FabricaPersonajes {
    Personaje crearPersonaje(String nombre);
}