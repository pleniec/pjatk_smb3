package com.pjatk.sm3;

import android.os.AsyncTask;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.io.IOException;
import java.util.List;

public class GetProductsTask extends Task {
    private List<Product> items;

    public GetProductsTask(ProductsArrayAdapter productsArrayAdapter) {
        super(productsArrayAdapter);
    }

    @Override
    protected Void doInBackground(Product... params) {
        try {
            items = getProductApi().list().execute().getItems();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(items != null) {
            productsArrayAdapter.clear();
            productsArrayAdapter.addAll(items);
        }
    }
}