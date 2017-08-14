package website.sdfp.textadventure;

import website.sdfp.textadventure.library.GameLoop;
import website.sdfp.textadventure.library.GameState;

import static website.sdfp.textadventure.library.GameStateUtils.end;
import static website.sdfp.textadventure.library.GameStateUtils.next;

class Game {
    static class GameData {
    }


    static GameState logic(GameData currentData, String userInput) {
        switch(userInput) {
            case "":
                return next("You just hit enter...what do you want?", currentData);
        }

        return end("That's not a valid option");
    }

    public static void main(String[] args) throws Exception {
        GameData gameData = new GameData();
        GameLoop.run(gameData, "Hi!", Game::logic);
    }
}
