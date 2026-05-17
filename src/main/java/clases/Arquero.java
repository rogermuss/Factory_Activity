package clases;

import armaduras.Armadura;
import armas.Arma;

import java.util.Random;

public class Arquero implements Personaje {
    public static final String clase = "clases.Arquero";
    private String nombre;
    private int nivel;
    private int vida;
    private int ataque;
    private int punteria;

    public Arquero(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.vida = 100;
        this.ataque = 12;
        this.punteria = punteriaRandom();
    }

    public int punteriaRandom(){
        Random r = new Random();
        return r.nextInt(21) + 70;
    }

    @Override
    public Arma setArma(Arma arma) {
        return arma;
    }

    @Override
    public Armadura setArmadura(Armadura armadura) {
        return armadura;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void recibirDaño(int daño) {
        vida = vida - daño;
    }

    @Override
    public void atacar(Personaje objetivo) {
        objetivo.recibirDaño(ataque);
    }

    @Override
    public void subirNivel() {
        nivel++;
    }

    @Override
    public String getClasePersonaje() {
        return "clases.Arquero";
    }

    public void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    public int getPunteria() {
        return punteria;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Clase: " + clase);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Punteria: " + punteria);
        System.out.println("--------------------------------");
    }
}
