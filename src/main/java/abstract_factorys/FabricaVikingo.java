package abstract_factorys;

import armaduras.Armadura;
import armaduras.ArmaduraCueroMetal;
import armas.Arma;
import armas.HachaDosManos;

public class FabricaVikingo implements FabricaEquipamiento {
    private Arma arma = new HachaDosManos();
    private Armadura armadura = new ArmaduraCueroMetal();

    @Override
    public Arma crearArma() { return arma; }

    @Override
    public Armadura crearArmadura() { return armadura; }

    @Override
    public String getTematica() { return "Vikingo"; }

    @Override
    public String getClaseObjetivo() { return "Guerrero"; }

    @Override
    public int getBonus() { return 15; }

    @Override
    public String getBonusDescripcion() {
        return "Conjunto vikingo:" +
                "\n- Arma: " + arma.getNombre() +
                "\n- Armadura: " + armadura.getNombre() +
                "\n- Bonus: +15 Fuerza (solo Guerrero)";
    }
}