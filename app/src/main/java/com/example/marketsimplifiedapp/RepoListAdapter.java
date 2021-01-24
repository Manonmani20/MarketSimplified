package com.example.marketsimplifiedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marketsimplifiedapp.databinding.InnerlayRepolistBinding;

import java.util.ArrayList;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoListHolder>  {

    ArrayList<RepositoryResponseModel> repositoryResponseModels;
    OnItemClickListener onItemClickListener;
    Context context;
    public RepoListAdapter(Context context, ArrayList<RepositoryResponseModel> repositoryResponseModels){
        this.repositoryResponseModels = repositoryResponseModels;
    }

    @NonNull
    @Override
    public RepoListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        InnerlayRepolistBinding repolistBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.innerlay_repolist,parent,false);
        return new  RepoListHolder(repolistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoListHolder holder, int position) {

        Glide.with(context)
                    .load(repositoryResponseModels.get(position).getOwner().getAvatarUrl())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(holder.repolistBinding.ownerImage);
        holder.repolistBinding.name.setText(repositoryResponseModels.get(position).getName());
        holder.repolistBinding.description.setText(repositoryResponseModels.get(position).getDescription());
        holder.repolistBinding.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClicked(holder.getAdapterPosition(),repositoryResponseModels.get(position));
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return repositoryResponseModels.size();
    }

    public class RepoListHolder extends RecyclerView.ViewHolder{
        InnerlayRepolistBinding repolistBinding;
        public RepoListHolder(@NonNull InnerlayRepolistBinding repolistBinding) {
            super(repolistBinding.getRoot());
            this.repolistBinding = repolistBinding;
        }
    }

}
