package com.example.marketsimplifiedapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.marketsimplifiedapp.databinding.FragmentEmptyBinding;

public class EmptyFragment extends Fragment {


    public static EmptyFragment newInstance(String title){
        EmptyFragment emptyFragment = new EmptyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        emptyFragment.setArguments(bundle);
        return emptyFragment;
    }

    FragmentEmptyBinding fragmentEmptyBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentEmptyBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_empty, container, false);
        fragmentEmptyBinding.title.setText(getArguments().getString("title"));
        return fragmentEmptyBinding.getRoot();
    }

    }
