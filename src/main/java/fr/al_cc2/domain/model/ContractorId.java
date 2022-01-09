package fr.al_cc2.domain.model;

import fr.al_cc2.kernel.ValueObjectID;

import java.util.Objects;

public final class ContractorId implements ValueObjectID {
    private final int value;

    public ContractorId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorId contractorId = (ContractorId) o;
        return value == contractorId.value;
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
