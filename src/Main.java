import srpfacadelab.*;

public class Main {

    public static void main(String[] args) {
        //This is meant to be simple and just show how you could instantiate the structure

        IGameEngine game = new SimpleGameEngine();
        RpgPlayer player1 = new RpgPlayer(game);
        RpgPlayer player2 = new RpgPlayer(game);
        ((SimpleGameEngine) game).addPlayer(player1);
        ((SimpleGameEngine) game).addPlayer(player2);

        //Here you would create items
        Item i1 = new Item(1, "Shield", 0, 6, 5, false, false);
        Item i2 = new Item(2, "Diamond", 0, 0, 1, true, true);
        Item i3 = new Item(3, "Stink Bomb", 0, 0, 1, false, false);
        Item i4 = new Item(4, "Steel", 0, 3, 4, false, true);

        //Here you would tell the history and make the game happen
        RpgPlayerFacade.pickUpItem(player1, i1);
        RpgPlayerFacade.pickUpItem(player1, i2);
        RpgPlayerFacade.pickUpItem(player1, i3);
        RpgPlayerFacade.pickUpItem(player1, i4);

        //You could make players pick up items
        //You could make players use items
        //etc.
        //You don't need to worry about it for the assignment
        //This is only to show how the 'external world' would instantiate the structure.
        //In the assignment, you're supposed to improve the design and not instantiate a game
    }
}
