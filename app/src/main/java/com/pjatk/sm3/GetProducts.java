package com.pjatk.sm3;

import android.os.AsyncTask;

import com.example.leniec.myapplication.backend.productApi.ProductApi;
import com.example.leniec.myapplication.backend.productApi.model.Product;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.List;

public class GetProducts extends AsyncTask<Void, Void, Void> {
    private ProductsArrayAdapter productsArrayAdapter;
    private List<Product> items;

    public GetProducts(ProductsArrayAdapter productsArrayAdapter) {
        this.productsArrayAdapter = productsArrayAdapter;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            ProductApi api = new ProductApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new JacksonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .build();

            items = api.list().execute().getItems();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        productsArrayAdapter.clear();
        productsArrayAdapter.addAll(items);
    }
}
