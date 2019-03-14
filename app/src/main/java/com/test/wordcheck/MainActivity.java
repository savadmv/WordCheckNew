package com.test.wordcheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.test.wordcheck.Activity.WordDetailActivity;
import com.test.wordcheck.Model.WordResponse;
import com.test.wordcheck.Network.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CardView actCheck;
    private EditText EtWord;
    private ApiInterface apiInterface;
    private Context context;
    private App apContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        actCheck = (CardView) findViewById(R.id.btn_check);
        EtWord = (EditText) findViewById(R.id.et_word);

        apContext = (App) getApplication();

        //intialising Api Client
        apiInterface = APIClient.getClient().create(ApiInterface.class);

        actCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi(EtWord.getText().toString().trim());
            }
        });
    }

    private void callApi(String word) {
        Call<WordResponse> call = apiInterface.getEveryThing("1137deda68msh69349db8fabd3dbp1c6e88jsna080fbfd15cf", word);
        call.enqueue(new Callback<WordResponse>() {
            @Override
            public void onResponse(Call<WordResponse> call, Response<WordResponse> response) {
                if (response.code()==200) {
                    apContext.setWordResponse(response.body());
                    Intent intent = new Intent(context, WordDetailActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<WordResponse> call, Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
