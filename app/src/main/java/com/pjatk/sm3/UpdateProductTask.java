package com.pjatk.sm3;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.io.IOException;

public class UpdateProductTask extends Task {
    public UpdateProductTask(ProductsArrayAdapter productsArrayAdapter) {
        super(productsArrayAdapter);
    }

    @Override
    protected Void doInBackground(Product... params) {
        try {
            getProductApi().update(params[0].getId(), params[0]).execute();
        }
        catch(IOException e) {

        }

        return null;
    }
}
