package domain.player;

import domain.ladder.Position;

import java.util.HashMap;
import java.util.Map;

public class Players {
    private final Map<Position, Player> players;

    public Players(final String playerNames) {
        players = new HashMap<>();
        //TODO Refactor
        int index = 0;
        for (final String name : playerNames.split(",")) {
            final Position position = Position.from(index++);
            final Player player = new Player(name.trim());
            players.put(position, player);
        }
    }

    public int size() {
        return players.size();
    }

    public Player get(final Position position) {
        return players.get(position);
    }
}
