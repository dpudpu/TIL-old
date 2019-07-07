package domain.ladder;

public class Height {
    static final int MIN_RANGE = 1;

    private final int height;

    public Height(final int height) {
        validateRange(height);
        this.height = height;
    }

    public int value() {
        return height;
    }

    private void validateRange(final int height) {
        if (height < MIN_RANGE) {
            throw new IllegalArgumentException("높이는" + MIN_RANGE + "이상 입력");
        }
    }
}
