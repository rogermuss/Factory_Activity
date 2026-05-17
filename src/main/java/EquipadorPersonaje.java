import abstract_factorys.FabricaEquipamiento;
import armas.Arma;
import armaduras.Armadura;
import clases.Arquero;
import clases.Guerrero;
import clases.Mago;
import clases.Personaje;

public class EquipadorPersonaje {

    private Personaje personaje;
    private Arma arma;
    private Armadura armadura;

    public EquipadorPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void equipar(FabricaEquipamiento fabrica) {
        arma = fabrica.crearArma();
        armadura = fabrica.crearArmadura();

        personaje.setArma(arma);
        personaje.setArmadura(armadura);

        System.out.println("\n--- EQUIPAMIENTO OBTENIDO ---");
        System.out.println("Arma: " + arma.getNombre() + " (Daño: " + arma.getDaño() + ")");
        System.out.println("Armadura: " + armadura.getNombre() + " (Defensa: " + armadura.getDefensa() + ")");

        aplicarBonus(fabrica);

        System.out.println("\n--- PERSONAJE EQUIPADO ---");
        personaje.mostrarInfo();
    }

    private void aplicarBonus(FabricaEquipamiento fabrica) {
        String clasePersonaje = personaje.getClasePersonaje();
        String claseObjetivo  = fabrica.getClaseObjetivo();

        if (!clasePersonaje.equals(claseObjetivo)) {
            System.out.println("\nAvisos: el conjunto " + fabrica.getTematica()
                    + " está diseñado para " + claseObjetivo
                    + ". Tu clase (" + clasePersonaje + ") no recibe el bonus de estadística.");
            return;
        }

        int bonus = fabrica.getBonus();

        if (personaje instanceof Guerrero) {
            Guerrero g = (Guerrero) personaje;
            System.out.println("\nBonus aplicado: Fuerza +" + bonus
                    + " (" + g.getFuerza() + " → " + (g.getFuerza() + bonus) + ")");
            g.setFuerza(g.getFuerza() + bonus);

        } else if (personaje instanceof Arquero) {
            Arquero a = (Arquero) personaje;
            System.out.println("\nBonus aplicado: Puntería +" + bonus
                    + " (" + a.getPunteria() + " → " + (a.getPunteria() + bonus) + ")");
            a.setPunteria(a.getPunteria() + bonus);

        } else if (personaje instanceof Mago) {
            Mago m = (Mago) personaje;
            System.out.println("\nBonus aplicado: Mana +" + bonus
                    + " (" + m.getMana() + " → " + (m.getMana() + bonus) + ")");
            m.setMana(m.getMana() + bonus);
        }
    }
}