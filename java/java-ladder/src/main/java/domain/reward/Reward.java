package domain.reward;

import java.util.Objects;

public class Reward {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Reward(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Reward 이름은" + MAX_LENGTH + "글자 이하야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Reward that = (Reward) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
