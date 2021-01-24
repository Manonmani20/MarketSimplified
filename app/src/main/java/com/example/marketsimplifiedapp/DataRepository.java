package com.example.marketsimplifiedapp;

import android.app.Application;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

class DataRepository {
    Application application;

    private Gson gSon;
    private RemoteDataSource remote;
    LifecycleOwner lifecycleOwner;
    MutableLiveData<ArrayList<RepositoryResponseModel>> repositoryResponseModelMutableLiveData;
    DataRepository(Application application,LifecycleOwner lifecycleOwner){
        this.application = application;
        repositoryResponseModelMutableLiveData = new MutableLiveData<>();
        remote = new RemoteDataSource();
        this.lifecycleOwner = lifecycleOwner;

    }

//    private fun fromJsonToObject(String data): ErrorModel {
//        try {
//            val eType = object : TypeToken<ErrorModel>() {}.type
//            return gSon.fromJson<ErrorModel>(data, eType)
//        }catch (ex:Exception){
//            ex.printStackTrace()
//        }
//        return ErrorModel()
//    }


    void getRepoDataResponse(){
        remote.listOfRepos().observe(lifecycleOwner, new Observer<ArrayList<RepositoryResponseModel>>() {
            @Override
            public void onChanged(ArrayList<RepositoryResponseModel> repositoryResponseModels) {
                repositoryResponseModelMutableLiveData.setValue(repositoryResponseModels);
            }
        });
    }
}
