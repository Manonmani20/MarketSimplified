package com.example.marketsimplifiedapp;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

interface AccountApiService {
    @GET("repositories")
    Call<ArrayList<RepositoryResponseModel>> getRepo();
}