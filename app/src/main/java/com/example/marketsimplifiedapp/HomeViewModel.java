package com.example.marketsimplifiedapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;

class HomeViewModel extends AndroidViewModel{

    Context context;
    DataRepository dataRepository;
    MutableLiveData<ArrayList<RepositoryResponseModel>> reposData;
    LifecycleOwner lifecycleOwner;
    public HomeViewModel(@NonNull Application application,LifecycleOwner lifecycleOwner) {
        super(application);
        context = application.getApplicationContext();
        //dataRepository = new DataRepository(getApplication(),lifecycleOwner);
        this.lifecycleOwner = lifecycleOwner;
    //   getRepoData();
        // dataRepository.getRepoDataResponse();
    }

    void getRepoData() {

        dataRepository.repositoryResponseModelMutableLiveData.observe(lifecycleOwner, new Observer<ArrayList<RepositoryResponseModel>>() {
            @Override
            public void onChanged(ArrayList<RepositoryResponseModel> repositoryResponseModels) {

                Log.e("Data","Size"+repositoryResponseModels.size());
            }
        });

    }

}
