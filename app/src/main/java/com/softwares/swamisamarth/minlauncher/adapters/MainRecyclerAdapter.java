package com.softwares.swamisamarth.minlauncher.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.softwares.swamisamarth.minlauncher.BR;
import com.softwares.swamisamarth.minlauncher.R;
import com.softwares.swamisamarth.minlauncher.base.RecyclerViewAdapter;
import com.softwares.swamisamarth.minlauncher.viewmodels.MainItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by C145557 on 9/3/2016.
 */
public class MainRecyclerAdapter extends RecyclerViewAdapter<Character, MainRecyclerAdapter.MainItemViewHolder> {

    private static final ArrayList<Character> alphaitems = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '));
    public MainRecyclerAdapter(ArrayList<Character> items) {
        super(alphaitems);
    }

    @Override
    public MainItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding mainListItemBinding = null;

        mainListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.main_list_item, parent, false);

        MainItemViewHolder mainItemViewHolder = new MainItemViewHolder(mainListItemBinding, new MainItemViewModel());

        mainItemViewHolder.setOnItemClickListener(onItemClickListener);

        return mainItemViewHolder;
    }


    static class MainItemViewHolder extends RecyclerViewAdapter.ItemViewHolder<Character, MainItemViewModel>{

        public MainItemViewHolder(ViewDataBinding dataBinding, MainItemViewModel viewModel) {
            super(dataBinding, viewModel);
        }

        @Override
        public void setViewModel() {
            dataBinding.setVariable(BR.viewmodel, viewModel);
            dataBinding.executePendingBindings();
        }
    }

}
