public interface Personaje {
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

