package fr.al_cc2.kernel.event;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
