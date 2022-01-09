package fr.al_cc2.kernel.query;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}