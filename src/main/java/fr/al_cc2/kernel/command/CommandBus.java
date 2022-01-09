package fr.al_cc2.kernel.command;

public interface CommandBus {
    <C extends Command, R> R send(C command);
}
