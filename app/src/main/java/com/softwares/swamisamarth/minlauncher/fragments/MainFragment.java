package com.softwares.swamisamarth.minlauncher.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwares.swamisamarth.minlauncher.R;
import com.softwares.swamisamarth.minlauncher.adapters.MainRecyclerAdapter;
import com.softwares.swamisamarth.minlauncher.base.ItemViewModel;
import com.softwares.swamisamarth.minlauncher.databinding.FragmentMainBinding;
import com.softwares.swamisamarth.minlauncher.models.User;
import com.softwares.swamisamarth.minlauncher.widgets.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private MainRecyclerAdapter adapter;
    private ItemViewModel.OnItemClickListener onItemClickListener = new ItemViewModel.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            Toast.makeText(getActivity(), "Clicked at"+position, Toast.LENGTH_LONG).show();
        }
    };

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
      //  ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("Narendra"),new User("Sachin")));
        adapter = new MainRecyclerAdapter(null);

        binding.fragmentMainRv.setAdapter(adapter);
       // binding.fragmentMainRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),5);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
//                if(position == adapter.getItemCount()-2){
//                    return 2;
//                }else if(position > adapter.getItemCount()-2){
//                    return 3;
//                }else {
                    return 1;
//                }

            }
        });

        binding.fragmentMainRv.addItemDecoration(new GridSpacingItemDecoration(5, 20, true));
        binding.fragmentMainRv.setLayoutManager(layoutManager);
        adapter.setOnItemClickListener(onItemClickListener);
        return binding.getRoot();
    }

}
