package com.pjatk.sm3;

import android.os.AsyncTask;

import com.example.leniec.myapplication.backend.productApi.ProductApi;
import com.example.leniec.myapplication.backend.productApi.model.Product;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

public class DeleteProduct extends AsyncTask<Product, Void, Void> {
    @Override
    protected Void doInBackground(Product... params) {
        try {
            ProductApi api = new ProductApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new JacksonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .build();

            api.remove(params[0].getId()).execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
