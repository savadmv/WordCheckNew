package com.test.wordcheck.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        apContext = (App) getApplication();
        if (!apContext.getWordResponse().getResults().isEmpty())
            TvDefinition.setText("\""+apContext.getWordResponse().getResults().get(0).getDefinition()+"\"");
        else
            TvDefinition.setText("No result");
        Log.i(TAG, apContext.wordResponse.getWord());
    }
}
