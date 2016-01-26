package com.pjatk.sm3;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.io.IOException;

public class CreateProductTask extends Task {
    public CreateProductTask(ProductsArrayAdapter productsArrayAdapter) {
        super(productsArrayAdapter);
    }

    @Override
    protected Void doInBackground(Product... params) {
        try {
            getProductApi().insert(params[0]).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
