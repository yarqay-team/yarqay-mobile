package com.kincodi.yarqay_mobile.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kincodi.yarqay_mobile.R;
import com.kincodi.yarqay_mobile.domain.model.Restaurant;


import java.util.List;
public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>{
    private List<Restaurant> restaurants;
    private View.OnClickListener listener;
    private Context ctx;
    public RestaurantListAdapter(Context context, List<Restaurant> mRestaurants) {
        restaurants = mRestaurants;
        ctx = context;
    }
    public void addRestaurants(List<Restaurant> mRestaurants) {
        this.restaurants.addAll(mRestaurants);
    }

    @NonNull
    @Override public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.restaurant_item, viewGroup, false);
        return new RestaurantViewHolder(v, listener);
    }
    @Override public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        restaurantViewHolder.bind(restaurants.get(i), ctx);
    }
    @Override public int getItemCount() {
        return restaurants.size();
    }
    class RestaurantViewHolder extends RecyclerView.ViewHolder {

        TextView txtOrder;
        TextView txtPlace;
        TextView txtType;
        TextView txtTitle;
        RestaurantViewHolder(@NonNull View v, View.OnClickListener listener) {
            super(v);
            txtOrder = v.findViewById(R.id.txtOrder);
            txtPlace  = v.findViewById(R.id.txtPlace);
            txtType = v.findViewById(R.id.txtTypeFood);
            txtTitle = v.findViewById(R.id.txtTitle);
            v.setOnClickListener(listener);
        }
        void bind(final Restaurant restaurant, Context ctx) {

            txtPlace.setText(restaurant.getName());
            txtOrder.setText(restaurant.getName());
            txtType.setText(restaurant.getName());
            txtTitle.setText(restaurant.getName());
        }
    }
    public void onClickItem(View.OnClickListener mListener) {
        listener = mListener;
    }
}