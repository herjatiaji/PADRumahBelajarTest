package com.pad1.padrumahbelajar;

import com.pad1.padrumahbelajar.model.KelasResponse;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("akun/login")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("akun/register")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                    @Field("email") String email,@Field("username") String username,
                                       @Field("password1") String password1,@Field("password2") String password2,@Field("role") String role);

    @GET("guru/kelas/getall")
    Call<KelasResponse> kelasRequest();

    @FormUrlEncoded
    @POST("guru/quiz/addquiz")
    Call<ResponseBody> quizRequest(@Field("namaQuiz") String namaQuiz, @Field("mataPelajaran") String mataPelajaran);

    @FormUrlEncoded
    @POST("guru/question/addquestion")
    Call<ResponseBody> questionRequest(@Field("token") String token,@Field("question") String question, @Field("a") String a, @Field("b") String b, @Field("c") String c,
                                       @Field("d") String d, @Field("e") String e, @Field("jawaban") String jawaban);

}
