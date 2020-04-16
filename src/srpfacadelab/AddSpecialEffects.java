package srpfacadelab;

public class AddSpecialEffects {

    public static void greenSwirlyEffect(IGameEngine gameEngine)
    {
        gameEngine.playSpecialEffect("green_swirly");
    }

    public static void reactIfUniqueAndOrRare(IGameEngine gameEngine, Item item)
    {
        if (item.isRare() && item.isUnique())
        {
            gameEngine.playSpecialEffect("blue_swirly");
//            System.out.println("blue swirly");
        }
        else if (item.isRare()) {
            gameEngine.playSpecialEffect("cool_swirly_particles");
//            System.out.println("cool swirly particles");
        }
    }

    public static void blockedDamageEffect(IGameEngine gameEngine){
        gameEngine.playSpecialEffect("parry");
    }

    public static void DamageEffect(IGameEngine gameEngine)
    {
        gameEngine.playSpecialEffect("lots_of_gore");
    }

}
