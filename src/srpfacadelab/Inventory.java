package srpfacadelab;

public class Inventory {

    public static void calculateStats(RpgPlayer p) {
        for (Item i: p.getInventory()) {
            p.setArmour(p.getArmour() + i.getArmour());
        }
    }

    public static boolean checkIfItemExistsInInventory(RpgPlayer p, Item item) {
        for (Item i: p.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public static int calculateInventoryWeight(RpgPlayer p) {
        int sum=0;
        for (Item i: p.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }
}
