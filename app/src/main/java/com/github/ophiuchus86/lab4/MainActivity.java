package com.github.ophiuchus86.lab4;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ophiuchus86.lab4.backend.BackEndAPI;
import com.github.ophiuchus86.lab4.models.University;
import com.github.ophiuchus86.lab4.views.UniversityAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView universitiesRecView;
    private UniversityAdapter universityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://universities.hipolabs.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        BackEndAPI backEndAPI = retrofit.create(BackEndAPI.class);

        backEndAPI.getBritainUniversities().enqueue(new Callback<List<University>>() {
            @Override
            public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                if(!response.isSuccessful()){
                    Log.e("MainActivity", "Code:" + response.code());
                    return;
                }
                List<University> universities = response.body();

                setupUniversitiesRecView(universities);
            }

            @Override
            public void onFailure(Call<List<University>> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }

    public void setupUniversitiesRecView(List<University> universities) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        universityAdapter = new UniversityAdapter(universities);

        universitiesRecView = findViewById(R.id.universities);
        universitiesRecView.setLayoutManager(linearLayoutManager);
        universitiesRecView.setAdapter(universityAdapter);
    }
}