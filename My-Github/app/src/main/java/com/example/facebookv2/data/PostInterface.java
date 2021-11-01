package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Call<PostModel> getPosts();

    @GET("posts")
    Call<ArrayList<PostModel>> getAllPosts();
}
