package com.pjatk.sm3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends ListActivity {
    private ProductsArrayAdapter productsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        productsArrayAdapter = new ProductsArrayAdapter(
                this,
                R.layout.product,
                new ArrayList<Product>());
        setListAdapter(productsArrayAdapter);

        productsArrayAdapter.reload();
    }

    public void createProduct(View view) {
        EditText productQuantity = (EditText)findViewById(R.id.newProductQuantity);
        EditText productName = (EditText)findViewById(R.id.newProductName);

        try {
            Product product = new Product();
            product.setQuantity(Integer.parseInt(productQuantity.getText().toString()));
            product.setName(productName.getText().toString());
            product.setBought(false);

            new CreateProductTask(productsArrayAdapter).execute(product);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        productQuantity = (EditText)findViewById(R.id.productQuantity);
        productName = (EditText)findViewById(R.id.productName);

        productsDataSource = new ProductsDataSource(this);

        List<Product> products = productsDataSource.all();

        productsArrayAdapter = new ProductsArrayAdapter(this,
                R.layout.product, products);
        setListAdapter(productsArrayAdapter);
    }

    public void createProduct(View view) {
        Product product = new Product(null,
                Integer.parseInt(productQuantity.getText().toString()),
                productName.getText().toString(),
                0);

        productsDataSource.create(product);

        productsArrayAdapter.add(product);
    }
}
*/