package com.catalinclabescu.bindingrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.catalinclabescu.bindingrecycler.databinding.RowSimpleBinding;
import com.catalinclabescu.bindingrecyclerlib.BindingRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BindingRecyclerAdapter<String, RowSimpleBinding> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        adapter = new BindingRecyclerAdapter<String, RowSimpleBinding>(R.layout.row_simple) {
            @Override
            public void onItemSelected(int position, View view, String item) {

            }

            @Override
            public void setupView(RowSimpleBinding binding, String data) {
                binding.setViewModel(data);
            }
        };
        ArrayList<String> items = new ArrayList<>(2000);
        for(int i=0; i<2000; i++){
            items.add("Test " + i);
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter.setData(items);
    }
}
