package website.sdfp.textadventure.library;

import io.vavr.control.Option;

public class GameStateUtils {

    public static <T> GameState<T> end(String prompt) {
        return GameState.<T>builder().prompt(prompt).build();
    }
    public static <T> GameState<T> next(String nextPrompt, T gameData){
        return GameState.<T>builder().prompt(nextPrompt).gameData(Option.of(gameData)).build();
    }
}
