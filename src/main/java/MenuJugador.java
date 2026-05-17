import clases.Personaje;
import factorys.FabricaArquero;
import factorys.FabricaGuerrero;
import factorys.FabricaMago;
import factorys.FabricaPersonajes;

import java.util.Scanner;

public class MenuJugador {
    public static void main(String[] args){
        boolean salir = false;
        int opcion;
        Personaje personaje;
        do {
            limpiarConsola();
            System.out.println("Menu principal");
            System.out.println("1. Crear personaje");
            System.out.println("2. Salir");
            Scanner entrada = new Scanner(System.in);
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    int opcionPersonaje;
                    String nombre;
                    limpiarConsola();
                    System.out.println("Crear personaje");
                    System.out.println("1. clases.Guerrero");
                    System.out.println("2. clases.Arquero");
                    System.out.println("3. clases.Mago");
                    opcionPersonaje = entrada.nextInt();
                    FabricaPersonajes fabrica = null;
                    entrada.nextLine();
                    System.out.println("Ingrese nombre del personaje");
                    nombre = entrada.nextLine();
                    switch(opcionPersonaje){
                        case 1:
                            fabrica = new FabricaGuerrero();
                            personaje = fabrica.crearPersonaje(nombre);
                            personaje.mostrarInfo();
                            break;
                            case 2:
                            fabrica = new FabricaArquero();
                            personaje = fabrica.crearPersonaje(nombre);
                            personaje.mostrarInfo();
                            break;
                            case 3:
                            fabrica = new FabricaMago();
                            personaje = fabrica.crearPersonaje(nombre);
                            personaje.mostrarInfo();
                            break;
                            default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion!=2) {
                System.out.println("Presione cualquier tecla para continuar...");
                entrada.nextLine();
            }
        }while (!salir);
    }

    public static void limpiarConsola() {
        for(int i=0;i<500;i++){
            System.out.println();
        }
    }
}