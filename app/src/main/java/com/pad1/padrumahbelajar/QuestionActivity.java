package com.pad1.padrumahbelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {
    EditText etSoal, etA, etB, etC, etD, etE;
    String jawaban, token;
    RadioButton rbA, rbB, rbD, rbC, rbE;
    RadioGroup radioGroupJawaban;
    BaseApiService mApiService;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        etSoal = findViewById(R.id.etSoal);
        etA = findViewById(R.id.tietA);
        etB = findViewById(R.id.tietB);
        etC = findViewById(R.id.tietC);
        etD = findViewById(R.id.tietD);
        etE = findViewById(R.id.tietE);
        jawaban = "";
        token = "wdu8Ohc8";
        btnAdd = findViewById(R.id.btnAdd);


        radioGroupJawaban = findViewById(R.id.radioGroupJawab);
        mApiService = UtilsApi.getAPIService();

        radioGroupJawaban.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonA:
                        jawaban = "A";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonB:
                        jawaban = "B";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonC:
                        jawaban = "C";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonD:
                        jawaban = "D";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonE:
                        jawaban = "E";
                        Toast.makeText(getApplicationContext(), jawaban, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postQuestion();

            }
        });


    }

    public void postQuestion() {
        mApiService.questionRequest(token, etSoal.getText().toString(), etA.getText().toString(),
                etB.getText().toString(), etC.getText().toString(), etD.getText().toString(),
                etE.getText().toString(), jawaban).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Toast.makeText(QuestionActivity.this, "sukses heheh", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuestionActivity.this, "gagal nich", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }

        });
    }
}