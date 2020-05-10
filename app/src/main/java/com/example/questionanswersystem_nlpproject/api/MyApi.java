package com.example.questionanswersystem_nlpproject.api;

import com.example.questionanswersystem_nlpproject.response.AnswerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    //Get news with query
    @GET("soekarno/ask")
    Call<AnswerResponse> getAnswersWithQuery(
            @Query(value = "query",encoded = true) String query
    );

}
