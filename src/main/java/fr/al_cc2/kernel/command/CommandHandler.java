package fr.al_cc2.kernel.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
