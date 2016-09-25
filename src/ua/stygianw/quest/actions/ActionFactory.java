package ua.stygianw.quest.actions;

/**
 * Created by User on 25.09.2016.
 */
public interface ActionFactory {

    PlayerAction makeFightAction();
    PlayerAction makeItemAction();
    PlayerAction makeCellAction();

}
