package service;

import java.util.UUID;

public class DataCollectionReceiverService extends BaseService {

    private final String id;


    private int totalKwh = 0;
    private int count = 0;

    public DataCollectionReceiverService(String inDestination, String outDestination, String brokerUrl) {
        super(inDestination, outDestination, brokerUrl);

        this.id = UUID.randomUUID().toString();

        System.out.println("Data Collection Receiver Worker (" + this.id + ") started...");
    }

    @Override
    protected String executeInternal(String input) {

        String output = "";

        String[] inputList = input.split(":");

        int kwh = Integer.parseInt(inputList[0]);
        int amountOfStations = Integer.parseInt(inputList[1]);

        System.out.println("KWH:" + kwh);

        totalKwh += kwh;
        count++;

        System.out.println("Count:" + count);

        if(count < amountOfStations){
            return null;
        }
        else
        {
            output = String.valueOf(totalKwh);
            totalKwh = 0;
            count = 0;
            System.out.println("Endstand: " + output);
            return output;

        }

    }



}

