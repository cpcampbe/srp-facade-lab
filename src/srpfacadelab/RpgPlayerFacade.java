package srpfacadelab;

import java.util.List;

public class RpgPlayerFacade {


    public static void useItem(RpgPlayer player, Item item) {
        HandleItems.useItemNow(player, item);
//        if (item.getName().equals("Stink Bomb"))
//        {
//            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);
//
//            for (IEnemy enemy: enemies){
//                enemy.takeDamage(100);
//            }
//        }
    }

    public static boolean pickUpItem(RpgPlayer player, Item item) {

//        int weight = Inventory.calculateInventoryWeight(player);
        if (HandleItems.isTooHeavy(player, item))
            return false;

        if (HandleItems.noMoreUniques(player, item))
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

        Inventory.calculateStats(player);

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
