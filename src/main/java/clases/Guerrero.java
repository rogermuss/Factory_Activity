package clases;

import armaduras.Armadura;
import armas.Arma;

import java.util.Random;

public class Guerrero implements Personaje {
    public static final String clase = "Guerrero";
    private String nombre;
    private int nivel;
    private int vida;
    private int ataque;
    private int fuerza;
    private Arma arma;
    private Armadura armadura;

    public Guerrero(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.vida = 100;
        this.ataque = 20;
        this.fuerza = fuerzaRandom();
    }

    public int fuerzaRandom() {
        Random r = new Random();
        return r.nextInt(6) + 15;
    }

    @Override
    public Arma setArma(Arma arma) {
        this.arma = arma;
        return arma;
    }

    @Override
    public Armadura setArmadura(Armadura armadura) {
        this.armadura = armadura;
        return armadura;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public int getNivel() { return nivel; }

    @Override
    public int getVida() { return vida; }

    @Override
    public void aplicarDaño(int daño) {
        vida -= daño;
    }

    @Override
    public void recibirDaño(int daño) {
        if (armadura != null) {
            armadura.proteger(this, daño);
        } else {
            aplicarDaño(daño);
        }
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (arma != null) {
            arma.usar(this, objetivo);
            objetivo.recibirDaño(arma.getDaño() + fuerza);
        } else {
            objetivo.recibirDaño(ataque);
        }
    }

    @Override
    public void subirNivel() { nivel++; }

    @Override
    public String getClasePersonaje() { return clase; }

    public void setFuerza(int fuerza) { this.fuerza = fuerza; }

    public int getFuerza() { return fuerza; }

    @Override
    public void mostrarInfo() {
        System.out.println("Clase: " + clase);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque base: " + ataque);
        System.out.println("Fuerza: " + fuerza);
        if (arma != null)
            System.out.println("Arma: " + arma.getNombre() + " (Daño: " + arma.getDaño() + ")");
        if (armadura != null)
            System.out.println("Armadura: " + armadura.getNombre() + " (Defensa: " + armadura.getDefensa() + ")");
        System.out.println("--------------------------------");
    }
}