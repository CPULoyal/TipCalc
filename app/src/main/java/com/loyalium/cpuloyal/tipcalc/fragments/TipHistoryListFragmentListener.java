package com.loyalium.cpuloyal.tipcalc.fragments;

import com.loyalium.cpuloyal.tipcalc.models.TipRecord;

/**
 * Created by blamagroth on 31/05/16.
 */
public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}