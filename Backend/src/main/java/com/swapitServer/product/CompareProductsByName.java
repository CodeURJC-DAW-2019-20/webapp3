package com.swapitServer.product;

import java.util.Comparator;

public class CompareProductsByName implements Comparator<Product> {

    @Override
    public int compare(Product product, Product productAux) {
        int resultado = 0;
        if (product.getName().compareTo(productAux.getName()) < 0){
            resultado = -1;
        } else if (product.getName().compareTo(productAux.getName()) > 0 ){
            resultado = 1;
        }
        return resultado;
    }
}