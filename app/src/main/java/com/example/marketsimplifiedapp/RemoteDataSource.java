package com.example.marketsimplifiedapp;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class RemoteDataSource {
    public static AccountApiService accountApiService= NetworkManager.getInstance().getAccountApi();


    RemoteDataSource(){
        getInstance();
    }
    AccountApiService getInstance(){
        if (accountApiService == null){
            accountApiService= NetworkManager.getInstance().getAccountApi();
        }
        return accountApiService;

    }

    MutableLiveData<ArrayList<RepositoryResponseModel>> repoResponse=new MutableLiveData<>();
    MutableLiveData<ArrayList<RepositoryResponseModel>> listOfRepos(){

        Call<ArrayList<RepositoryResponseModel>> call= accountApiService
                .getRepo();
        call.enqueue(new Callback<ArrayList<RepositoryResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<RepositoryResponseModel>> call, Response<ArrayList<RepositoryResponseModel>> response) {

                ArrayList<RepositoryResponseModel> repoList = response.body();
                repoResponse.setValue(repoList);

            }

            @Override
            public void onFailure(Call<ArrayList<RepositoryResponseModel>> call, Throwable t) {
                call.cancel();
            }
        });


        return repoResponse;
    }

}
