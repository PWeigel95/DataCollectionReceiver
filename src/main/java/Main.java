import communication.Executor;
import service.DataCollectionReceiverService;
import service.InformationService;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private final static String BROKER_URL = "tcp://localhost:61616";

    public static void main(String[] args) {
        //Message von StationCollector
        DataCollectionReceiverService dataCollectionReceiverService = new DataCollectionReceiverService("DATA COLLECTION DONE", "PDF READY", BROKER_URL);
        //dataCollectionReceiverService.run();

        //Message von Dispatcher
        //DataCollectionReceiverService dataCollectionReceiverService1 = new DataCollectionReceiverService("INVOICE REQUEST STARTED", "DATA GATHERING DONE", BROKER_URL);
        //dataCollectionReceiverService1.run();

        InformationService informationService = new InformationService("INVOICE REQUEST STARTED", "INVOICE REQUEST DONE", BROKER_URL);

        List<Runnable> services = new ArrayList<>();

        services.add(dataCollectionReceiverService);
        services.add(informationService);

        Executor executor = new Executor(services);
        executor.start();

    }
}
