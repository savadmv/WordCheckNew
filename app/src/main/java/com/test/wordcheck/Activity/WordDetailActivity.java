package com.test.wordcheck.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.wordcheck.App;
import com.test.wordcheck.R;

public class WordDetailActivity extends AppCompatActivity {

    private App apContext;
    private String TAG = WordDetailActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);
        TextView TvDefinition = (TextView) findViewById(R.id.tv_definition);
        TextView TvWord = (TextView) findViewById(R.id.tv_word);
        CardView actMore = (CardView) findViewById(R.id.btn_more);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        apContext = (App) getApplication();

        if (apContext.getWordResponse().getResults().size()>1){
            actMore.setVisibility(View.VISIBLE);
        }
        else {
            actMore.setVisibility(View.GONE);
        }

        if (!apContext.getWordResponse().getResults().isEmpty())
            TvDefinition.setText("\""+apContext.getWordResponse().getResults().get(0).getDefinition()+"\"");
        else
            TvDefinition.setText("No result");
        Log.i(TAG, apContext.wordResponse.getWord());

        TvWord.setText("\""+apContext.getWordResponse().getWord()+"\"");
        actMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MoreDefinitionActivity.class);
                startActivity(intent);
            }
        });
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
