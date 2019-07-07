package domain.game;

import domain.player.Player;
import domain.reward.Reward;

import java.util.HashMap;
import java.util.Map;

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
}
