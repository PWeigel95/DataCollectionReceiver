package service;

import java.util.UUID;

public class DataCollectionReceiverService extends BaseService {

    private final String id;


    private int totalKwh = 0;

    public DataCollectionReceiverService(String inDestination, String outDestination, String brokerUrl) {
        super(inDestination, outDestination, brokerUrl);

        this.id = UUID.randomUUID().toString();

        System.out.println("Data Collection Receiver Worker (" + this.id + ") started...");
    }

    @Override
    protected String executeInternal(String input) {

        String[] inputList = input.split(":");

        int kwh = Integer.parseInt(inputList[0]);

        System.out.println(kwh);

        totalKwh += kwh;

        System.out.println("Endstand: " + totalKwh);
        return String.valueOf(totalKwh);
    }



}

