package com.example.my_app_java_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;

import com.example.my_app_java_android.category.CategoriesAdapter;
import com.example.my_app_java_android.category.CategoryCreateActivity;
import com.example.my_app_java_android.dto.category.CategoryItemDTO;
import com.example.my_app_java_android.services.ApplicationNetwork;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {

    RecyclerView rcCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        rcCategories = findViewById(R.id.rcCategories);
        rcCategories.setHasFixedSize(true);
        rcCategories.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));

        ApplicationNetwork
                .getInstance()
                .getCategoriesApi()
                .list()
                .enqueue(new Callback<List<CategoryItemDTO>>() {
                    @Override
                    public void onResponse(Call<List<CategoryItemDTO>> call, Response<List<CategoryItemDTO>> response) {
                        if(response.isSuccessful()) {
                            List<CategoryItemDTO> data = response.body();
                            CategoriesAdapter adapter = new CategoriesAdapter(data);
                            rcCategories.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CategoryItemDTO>> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });

    }

    public void onClickGoToCreateCategory(View view) {
        Intent intent = new Intent(CategoriesActivity.this, CategoryCreateActivity.class);
        startActivity(intent);
        finish();
    }
}