package org.example;

import org.example.aws.AWSResourceFactory;
import org.example.gcp.GoogleResourceFactory;

public class App 
{
    private final ResourceFactory resourceFactory;
    public App(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }
    public Instance createServer(Instance.Capacity capacity, int storageMib) {
        Instance instance = resourceFactory.createInstance(capacity);
        Storage storage = resourceFactory.createStorage(storageMib);
        instance.attachStorage(storage);
        return instance;
    }
    public static void main( String[] args )
    {
        App aws = new App(new AWSResourceFactory());
        Instance i1 = aws.createServer(Instance.Capacity.micro, 20480);
        i1.start();
        i1.stop();

        System.out.println("****************************************************");
        App gcp = new App(new GoogleResourceFactory());
        i1 = gcp.createServer(Instance.Capacity.micro, 20480);
        i1.start();
        i1.stop();
    }
}
