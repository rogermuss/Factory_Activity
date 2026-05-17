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

    public EquipadorPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void equipar(FabricaEquipamiento fabrica){

        arma = fabrica.crearArma();

        armadura = fabrica.crearArmadura();

        int bonus = fabrica.getBonus();

        // Si agregaste setArma y setArmadura:
        // personaje.setArma(arma);
        // personaje.setArmadura(armadura);

        System.out.println("\n--- EQUIPAMIENTO OBTENIDO ---");

        System.out.println(
                "Arma: "
                        + arma.getNombre()
                        + " (Daño: "
                        + arma.getDaño()
                        + ")");

        System.out.println(
                "Armadura: "
                        + armadura.getNombre()
                        + " (Defensa: "
                        + armadura.getDefensa()
                        + ")");

        aplicarBonus(bonus);

        System.out.println("\n--- PERSONAJE EQUIPADO ---");

        personaje.mostrarInfo();
    }

    private void aplicarBonus(int bonus){

        if(personaje instanceof Guerrero){

            Guerrero g =
                    (Guerrero) personaje;

            g.setFuerza(
                    g.getFuerza()
                            + bonus);

        }

        else if(
                personaje instanceof Arquero){

            Arquero a =
                    (Arquero) personaje;

            a.setPunteria(
                    a.getPunteria()
                            + bonus);

        }

        else if(
                personaje instanceof Mago){

            Mago m =
                    (Mago) personaje;

            m.setMana(
                    m.getMana()
                            + bonus);

        }

    }
}