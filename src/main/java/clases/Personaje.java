package clases;

import armaduras.Armadura;
import armas.Arma;

public interface Personaje {
    Arma setArma(Arma arma);
    Armadura setArmadura(Armadura armadura);
    String getNombre();
    int getNivel();
    int getVida();
    void recibirDaño(int daño);
    void atacar(Personaje objetivo);
    void subirNivel();
    String getClasePersonaje();
    void mostrarInfo();
}

// Fábrica abstracta

