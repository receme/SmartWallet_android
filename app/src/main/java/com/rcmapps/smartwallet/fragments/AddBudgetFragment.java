package com.rcmapps.smartwallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rcmapps.smartwallet.R;

/**
 * Created by receme on 3/28/16.
 */
public class AddBudgetFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addbudget,container,false);

        return view;
    }
}
