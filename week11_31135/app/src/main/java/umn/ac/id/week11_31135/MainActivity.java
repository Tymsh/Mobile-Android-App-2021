package umn.ac.id.week11_31135;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView rvPostList;
    postAdapter adapter;

    ArrayList<retrofitModel> posts;

    netInterface netInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPostList = findViewById(R.id.rvPostList);
        rvPostList.setLayoutManager(new LinearLayoutManager(this));

        netInterface = configRetrofit.getClient().create(netInterface.class);

        Call<ArrayList<retrofitModel>> postModelCall = netInterface.getPosts();

        // Asynchronously load data.
        dataCall.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<ArrayList<Data>> call, @NonNull Response<ArrayList<Data>> response) {
                progressBar.setVisibility(View.GONE);
                progressText.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                if (response.isSuccessful()) {
                    ArrayList<Data> data = response.body();
                    recyclerView.setAdapter(new DataAdapter(data));
                    Snackbar.make(mainLayout, getString(R.string.sukses), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(mainLayout, getString(R.string.fail), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<ArrayList<Data>> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                progressText.setVisibility(View.GONE);

                Snackbar.make(mainLayout, getString(R.string.error), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}