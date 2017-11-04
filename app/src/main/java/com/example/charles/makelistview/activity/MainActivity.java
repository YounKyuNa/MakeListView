package com.example.charles.makelistview.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.charles.makelistview.Interface.ApiInterface;
import com.example.charles.makelistview.R;
import com.example.charles.makelistview.adapter.HorizontalAdapter;
import com.example.charles.makelistview.adapter.VerticalAdapter;
import com.example.charles.makelistview.helper.GridSpacingItemDecoration;
import com.example.charles.makelistview.helper.NetworkCheckingClass;
import com.example.charles.makelistview.model.Datum;
import com.example.charles.makelistview.model.JsonData;
import com.example.charles.makelistview.model.Popular;
import com.example.charles.makelistview.retrofit.RetrofitApiClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerViewVertical;

    HorizontalAdapter horizontalAdapter;
    VerticalAdapter verticalAdapter;

    List<Popular> popularList;
    List<Datum> dataList;

    ProgressBar progressBar;

    RelativeLayout relativeLayout;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.activity_main);

        recyclerViewHorizontal = findViewById(R.id.horizontal_recycler_view);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));

        recyclerViewVertical = findViewById(R.id.vertical_recycler_view);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));

        progressBar = findViewById(R.id.progress_bar);

        popularList = Collections.emptyList();
        dataList = Collections.emptyList();

        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        if (NetworkCheckingClass.isNetworkAvailable(this)) {
            progressBar.setVisibility(View.VISIBLE);
            fetchData();
        } else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }

    }

    private void fetchData() {

        Call<JsonData> call = apiInterface.apiCall();
        call.enqueue(new Callback<JsonData>() {
            @Override
            public void onResponse(Call<JsonData> call, Response<JsonData> response) {
                JsonData jsonData = response.body();

                if (jsonData != null) {
                    popularList = jsonData.getPopular();
                    dataList = jsonData.getData();

                    int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);

                    //for spacing after every item
                    if (popularList.size() > 0)
                        recyclerViewHorizontal.addItemDecoration(new GridSpacingItemDecoration(popularList.size(), spacingInPixels, true, 0));

                    progressBar.setVisibility(View.GONE);

                    relativeLayout.setBackgroundColor(Color.parseColor("#3481c1"));


                    horizontalAdapter = new HorizontalAdapter(MainActivity.this, popularList);
                    recyclerViewHorizontal.setAdapter(horizontalAdapter);
                    verticalAdapter = new VerticalAdapter(MainActivity.this, dataList);
                    recyclerViewVertical.setAdapter(verticalAdapter);

                }
            }

            @Override
            public void onFailure(Call<JsonData> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
