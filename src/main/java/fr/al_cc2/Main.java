package fr.al_cc2;

import fr.al_cc2.application.tradesman.create.CreateTradesman;
import fr.al_cc2.application.tradesman.create.CreateTradesmanCommandHandler;
import fr.al_cc2.application.tradesman.retrieve.RetrieveTradesmans;
import fr.al_cc2.application.tradesman.retrieve.RetrieveTradesmansHandler;
import fr.al_cc2.domain.model.Certificates;
import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.model.TradesmanId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        CreateTradesmanCommandHandler tradesmanCommandHandler = applicationContext.getBean(CreateTradesmanCommandHandler.class);
        CreateTradesman createTradesman = new CreateTradesman("lucas", "angoston", "lucas_angoston@yahoo.fr", "lulu77176", "un truc", "un skill", "geo", "un daily", "banking", new Certificates("menuiserie", "29/09/1988"));
        final TradesmanId tradesmanId = tradesmanCommandHandler.handle(createTradesman);

        //--2. Modify User Address
        /*ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new AddressResponse("ALFORTVILLE"))); */

        //--3. Retrieve all users
        RetrieveTradesmans retrieveTradesmans = new RetrieveTradesmans();
        RetrieveTradesmansHandler retrieveTradesmansHandler = applicationContext.getBean(RetrieveTradesmansHandler.class);
        final List<Tradesman> tradesmen = retrieveTradesmansHandler.handle(retrieveTradesmans);
        tradesmen.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city

    }

}
