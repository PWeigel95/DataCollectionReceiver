package service;

import java.util.UUID;

public class InformationService extends BaseService{

    private final String id;

    public InformationService(String inDestination, String outDestination, String brokerUrl) {
        super(inDestination, outDestination, brokerUrl);

        this.id = UUID.randomUUID().toString();

        System.out.println("Information Worker (" + this.id + ") started...");
    }

    @Override
    protected String executeInternal(String input) {
        return "ok";
    }
}
