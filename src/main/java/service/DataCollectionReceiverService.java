package service;

import communication.Producer;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

        //sort the data to the according job
        List<String> listOfKwh = new ArrayList<>();
        listOfKwh.add(input);


        System.out.println(listOfKwh);

        for (String element: listOfKwh){
            totalKwh += Integer.parseInt(element);
        }

        System.out.println("Total KWH:" + totalKwh);

        //TODO: check if all data has been collected

        return String.valueOf(totalKwh);
    }

}

