package com.example.questionanswersystem_nlpproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questionanswersystem_nlpproject.R;
import com.example.questionanswersystem_nlpproject.api.ApiClient;
import com.example.questionanswersystem_nlpproject.api.MyApi;
import com.example.questionanswersystem_nlpproject.response.AnswerResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.edt_input)
    EditText edt_input;
    @BindView(R.id.btn_tanya)
    Button btn_tanya;
    @BindView(R.id.tv_answer)
    TextView tv_answer;
    @BindView(R.id.tv_answer_type)
    TextView tv_answer_type;
    @BindView(R.id.tv_key_words)
    TextView tv_key_words;
    @BindView(R.id.tv_result_sentence)
    TextView tv_result_sentence;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private MyApi myApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn_tanya.setOnClickListener(this::onClick);

        myApi = ApiClient.getClient().create(MyApi.class);
    }


    private void getAnswersWithQuery(String query) {
        Call<AnswerResponse> newsResponseCall = myApi.getAnswersWithQuery(query);
        newsResponseCall.enqueue(new Callback<AnswerResponse>() {
            @Override
            public void onResponse(Call<AnswerResponse> call, Response<AnswerResponse> response) {
                if (response.isSuccessful()) {
                    String message = response.body().getMessage();
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                    AnswerResponse answerResponse = response.body();

                    tv_answer.setText(answerResponse.getData().getAnswer());
                    tv_answer_type.setText(answerResponse.getData().getAnswer_type());
                    tv_key_words.setText(String.valueOf(answerResponse.getData().getKey_words()));
                    tv_result_sentence.setText(answerResponse.getData().getResult_sentence().replace("\n","").trim());

                    progressBar.setVisibility(View.GONE);


                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<AnswerResponse> call, Throwable t) {
                Log.d("cek", t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tanya:
                progressBar.setVisibility(View.VISIBLE);
                String query = edt_input.getText().toString();
                getAnswersWithQuery(query);
                break;
        }

    }
}
