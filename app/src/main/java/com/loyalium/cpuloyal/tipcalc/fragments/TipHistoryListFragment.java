package com.loyalium.cpuloyal.tipcalc.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loyalium.cpuloyal.tipcalc.R;
import com.loyalium.cpuloyal.tipcalc.activities.TipDetailActivity;
import com.loyalium.cpuloyal.tipcalc.adapters.OnItemClickListener;
import com.loyalium.cpuloyal.tipcalc.adapters.TipAdapter;
import com.loyalium.cpuloyal.tipcalc.models.TipRecord;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener, OnItemClickListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    TipAdapter adapter;

    public TipHistoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this, rootView);
        initAdapter();
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new TipAdapter(getActivity().getApplicationContext(), this);
        }
    }

    @Override
    public void addToList(TipRecord record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onItemClick(TipRecord record) {
        Intent intent = new Intent(getActivity(), TipDetailActivity.class);
        intent.putExtra(TipDetailActivity.TIP_KEY, record.getTip());
        intent.putExtra(TipDetailActivity.BILL_TOTAL_KEY, record.getBill());
        intent.putExtra(TipDetailActivity.DATE_KEY, record.getDateFormatted());
        startActivity(intent);
    }
}