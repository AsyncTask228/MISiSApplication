package com.example.misisapplication.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.MainActivity;
import com.example.misisapplication.R;
import com.example.misisapplication.adapters.CategoryAdapter;
import com.example.misisapplication.domain.Category;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    private ArrayList<Category> categories = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView rvCategory = view.findViewById(R.id.rv_category);

        categories.add(new Category(1, "Суп"));
        categories.add(new Category(2, "Салат"));
        categories.add(new Category(3, "Морожка"));
        categories.add(new Category(4, "Мясо"));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), categories);

        rvCategory.setAdapter(categoryAdapter);
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryAdapter.notifyDataSetChanged();

        AppCompatButton salad = view.findViewById(R.id.choose_salad);
        AppCompatButton soup = view.findViewById(R.id.choose_soup);
        AppCompatButton secondFood = view.findViewById(R.id.choose_second);
        AppCompatButton pp = view.findViewById(R.id.choose_pp);
        AppCompatButton post = view.findViewById(R.id.choose_post);
        AppCompatButton bakery = view.findViewById(R.id.choose_bakery);
        AppCompatButton vegan = view.findViewById(R.id.choose_vegan);
        AppCompatButton dessert = view.findViewById(R.id.choose_dessert);
        AppCompatButton veganskoe = view.findViewById(R.id.choose_veganskoe);
        AppCompatButton drink = view.findViewById(R.id.choose_drink);

        AppCompatButton searchButtonMainFragment = view.findViewById(R.id.search_button_main_fragment);

        searchButtonMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //тут будет вызываться метод дающий запросы на сервер

                replaceFragment(new ResultDishFragment());
            }
        });


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatButton button = (AppCompatButton) view;

                Drawable background =
                        button.getBackground();
                if (background.getConstantState().equals(getResources()
                        .getDrawable(R.drawable.custom_btn_v2_orange).getConstantState())) {

                    button.setTextColor(getResources().getColor(R.color.black));
                    button.setBackgroundDrawable(getResources()
                            .getDrawable(R.drawable.custom_choose_button));
                } else {

                    button.setTextColor(getResources().getColor(R.color.white));
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_btn_v2_orange));
                }


            }
        };

        salad.setOnClickListener(listener);
        soup.setOnClickListener(listener);
        secondFood.setOnClickListener(listener);
        pp.setOnClickListener(listener);
        post.setOnClickListener(listener);
        bakery.setOnClickListener(listener);
        vegan.setOnClickListener(listener);
        dessert.setOnClickListener(listener);
        veganskoe.setOnClickListener(listener);
        drink.setOnClickListener(listener);


        return view;
    }

    private void replaceFragment(Fragment fragment){

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.constraint_main_fragment, fragment);
        ft.commit();
    }
}