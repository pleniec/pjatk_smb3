package com.pjatk.sm3;

import com.example.leniec.myapplication.backend.productApi.ProductApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Api {
    private static final ProductApi productApi = new ProductApi.Builder(
            AndroidHttp.newCompatibleTransport(),
            new JacksonFactory(),
            null)
            .setRootUrl("http://10.0.2.2:8080/_ah/api/")
            .build();

    private Api() {}

    public static ProductApi getProductApi() {
        return productApi;
    }
}
