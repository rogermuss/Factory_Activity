package clases;

import armaduras.Armadura;
import armas.Arma;

public interface Personaje {
    Arma setArma(Arma arma);
    Armadura setArmadura(Armadura armadura);
    String getNombre();
    int getNivel();
    int getVida();
    void aplicarDaño(int daño);   // resta vida directo, sin pasar por armadura
    void recibirDaño(int daño);   // entrada pública, consulta armadura primero
    void atacar(Personaje objetivo);
    void subirNivel();
    String getClasePersonaje();
    void mostrarInfo();
}