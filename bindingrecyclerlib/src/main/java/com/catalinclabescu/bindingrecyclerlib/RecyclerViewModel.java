package com.catalinclabescu.bindingrecyclerlib;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.RecyclerView;

/**
 * Created by catalin on 30.05.2017.
 */

public class RecyclerViewModel<T extends BindingRecyclerAdapter> extends BaseObservable {
    private ObservableBoolean loading;
    private T adapter;
    private RecyclerView.LayoutManager manager;
    private Context context;

    public RecyclerViewModel(Context context){
        this.loading = new ObservableBoolean(false);
        this.context = context;
    }

    public T getAdapter() {
        return adapter;
    }

    public ObservableBoolean getLoading(){
        return loading;
    }

    @BindingAdapter({"bind:adapter", "bind:manager"})
    public static void setupRecyclerView(RecyclerView recyclerView, BindingRecyclerAdapter adapter, RecyclerView.LayoutManager manager){
        if(recyclerView == null || adapter == null || manager == null) return;
        if(recyclerView.getAdapter() != null) return;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
