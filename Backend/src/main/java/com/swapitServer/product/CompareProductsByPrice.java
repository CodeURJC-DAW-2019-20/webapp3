package com.swapitServer.product;

import java.util.Comparator;

public class CompareProductsByPrice implements Comparator<Product> {

    @Override
    public int compare(Product product, Product productAux) {
        int resultado = 0;
        if (product.getPrice() < productAux.getPrice()){
            resultado = -1;
        } else if (product.getPrice() > productAux.getPrice()) {
            resultado = 1;
        }
        return resultado;
    }
}
