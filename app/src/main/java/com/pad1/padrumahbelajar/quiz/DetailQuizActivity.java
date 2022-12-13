package com.pad1.padrumahbelajar.quiz;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.Adapter.DetailQuizAdapter;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.api.BaseApiService;
import com.pad1.padrumahbelajar.api.UtilsApi;
import com.pad1.padrumahbelajar.fragment.QuizFragment;
import com.pad1.padrumahbelajar.model.QuestionData;
import com.pad1.padrumahbelajar.model.QuestionResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailQuizActivity extends AppCompatActivity {
    private DetailQuizAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService2;
    TextView tv1, tv2;
    String mataPelajaran, namaQuiz;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quiz);

        mApiService2 = UtilsApi.getAPIService();
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        mataPelajaran = bundle.getString("mataPelajaran");
        namaQuiz = bundle.getString("namaQuiz");
        arrow = findViewById(R.id.imageViewQuizOption);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv1.setText(mataPelajaran);
        tv2.setText(namaQuiz);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailQuizActivity.this, AddQuestionActivity.class);
                startActivity(intent);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailQuizActivity.this, QuizFragment.class);
            }
        });
        mApiService2.questionRequest().enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                if (response.isSuccessful()) {
                    QuestionResponse questionResponse = response.body();
                    ArrayList<QuestionData> questionData = questionResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + questionResponse.getStatus().toString());
                    try {
                        String nama = questionData.get(0).getJawaban().toString();
                        Log.d("getsucces",nama);
//                        tv1.setText(nama);

//                        adapter = new DetailQuizAdapter(DetailQuizActivity.this, questionData);
//                        recyclerView.setAdapter(adapter);
                    } catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                } else {
                    tv1.setText("Error woy");
                }
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {

            }
        });

    }
}