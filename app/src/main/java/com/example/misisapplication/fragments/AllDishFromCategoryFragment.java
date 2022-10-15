package com.example.misisapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.misisapplication.R;
import com.example.misisapplication.adapters.AllDishFromCategoryAdapter;
import com.example.misisapplication.domain.Dish;

import java.util.ArrayList;
import java.util.List;


public class AllDishFromCategoryFragment extends Fragment {

    private List<Dish> dishList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_all_dish_from_category, container, false);

        RecyclerView recyclerView =view.findViewById(R.id.rv_all_dish_from_category);

        AllDishFromCategoryAdapter allDishFromCategoryAdapter = new AllDishFromCategoryAdapter(view.getContext(), dishList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(allDishFromCategoryAdapter);

        return view;
    }
}