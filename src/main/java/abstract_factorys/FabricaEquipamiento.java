package abstract_factorys;

import armaduras.Armadura;
import armas.Arma;

public interface FabricaEquipamiento {
    Arma crearArma();
    Armadura crearArmadura();
    String getTematica();
    String getBonusDescripcion();
    int getBonus();
}
