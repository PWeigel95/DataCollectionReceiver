import service.DataCollectionReceiverService;

public class Main {

    private final static String BROKER_URL = "tcp://localhost:61616";

    public static void main(String[] args) {
        DataCollectionReceiverService dataCollectionReceiverService = new DataCollectionReceiverService("DATA COLLECTION DONE", "PDF READY", BROKER_URL);
        dataCollectionReceiverService.run();
    }
}
