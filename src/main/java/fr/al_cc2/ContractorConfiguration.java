package fr.al_cc2;

import fr.al_cc2.application.contractor.create.CreateContractor;
import fr.al_cc2.application.contractor.create.CreateContractorCommandHandler;
import fr.al_cc2.application.contractor.create.CreateContractorEvent;
import fr.al_cc2.application.contractor.create.CreateContractorEventListener;
import fr.al_cc2.application.contractor.retrieve.RetrieveContractors;
import fr.al_cc2.application.contractor.retrieve.RetrieveContractorsHandler;
import fr.al_cc2.application.contractor.retrieve.service.RetrieveContractorsByServiceHandler;
import fr.al_cc2.application.contractor.update.UpdateContractorService;
import fr.al_cc2.application.contractor.update.UpdateContractorServiceCommandHandler;
import fr.al_cc2.application.contractor.update.UpdateContractorServiceEvent;
import fr.al_cc2.application.contractor.update.UpdateContractorServiceEventListener;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.infrastructure.DefaultEventDispatcher;
import fr.al_cc2.infrastructure.InMemoryContractorRepository;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ContractorConfiguration {
    @Bean
    public ContractorRepository contractorRepository() {
        return new InMemoryContractorRepository();
    }

    @Bean
    public EventDispatcher<Event> contractorEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(UpdateContractorServiceEvent.class, List.of(new UpdateContractorServiceEventListener()));
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateContractorCommandHandler createContractorCommandHandler() {
        return new CreateContractorCommandHandler(contractorRepository(), contractorEventDispatcher());
    }

    @Bean
    public UpdateContractorServiceCommandHandler updateContractorServiceCommandHandler() {
        return new UpdateContractorServiceCommandHandler(contractorRepository(), contractorEventDispatcher());
    }

    @Bean
    public CommandBus contractorCommandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateContractor.class, new CreateContractorCommandHandler(contractorRepository(), contractorEventDispatcher()));
        commandHandlerMap.put(UpdateContractorService.class, new UpdateContractorServiceCommandHandler(contractorRepository(), contractorEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus contractorQueryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveContractors.class, new RetrieveContractorsHandler(contractorRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveContractorsHandler retrieveContractorsHandler() {
        return new RetrieveContractorsHandler(contractorRepository());
    }

    @Bean
    public RetrieveContractorsByServiceHandler retrieveContractorsByServiceHandler() {
        return new RetrieveContractorsByServiceHandler(contractorRepository());
    }
}
