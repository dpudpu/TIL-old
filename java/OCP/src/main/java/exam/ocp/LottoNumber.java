package exam.ocp;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int MAX = 45;
    static final int MIN = 1;

    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber lottoNo = (LottoNumber) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
