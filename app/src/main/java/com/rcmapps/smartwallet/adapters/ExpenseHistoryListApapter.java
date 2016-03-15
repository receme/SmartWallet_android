package com.rcmapps.smartwallet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rcmapps.smartwallet.R;
import com.rcmapps.smartwallet.db.Expense;

import java.util.List;

/**
 * Created by receme on 3/15/16.
 */
public class ExpenseHistoryListApapter extends RecyclerView.Adapter<HistoryViewHolder> {

    private Context context;
    private List<Expense> expenses;

    public ExpenseHistoryListApapter(Context context, List<Expense> expenes){
        this.context = context;
        this.expenses = expenes;

    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater
                .from(context)
                .inflate(R.layout.listitem_history, parent, false);

        return new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {

        //if(expenses!=null){
            Expense expense = expenses.get(position);
            holder.amountTv.setText(expense.getAmount().toString());
            holder.reasonTv.setText(expense.getReason());
            //holder.dateTv.setText(expense.getDate().toString());

            Log.d("LIST",holder.amountTv.getText().toString());
       // }

    }

    @Override
    public int getItemCount() {
        return expenses!=null?expenses.size():0;
    }
}
