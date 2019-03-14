package com.test.wordcheck.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.wordcheck.Model.Result;
import com.test.wordcheck.R;

import java.util.ArrayList;

public class DefinitionListAdapter extends RecyclerView.Adapter<DefinitionListAdapter.MyViewHolder> {

    private ArrayList<Result> dataSet;
    private Context context;


    public DefinitionListAdapter(ArrayList<Result> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_definitions, parent, false);

//        view.setOnClickListener(Fragment360.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        final Result result = dataSet.get(listPosition);


        TextView TvDefinition = holder.TvDefinition;


        TvDefinition.setText(result.getDefinition());


    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void clear() {
        dataSet.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(ArrayList<Result> list) {
        dataSet.addAll(list);
        notifyDataSetChanged();
    }

    public void removeAt(int position) {
        dataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataSet.size());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView TvDefinition;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.TvDefinition = (TextView) itemView.findViewById(R.id.tv_definition);
        }
    }
}
