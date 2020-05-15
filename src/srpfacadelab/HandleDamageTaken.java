package srpfacadelab;

public class HandleDamageTaken {

    public static void reduceHealthCorrectly(RpgPlayer player, int damage)
    {
        int damageToDeal;
        if (Inventory.calculateInventoryWeight(player) < (player.getCarryingCapacity())*(0.5))
        {
            damageToDeal = (int)(0.75*(damage - player.getArmour()));
        }
        else
        {
            damageToDeal = damage - player.getArmour();
        }
        player.setHealth(player.getHealth() - damageToDeal);
    }
}
