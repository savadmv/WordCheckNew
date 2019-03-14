package com.test.wordcheck.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        TextView TvDerivations = holder.TvDerivations;
        LinearLayout DerivationLayout = holder.DerivationLayout;
        TvDefinition.setText("\"" + result.getDefinition() + "\"");

        ArrayList<String> newDerivationList = new ArrayList<>();
        newDerivationList.clear();
        if (result.getDerivation() != null) {
            DerivationLayout.setVisibility(View.VISIBLE);
            for (String s : result.getDerivation()) {
                newDerivationList.add("\"" + s + "\"");
            }
            TvDerivations.setText(TextUtils.join(",", newDerivationList));
        } else {
            DerivationLayout.setVisibility(View.GONE);
        }
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
        TextView TvDerivations;
        LinearLayout DerivationLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.TvDefinition = (TextView) itemView.findViewById(R.id.tv_definition);
            this.TvDerivations = (TextView) itemView.findViewById(R.id.tv_derivations);
            this.DerivationLayout = (LinearLayout) itemView.findViewById(R.id.ll_derivations);
        }
    }
}
