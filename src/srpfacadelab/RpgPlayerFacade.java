package srpfacadelab;

import java.util.List;

public class RpgPlayerFacade {


    public static void useItem(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public static boolean pickUpItem(RpgPlayer player, Item item) {

        int weight = player.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && player.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                AddSpecialEffects.greenSwirlyEffect(player.getGameEngine());
            }

            return true;
        }

        AddSpecialEffects.reactIfUniqueAndOrRare(player.getGameEngine(), item);

        player.addToInventory(item);

        player.calculateStats();

        return true;
    }

    public static void takeDamage(RpgPlayer player, int damage) {
        if (damage < player.getArmour()) {
            AddSpecialEffects.blockedDamageEffect(player.getGameEngine());
        }

        HandleDamageTaken.reduceHealthCorrectly(player, damage);

        AddSpecialEffects.DamageEffect(player.getGameEngine());
    }
}
