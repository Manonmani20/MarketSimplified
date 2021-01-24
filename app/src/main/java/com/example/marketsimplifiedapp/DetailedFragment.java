package com.example.marketsimplifiedapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.marketsimplifiedapp.databinding.DetailedFragmentBinding;

public class DetailedFragment extends Fragment {

    RepositoryResponseModel repositoryResponseModel;
DetailedFragmentBinding detailedFragmentBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        detailedFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.detailed_fragment, container, false);


        repositoryResponseModel = (RepositoryResponseModel) getArguments().getSerializable("repo");

        detailedFragmentBinding.name.setText(repositoryResponseModel.getName());
        detailedFragmentBinding.fullName.setText(repositoryResponseModel.getFullName());
        detailedFragmentBinding.description.setText(repositoryResponseModel.getDescription());

        Glide.with(getActivity())
                .load(repositoryResponseModel.getOwner().getAvatarUrl())
                .centerCrop()
                .into(detailedFragmentBinding.repoImage);
        return detailedFragmentBinding.getRoot();
    }
}
