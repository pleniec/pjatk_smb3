package com.pjatk.sm3;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.io.IOException;

public class DeleteProductTask extends Task {
    public DeleteProductTask(ProductsArrayAdapter productsArrayAdapter) {
        super(productsArrayAdapter);
    }

    @Override
    protected Void doInBackground(Product... params) {
        try {
            getProductApi().remove(params[0].getId()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
