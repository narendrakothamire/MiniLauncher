package com.softwares.swamisamarth.minlauncher.viewmodels;

import android.databinding.Bindable;
import android.util.Log;

import com.softwares.swamisamarth.minlauncher.base.ItemViewModel;


/**
 * Created by C145557 on 9/3/2016.
 */
public class MainItemViewModel extends ItemViewModel<Character> {

    private Character model;
    private int position;
    private OnItemClickListener onItemClickListener;

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void setItem(Character model) {
        this.model = model;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Bindable
    public String getAlphabateChar() {
        return model+"";

    }

    public void clickHandler(){
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(position);
        }

    }
}
