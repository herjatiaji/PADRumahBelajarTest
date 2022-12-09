package com.pad1.padrumahbelajar;

import com.pad1.padrumahbelajar.model.KelasResponse;

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



}
