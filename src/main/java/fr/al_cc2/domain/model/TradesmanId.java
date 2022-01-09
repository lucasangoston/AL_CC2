package fr.al_cc2.domain.model;

import fr.al_cc2.kernel.ValueObjectID;

import java.util.Objects;

public class TradesmanId  implements ValueObjectID {
    private final int value;

    public TradesmanId(int value) {
        this.value = value;
    }

    public int getValue() {
            return value;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanId tradesmanId = (TradesmanId) o;
        return value == tradesmanId.value;
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() {
        return "TradesmanId{" +
                "value='" + value + '\'' +
                '}';
    }
}
