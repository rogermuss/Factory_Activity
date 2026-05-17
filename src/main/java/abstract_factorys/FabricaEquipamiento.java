package abstract_factorys;

import armaduras.Armadura;
import armas.Arma;

public interface FabricaEquipamiento {
    String getClaseObjetivo();
    Arma crearArma();
    Armadura crearArmadura();
    String getTematica();
    String getBonusDescripcion();
    int getBonus();
}
