package domain.player;

import java.util.Objects;

public class Player {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validateLength(name);
        validateEmpty(name);
        this.name = Objects.requireNonNull(name);
    }

    private void validateEmpty(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("공백 이름 입력 불가능");
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("PlayerNmae 은 " + MAX_LENGTH + "글자 이하야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
