package srpfacadelab;

import java.util.List;

public class HandleItems {

    public static void useItemNow(RpgPlayer p, Item i) {
        if (i.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = p.getGameEngine().getEnemiesNear(p);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public static boolean isTooHeavy(RpgPlayer p, Item i) {
        int weight = Inventory.calculateInventoryWeight(p);
        if (weight + i.getWeight() > p.getCarryingCapacity())
            return true;
        return false;
    }

    public static boolean noMoreUniques(RpgPlayer p, Item i) {
        if (i.isUnique() && Inventory.checkIfItemExistsInInventory(p, i))
            return true;
        return false;
    }
}
