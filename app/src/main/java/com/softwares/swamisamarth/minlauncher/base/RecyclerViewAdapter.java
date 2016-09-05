package com.softwares.swamisamarth.minlauncher.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C145557 on 9/2/2016.
 */
public abstract class RecyclerViewAdapter<M, VH extends RecyclerViewAdapter.ItemViewHolder> extends RecyclerView.Adapter<VH> {

    ArrayList<M> items;
    protected ItemViewModel.OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(ArrayList<M> items) {
        this.items = items;
    }

    public void setOnItemClickListener(ItemViewModel.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    @CallSuper
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setPosition(position);
        holder.setItem(items.get(position));

    }

    @Override
    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        holder.setPosition(position);
        holder.setItem(items.get(position));
        holder.setViewModel();
    }

    public abstract static class ItemViewHolder<M, VM extends ItemViewModel<M>> extends RecyclerView.ViewHolder{

        protected final ViewDataBinding dataBinding;
        protected final VM viewModel;

        public ItemViewHolder(ViewDataBinding dataBinding, VM viewModel) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
            this.viewModel = viewModel;

        }

        public void setOnItemClickListener(ItemViewModel.OnItemClickListener onItemClickListener){
            viewModel.setOnItemClickListener(onItemClickListener);
        }

        public void setItem(M model){
            viewModel.setItem(model);
        }

        public abstract void setViewModel();

        public void setPosition(int position){
            viewModel.setPosition(position);
        }

    }

}
