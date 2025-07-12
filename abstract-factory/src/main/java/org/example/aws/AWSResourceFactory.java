package org.example.aws;

import org.example.Instance;
import org.example.ResourceFactory;
import org.example.Storage;

//Factory implementation for AWS resources
public class AWSResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
