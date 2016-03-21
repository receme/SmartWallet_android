package com.rcmapps.smartwallet;

import com.rcmapps.smartwallet.db.Budget;
import com.rcmapps.smartwallet.interfaces.IDbmanager;
import com.rcmapps.smartwallet.interfaces.IMainactivity;
import com.rcmapps.smartwallet.presenters.MainPresenter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by receme on 3/22/16.
 */
public class MainPresenterTest {

    private IMainactivity view;
    private IDbmanager db;
    private MainPresenter presenter;

    public MainPresenterTest(){

        view = Mockito.mock(IMainactivity.class);
        db = Mockito.mock(IDbmanager.class);

        presenter = new MainPresenter(view,db);
    }


    @Test
    public void PassTest(){
        assertTrue(true);
    }

    @Test
    public void init_WithNoParam_WillIntializeValue(){

        Mockito.when(db.getBudgetEntries()).thenReturn(null);

        presenter.init();

        Mockito.verify(view).loadTotalAmount(Matchers.eq(0));
    }

    @Test
    public void getTotalAmount_WithNoParam_WillReturnTotalAmount(){

        List<Budget> entries = new ArrayList<>();
        entries.add(new Budget(1L,100, Calendar.getInstance().getTime() ,"January"));
        entries.add(new Budget(2L,204, Calendar.getInstance().getTime() ,"March"));
        entries.add(new Budget(3L,500, Calendar.getInstance().getTime() ,"April"));

        int expectedAmount = 804;

        Mockito.when(db.getBudgetEntries()).thenReturn(entries);

        assertEquals(expectedAmount,presenter.getTotalAmount());
    }
}
