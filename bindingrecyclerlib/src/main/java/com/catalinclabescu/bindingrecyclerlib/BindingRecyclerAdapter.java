package com.catalinclabescu.bindingrecyclerlib;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by catalin on 30.05.2017.
 */

public abstract class BindingRecyclerAdapter<T1, T2 extends ViewDataBinding> extends RecyclerView.Adapter<BindingViewHolder<T2>> {
    private ArrayList<T1> data;
    private Integer layoutId;
    public ArrayList<T1> getData() {
        return data;
    }

    public BindingRecyclerAdapter(@LayoutRes Integer layoutId){
        this.layoutId = layoutId;
    }
    public void setData(ArrayList<T1> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public T1 getItemAt(int position){
        return data == null ? null : data.get(position);
    }

    @Override
    public BindingViewHolder<T2> onCreateViewHolder(ViewGroup parent, int viewType) {
        T2 dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        return dataBinding == null ? null : new BindingViewHolder<>(dataBinding);
    }

    @Override
    public void onBindViewHolder(final BindingViewHolder holder, final int position) {
        final View root = holder.getBinding().getRoot();
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelected(position, root, data.get(position));
            }
        });
        setupView((T2) holder.getBinding(), data.get(position));
    }

    public abstract void onItemSelected(int position, View view, T1 item);
    public abstract void setupView(T2 binding, T1 data);
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


}
