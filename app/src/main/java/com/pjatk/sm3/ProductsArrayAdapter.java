package com.pjatk.sm3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.leniec.myapplication.backend.productApi.model.Product;

import java.util.List;

public class ProductsArrayAdapter extends ArrayAdapter<Product> {
    public ProductsArrayAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) getContext()).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.product, parent, false);
        }

        final EditText productQuantity = (EditText)convertView.findViewById(R.id.productQuantity);
        final EditText productName = (EditText)convertView.findViewById(R.id.productName);
        Button updateProduct = (Button)convertView.findViewById(R.id.updateProduct);
        Button destroyProduct = (Button)convertView.findViewById(R.id.destroyProduct);
        final CheckBox boughtCheckbox = (CheckBox)convertView.findViewById(R.id.boughtCheckbox);

        final Product product = getItem(position);

        productQuantity.setText(product.getQuantity().toString());
        productName.setText(product.getName());
        boughtCheckbox.setChecked(product.getBought());

        updateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setQuantity(Integer.parseInt(productQuantity.getText().toString()));
                product.setBought(boughtCheckbox.isChecked());
                product.setName(productName.getText().toString());

                System.out.println("###");
                System.out.println(boughtCheckbox.isChecked());
                System.out.println("###");

                new UpdateProductTask(ProductsArrayAdapter.this).execute(product);
            }
        });


        destroyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteProductTask(ProductsArrayAdapter.this).execute(product);
            }
        });

        return convertView;
    }

    public void reload() {
        new GetProductsTask(this).execute();
    }
}