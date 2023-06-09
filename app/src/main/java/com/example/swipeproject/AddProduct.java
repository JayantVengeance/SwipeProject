package com.example.swipeproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    EditText product_name, product_type, price, tax, image1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        product_name=findViewById(R.id.PN);
        product_type=findViewById(R.id.PT);
        price=findViewById(R.id.price);
        tax=findViewById(R.id.TAX);
        image1=findViewById(R.id.image);

        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(product_name.getText().toString().length()==0||product_type.getText().toString().length()==0||image1.getText().toString().length()==0||tax.getText().toString().length()==0||price.getText().toString().length()==0)
                {
                    Toast.makeText(AddProduct.this, "One or more fields are empty", Toast.LENGTH_LONG).show();
                }
                else
                postData(product_name.getText().toString(), product_type.getText().toString(), price.getText().toString(),tax.getText().toString(), image1.getText().toString() );
            }
        });
    }

    private void postData(String product_name1, String product_type1, String price1, String tax1, String image11)
    {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://app.getswipe.in/api/public/").addConverterFactory(GsonConverterFactory.create()).build();
        RetroFitInterface retroFitInterface=retrofit.create(RetroFitInterface.class);
        DataModal modal=new DataModal(product_name1, product_type1, price1, tax1, image11 );
        Call<DataModal> call=retroFitInterface.createPost(modal);

        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                Toast.makeText(AddProduct.this, "Data added to API", Toast.LENGTH_SHORT).show();
                product_name.setText("");
                price.setText("");
                product_type.setText("");
                tax.setText("");
                image1.setText("");
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {

                Toast.makeText(AddProduct.this, "Error is "+t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}