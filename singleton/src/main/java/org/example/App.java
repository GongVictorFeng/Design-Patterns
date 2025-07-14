package org.example;

public class App 
{
    public static void main( String[] args )
    {
        EagerRegistry registry1 = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();
        System.out.println(registry1 == registry2);

        System.out.println("******************************************************");
        LazyRegistryWithDLC lazyRegistry1 = LazyRegistryWithDLC.getInstance();
        LazyRegistryWithDLC lazyRegistry2 = LazyRegistryWithDLC.getInstance();
        System.out.println(lazyRegistry1 == lazyRegistry2);

        System.out.println("******************************************************");
        LazyRegistryIOHD lazyRegistryIOHD1 = LazyRegistryIOHD.getInstance();
        LazyRegistryIOHD lazyRegistryIOHD2 = LazyRegistryIOHD.getInstance();
        System.out.println(lazyRegistryIOHD1 == lazyRegistryIOHD2);
    }
}
