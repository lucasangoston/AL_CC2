package fr.al_cc2.kernel.event;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}

