package com.pedro.backendencurtadordeurl.services.utils;

import java.util.Random;

public class HashUrl {
    
    private static String possibildades = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String create() {
        String hash = "";
        for(int i = 0; i < 5; i++) {
            Random gerador = new Random();
            int valorSort = gerador.nextInt(possibildades.length());
            hash += possibildades.charAt(valorSort);
        }
        return hash;
    }
}
