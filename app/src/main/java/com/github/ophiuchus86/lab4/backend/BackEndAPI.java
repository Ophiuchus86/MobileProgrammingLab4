package com.github.ophiuchus86.lab4.backend;

import com.github.ophiuchus86.lab4.models.University;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BackEndAPI {
    @GET("search?country=United%20Kingdom")
    Call<List<University>> getBritainUniversities();

    @GET("search?country=Ukraine")
    Call<List<University>> getUkraineUniversities();
}
