package com.rcmapps.smartwallet.presenters;

import com.rcmapps.smartwallet.interfaces.IMainactivity;

/**
 * Created by receme on 3/10/16.
 */
public class MainPresenter {
    private IMainactivity view;
    public MainPresenter(IMainactivity _view) {
        this.view = _view;
    }

    public void init(){

        view.loadTotalAmount(0);
        view.loadHistory(null);
    }
}
