package com.example.misisapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.R;
import com.example.misisapplication.domain.Category;
import com.example.misisapplication.domain.Dish;
import com.example.misisapplication.domain.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Category> categories;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.inflater = LayoutInflater.from(context);
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_main_rv_itrem, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {



        holder.category_name.setText(categories.get(position).getName());

        List<Dish> dishes = new ArrayList<>();
        Dish dish = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish1 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish2 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish3 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish4 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish5 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        Dish dish6 = new Dish(1, "капуста", Collections.emptyList(), new Image(1, "https://www.chefmarket.ru/blog/wp-content/uploads/2020/12/u3c4687-2-1.jpg"));
        dishes.add(dish);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);
        dishes.add(dish6);

        DishesRecyclerAdapter dishesRecyclerAdapter;
        dishesRecyclerAdapter = new DishesRecyclerAdapter(context, dishes);
        holder.rv_dishes.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_dishes.setAdapter(dishesRecyclerAdapter);
        dishesRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        RecyclerView rv_dishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.rv_category_text);
            rv_dishes = itemView.findViewById(R.id.rv_dish);
        }
    }
}
