package domain.player;

import java.util.Objects;

public class Player implements Comparable<Player>{
    private final Position position;
    private final PlayerName name;

    public Player(final int position, final String name) {
        this.position = Position.from(position);
        this.name = new PlayerName(name);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(final Player o) {
        return this.position.compareTo(o.position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
