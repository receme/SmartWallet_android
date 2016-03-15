package com.rcmapps.smartwallet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rcmapps.smartwallet.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by receme on 3/15/16.
 */
public class HistoryViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.amountTv)
    TextView amountTv;
    @Bind(R.id.reasonTv)
    TextView reasonTv;
    @Bind(R.id.dateTv)
    TextView dateTv;

    public HistoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        amountTv = (TextView) itemView.findViewById(R.id.amountTv);
    }
}
