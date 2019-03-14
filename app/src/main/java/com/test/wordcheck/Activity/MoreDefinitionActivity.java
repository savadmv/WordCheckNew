package com.test.wordcheck.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.wordcheck.Adapters.DefinitionListAdapter;
import com.test.wordcheck.App;
import com.test.wordcheck.Model.Result;
import com.test.wordcheck.R;

import java.util.ArrayList;

public class MoreDefinitionActivity extends AppCompatActivity {

    private RecyclerView RvDefinitionsList;
    private LinearLayoutManager layoutManager;
    private ArrayList<Result> definitionList=new ArrayList<>();
    private App apContext;
    private DefinitionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_definition);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        apContext = (App) getApplication();
        definitionList.addAll(apContext.getWordResponse().getResults());
        initRecyclerView();

    }

    // intiate recycler view
    private void initRecyclerView() {
        RvDefinitionsList = (RecyclerView) findViewById(R.id.rv_definitions);

        RvDefinitionsList.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RvDefinitionsList.setLayoutManager(layoutManager);
        RvDefinitionsList.setItemAnimator(new DefaultItemAnimator());

        adapter = new DefinitionListAdapter(definitionList, getApplicationContext());
        RvDefinitionsList.setAdapter(adapter);


    }

    /**
     * impliment even for back button click in toolbar
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();


        return true;
    }
}
