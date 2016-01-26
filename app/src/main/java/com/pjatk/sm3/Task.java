package com.pjatk.sm3;


import android.os.AsyncTask;

import com.example.leniec.myapplication.backend.productApi.ProductApi;
import com.example.leniec.myapplication.backend.productApi.model.Product;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

public abstract class Task extends AsyncTask<Product, Void, Void> {
    protected final ProductsArrayAdapter productsArrayAdapter;

    public Task(ProductsArrayAdapter productsArrayAdapter) {
        this.productsArrayAdapter = productsArrayAdapter;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        productsArrayAdapter.reload();
    }

    protected ProductApi getProductApi() {
        return new ProductApi.Builder(
                AndroidHttp.newCompatibleTransport(),
                new JacksonFactory(),
                null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .build();
    }
}
