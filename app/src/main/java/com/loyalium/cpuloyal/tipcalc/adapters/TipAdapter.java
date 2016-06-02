package com.loyalium.cpuloyal.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loyalium.cpuloyal.tipcalc.R;
import com.loyalium.cpuloyal.tipcalc.models.TipRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by blamagroth on 31/05/16.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.TipViewHolder> {

    private Context context;
    private List<TipRecord> dataset;
    private OnItemClickListener onItemClickListener;


    public TipAdapter(Context context, List<TipRecord> dataset, OnItemClickListener listener) {
        this.context = context;
        this.dataset = dataset;
        this.onItemClickListener = listener;
    }

    public TipAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onItemClickListener = listener;
    }

    @Override
    public TipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new TipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TipViewHolder holder, int position) {
        TipRecord element = dataset.get(position);
        String strTip = String.format(
                context.getString(R.string.global_message_tip),
                element.getTip());

        holder.txtContent.setText(strTip);
        holder.txtDate.setText(element.getDateFormatted());
        holder.setOnItemClickListener(element, this.onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(TipRecord record) {
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public class TipViewHolder extends RecyclerView.ViewHolder {
        private View view;
        @Bind(R.id.txtContent)
        TextView txtContent;
        @Bind(R.id.txtDate)
        TextView txtDate;

        public TipViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setOnItemClickListener(final TipRecord element,
                                           final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                }
            });

        }
    }
}