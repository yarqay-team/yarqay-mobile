package com.kincodi.yarqay_mobile.presentation.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.kincodi.yarqay_mobile.R;
import com.kincodi.yarqay_mobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.yarqay_mobile.domain.model.Restaurant;
import com.kincodi.yarqay_mobile.presentation.presenters.RestaurantPresenter;
import com.kincodi.yarqay_mobile.presentation.presenters.impl.Restaurant.RestaurantPresenterImpl;
import com.kincodi.yarqay_mobile.presentation.ui.adapter.RestaurantListAdapter;
import com.kincodi.yarqay_mobile.presentation.ui.dialogs.SearchFragment;
import com.kincodi.yarqay_mobile.storage.RestaurantRepositoryImpl;
import com.kincodi.yarqay_mobile.threading.MainThreadImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener, RestaurantPresenter.View{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycler) RecyclerView recyclerView;
    RestaurantListAdapter restaurantAdapter;
    RestaurantRepositoryImpl restaurantRepository;
    RecyclerView.LayoutManager lManager;
    RestaurantPresenterImpl presenter;
    boolean mIsLargeLayout;

    private List<Restaurant> restaurants= new ArrayList<>();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        restaurantRepository = new RestaurantRepositoryImpl();
        mIsLargeLayout = getResources().getBoolean(R.bool.large_layout);
        lManager = new LinearLayoutManager(this);
        setSupportActionBar(toolbar);
        restaurantAdapter = new RestaurantListAdapter(this,restaurants);
        getRestaurant();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lManager);
        recyclerView.setAdapter(restaurantAdapter);

    }
    public void getRestaurant() {
        presenter = new RestaurantPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                restaurantRepository, this);
        presenter.getRestaurant();
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchTwo:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public  boolean onMenuItemClick (MenuItem item) {
        switch (item.getItemId()) {

            case R.id.searchTwo:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void showDialog(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SearchFragment newFragment = new SearchFragment();
        if (mIsLargeLayout) {
            newFragment.show(fragmentManager, "dialog");
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();
        }
    }
    @Override public void onSuccessGotRestaurant(List<Restaurant> restaurants) {
        restaurantAdapter.addRestaurants(restaurants);
        restaurantAdapter.notifyDataSetChanged();
    }
    @Override public void onFailedGotRestaurant(String message) {
        Log.d("ERROR", message);
    }
    @Override public void showProgress() {
    }
    @Override public void hideProgress() {
    }
    @Override public void showError(String message) {
    }
}
