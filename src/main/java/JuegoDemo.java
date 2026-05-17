import abstract_factorys.FabricaDemoniaco;
import abstract_factorys.FabricaElfico;
import abstract_factorys.FabricaEquipamiento;
import abstract_factorys.FabricaVikingo;
import clases.Personaje;
import factorys.FabricaArquero;
import factorys.FabricaGuerrero;
import factorys.FabricaMago;
import factorys.FabricaPersonajes;

import java.util.Scanner;

public class JuegoDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== CREADOR DE PERSONAJES ===\n");
        System.out.println("Selecciona tu clase:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Opción: ");
        int opcionClase = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Ingresa el nombre de tu personaje: ");
        String nombre = entrada.nextLine();

        FabricaPersonajes fabricaPersonaje;
        switch (opcionClase) {
            case 2:  fabricaPersonaje = new FabricaMago();    break;
            case 3:  fabricaPersonaje = new FabricaArquero(); break;
            default: fabricaPersonaje = new FabricaGuerrero(); break;
        }

        Personaje jugador = fabricaPersonaje.crearPersonaje(nombre);
        System.out.println("\n--- Personaje CREADO ---");
        jugador.mostrarInfo();

        System.out.println("Selecciona tu estilo de equipamiento:");
        System.out.println("1. Vikingo   (+15 Fuerza)");
        System.out.println("2. Élfico    (+20 Puntería)");
        System.out.println("3. Demoníaco (+25 Daño mágico)");
        System.out.print("Opción: ");
        int opcionEquipo = entrada.nextInt();

        FabricaEquipamiento fabricaEquipo;
        switch (opcionEquipo) {
            case 2:  fabricaEquipo = new FabricaElfico();    break;
            case 3:  fabricaEquipo = new FabricaDemoniaco(); break;
            default: fabricaEquipo = new FabricaVikingo();   break;
        }

        EquipadorPersonaje equipador = new EquipadorPersonaje(jugador);
        equipador.equipar(fabricaEquipo);

        System.out.println("\n¡COMBATE DE PRUEBA!");
        System.out.println("Se acerca un enemigo...\n");

        Personaje enemigo = crearEnemigo(opcionClase);

        simularCombate(jugador, enemigo);

        entrada.close();
    }

    private static Personaje crearEnemigo(int claseJugador) {
        Personaje enemigo;
        FabricaEquipamiento equipoEnemigo;

        switch (claseJugador) {
            case 1:
                enemigo = new FabricaMago().crearPersonaje("Zaran el Mago");
                equipoEnemigo = new FabricaDemoniaco();
                break;
            case 2:
                enemigo = new FabricaArquero().crearPersonaje("Kael el Arquero");
                equipoEnemigo = new FabricaElfico();
                break;
            default:
                enemigo = new FabricaGuerrero().crearPersonaje("Borr el Guerrero");
                equipoEnemigo = new FabricaVikingo();
                break;
        }

        enemigo.setArma(equipoEnemigo.crearArma());
        enemigo.setArmadura(equipoEnemigo.crearArmadura());

        return enemigo;
    }

    private static void simularCombate(Personaje jugador, Personaje enemigo) {
        System.out.println(jugador.getNombre() + " (Vida: " + jugador.getVida() + ")"
                + " VS " + enemigo.getNombre() + " (Vida: " + enemigo.getVida() + ")");
        System.out.println("─────────────────────────────────");

        int turno = 1;
        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
            System.out.println("Turno " + turno + ":");

            // Jugador ataca
            int vidaAntesEnemigo = enemigo.getVida();
            jugador.atacar(enemigo);
            int danioHecho = vidaAntesEnemigo - enemigo.getVida();
            System.out.println("  " + jugador.getNombre()
                    + " ataca a " + enemigo.getNombre()
                    + " causando " + danioHecho + " de daño."
                    + " (Vida enemigo: " + Math.max(enemigo.getVida(), 0) + ")");

            if (enemigo.getVida() <= 0) break;

            // Enemigo ataca
            int vidaAntesJugador = jugador.getVida();
            enemigo.atacar(jugador);
            int danioRecibido = vidaAntesJugador - jugador.getVida();
            System.out.println("  " + enemigo.getNombre()
                    + " contraataca causando " + danioRecibido + " de daño."
                    + " (Tu vida: " + Math.max(jugador.getVida(), 0) + ")");

            turno++;
        }

        System.out.println("─────────────────────────────────");
        if (jugador.getVida() > 0) {
            System.out.println("¡" + jugador.getNombre() + " ha ganado el combate!");
        } else {
            System.out.println(enemigo.getNombre() + " ha derrotado a " + jugador.getNombre() + ".");
        }
    }
}