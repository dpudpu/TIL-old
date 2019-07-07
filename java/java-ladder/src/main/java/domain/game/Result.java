package domain.game;

import domain.player.Player;
import domain.reward.Reward;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final Map<Player, Reward> result;

    public Result(final Map<Player, Reward> result) {
        this.result = result;
    }

    public Reward get(final String name) {
        Player player = new Player(name);
        return result.get(player);
    }

    public Map<Player, Reward> getAll() {
        return new HashMap<>(result);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
