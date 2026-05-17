package abstract_factorys;

import armaduras.Armadura;
import armaduras.ArmaduraEscamasDragon;
import armas.Arma;
import armas.EspadaFuegoInfernal;

public class FabricaDemoniaco implements FabricaEquipamiento {
    private Arma arma = new EspadaFuegoInfernal();
    private Armadura armadura = new ArmaduraEscamasDragon();

    @Override
    public Arma crearArma() { return arma; }

    @Override
    public Armadura crearArmadura() { return armadura; }

    @Override
    public String getTematica() { return "Demoniaco"; }

    @Override
    public String getClaseObjetivo() { return "Mago"; }

    @Override
    public int getBonus() { return 25; }

    @Override
    public String getBonusDescripcion() {
        return "Conjunto demoníaco:" +
                "\n- Arma: " + arma.getNombre() +
                "\n- Armadura: " + armadura.getNombre() +
                "\n- Bonus: +25 Daño mágico (solo Mago)";
    }
}