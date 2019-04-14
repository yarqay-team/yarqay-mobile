package com.kincodi.yarqay_mobile.presentation.ui.dialogs;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.kincodi.yarqay_mobile.R;
import com.kincodi.yarqay_mobile.presentation.presenters.SearchDialogPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends DialogFragment implements SearchDialogPresenter.View {

    @BindView(R.id.RdgVenues) RadioGroup rdgVenues;
    @BindView(R.id.RdgRestaurant) RadioGroup rdgRestaurant;
    @BindView(R.id.RdgSpecial) RadioGroup rdgSpecial;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        String a = rdgVenues.toString();
        String b = rdgRestaurant.toString();
        String c = rdgSpecial.toString();
        //sendFilter(a, b, c);
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @OnClick(R.id.btnDialogDismiss)
    @Override public void dismissDialog() {
        dismiss();
    }
    @OnClick(R.id.btnSearchOk)
    @Override public void sendFilter() {

        dismiss();
    }
}
