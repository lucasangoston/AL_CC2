package fr.al_cc2;

import fr.al_cc2.application.tradesman.create.CreateTradesman;
import fr.al_cc2.application.tradesman.create.CreateTradesmanCommandHandler;
import fr.al_cc2.application.tradesman.create.CreateTradesmanEvent;
import fr.al_cc2.application.tradesman.create.CreateTradesmanEventListener;
import fr.al_cc2.application.tradesman.retrieve.RetrieveTradesmans;
import fr.al_cc2.application.tradesman.retrieve.RetrieveTradesmansHandler;
import fr.al_cc2.application.tradesman.retrieve.qualification.RetrieveTradesmansByQualificationHandler;
import fr.al_cc2.application.tradesman.update.UpdateTradesmanQualification;
import fr.al_cc2.application.tradesman.update.UpdateTradesmanQualificationCommandHandler;
import fr.al_cc2.application.tradesman.update.UpdateTrandesmanQualificationEvent;
import fr.al_cc2.application.tradesman.update.UpdateTrandesmanQualificationEventListener;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.infrastructure.DefaultEventDispatcher;
import fr.al_cc2.infrastructure.InMemoryTradesmanRepository;
import fr.al_cc2.kernel.command.Command;
import fr.al_cc2.kernel.command.CommandBus;
import fr.al_cc2.kernel.command.CommandHandler;
import fr.al_cc2.kernel.command.SimpleCommandBus;
import fr.al_cc2.kernel.event.Event;
import fr.al_cc2.kernel.event.EventDispatcher;
import fr.al_cc2.kernel.event.EventListener;
import fr.al_cc2.kernel.query.Query;
import fr.al_cc2.kernel.query.QueryBus;
import fr.al_cc2.kernel.query.QueryHandler;
import fr.al_cc2.kernel.query.SimpleQueryBus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class TradesmanConfiguration {
    @Bean
    public TradesmanRepository tradesmanRepository() {
        return new InMemoryTradesmanRepository();
    }

    @Bean
    public EventDispatcher<Event> tradesmanEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(UpdateTrandesmanQualificationEvent.class, List.of(new UpdateTrandesmanQualificationEventListener()));
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateTradesmanCommandHandler createTradesmanCommandHandler() {
        return new CreateTradesmanCommandHandler(tradesmanRepository(), tradesmanEventDispatcher());
    }

    @Bean
    public UpdateTradesmanQualificationCommandHandler updateTradesmanQualificationCommandHandler() {
        return new UpdateTradesmanQualificationCommandHandler(tradesmanRepository(), tradesmanEventDispatcher());
    }

    @Qualifier
    public CommandBus tradesmanCommandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateTradesman.class, new CreateTradesmanCommandHandler(tradesmanRepository(), tradesmanEventDispatcher()));
        commandHandlerMap.put(UpdateTradesmanQualification.class, new UpdateTradesmanQualificationCommandHandler(tradesmanRepository(), tradesmanEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Qualifier
    public QueryBus tradesmanQueryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveTradesmans.class, new RetrieveTradesmansHandler(tradesmanRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveTradesmansHandler retrieveTradesmansHandler() { return new RetrieveTradesmansHandler(tradesmanRepository()); }

    @Bean
    public RetrieveTradesmansByQualificationHandler retrieveTradesmansByQualificationHandler() {
        return new RetrieveTradesmansByQualificationHandler(tradesmanRepository());
    }
}
