package website.sdfp.textadventure.library;

import io.vavr.control.Option;
import org.immutables.value.Value;

@Value.Immutable
public interface AbstractGameState<T>
{
    String prompt();
    Option<T> gameData();

}

