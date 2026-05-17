package abstract_factorys;

import armaduras.Armadura;
import armaduras.TunicaHojasArbol;
import armas.ArcoLargoElfico;
import armas.Arma;

public class FabricaElfico implements FabricaEquipamiento {
    private Arma arma = new ArcoLargoElfico();
    private Armadura armadura = new TunicaHojasArbol();

    @Override
    public Arma crearArma() { return arma; }

    @Override
    public Armadura crearArmadura() { return armadura; }

    @Override
    public String getTematica() { return "Elfico"; }

    @Override
    public String getClaseObjetivo() { return "Arquero"; }

    @Override
    public int getBonus() { return 20; }

    @Override
    public String getBonusDescripcion() {
        return "Conjunto élfico:" +
                "\n- Arma: " + arma.getNombre() +
                "\n- Armadura: " + armadura.getNombre() +
                "\n- Bonus: +20 Puntería (solo Arquero)";
    }
}