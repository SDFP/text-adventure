package website.sdfp.textadventure.library;

import io.vavr.Tuple;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static website.sdfp.textadventure.library.InputUtils.getInput;

public class GameLoop {

    public static <T> void run(T data, String prompt, BiFunction<T, String, GameState<T>> gameLogic) {
        innerRun(data, prompt, gameLogic)
                .collect(Collectors.toList());
    }

    static <T> Stream<GameState<T>> innerRun(T data, String prompt, BiFunction<T, String, GameState<T>> gameLogic)
    {
        return Stream.of(data)
                .map(d -> Tuple.of(d, getInput(prompt)))
                .flatMap(t -> {
                    GameState<T> result = t.apply(gameLogic);
                    return result
                            .gameData()
                            .map(newGameData -> innerRun(newGameData, result.prompt(), gameLogic))
                            .getOrElse(() -> {
                                System.out.println("Done: " + result.prompt());
                                return Stream.empty();
                            });
                });
    }
}
