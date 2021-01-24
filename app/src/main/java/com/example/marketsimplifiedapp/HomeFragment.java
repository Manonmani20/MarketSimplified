package com.example.marketsimplifiedapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.marketsimplifiedapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements OnItemClickListener {

    HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    DataRepository dataRepository;
    FragmentHomeBinding homeBinding;
    RepoListAdapter repoListAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         homeBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_home, container, false);
        homeViewModel = new HomeViewModel(getActivity().getApplication(),getViewLifecycleOwner());

       // binding.setHomeViewmodel(homeViewModel);
        dataRepository = new DataRepository(getActivity().getApplication(),getViewLifecycleOwner());

        getRepoData();
        dataRepository.getRepoDataResponse();
        return homeBinding.getRoot();
    }



    void getRepoData() {
        dataRepository.repositoryResponseModelMutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<RepositoryResponseModel>>() {
            @Override
            public void onChanged(ArrayList<RepositoryResponseModel> repositoryResponseModels) {
                setRepoList(repositoryResponseModels);
                Log.e("Data***","Size"+repositoryResponseModels.size());
            }
        });
    }

    public void setRepoList(ArrayList<RepositoryResponseModel> repositoryResponseModels){
        if (repositoryResponseModels.size()>0) {
            homeBinding.repoList.setLayoutManager(new LinearLayoutManager(getActivity()));
            repoListAdapter = new RepoListAdapter(getActivity(), repositoryResponseModels);
            homeBinding.repoList.setAdapter(repoListAdapter);
            repoListAdapter.setOnItemClickListener(this);
            homeBinding.repoList.addItemDecoration(new VerticalSpaceItemDecoration(30));

        }
    }

    @Override
    public void onItemClicked(int position,RepositoryResponseModel repositoryResponseModel) {
        DetailedFragment detailedFragment = new DetailedFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("repo",repositoryResponseModel);
        detailedFragment.setArguments(bundle);
        (( MainActivity)getActivity()).setFragments(detailedFragment,"detail");
    }
}
