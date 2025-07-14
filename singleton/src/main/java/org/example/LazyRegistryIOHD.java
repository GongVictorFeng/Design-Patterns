package org.example;

public class LazyRegistryIOHD {

    private LazyRegistryIOHD() {
        System.out.println("In LazyRegistryIODH singleton");
    }

    private static class RegistryHolder {
        private static final LazyRegistryIOHD INSTANCE = new LazyRegistryIOHD();
    }

    public static LazyRegistryIOHD getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
