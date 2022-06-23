import service.DataCollectionReceiverService;

public class Main {

    private final static String BROKER_URL = "tcp://localhost:61616";

    public static void main(String[] args) {
        DataCollectionReceiverService dataCollectionReceiverService = new DataCollectionReceiverService("DATA COLLECTION DONE", "PDF READY", BROKER_URL);
        dataCollectionReceiverService.run();

        DataCollectionReceiverService dataCollectionReceiverService1 = new DataCollectionReceiverService("Data gathering job started!", "DATA GATHERING DONE", BROKER_URL);
        dataCollectionReceiverService1.run();
    }
}
