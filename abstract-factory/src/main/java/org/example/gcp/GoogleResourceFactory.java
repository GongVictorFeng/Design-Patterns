package org.example.gcp;

import org.example.Instance;
import org.example.ResourceFactory;
import org.example.Storage;

//Factory Implementation for Google Cloud Platform Resources
public class GoogleResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
