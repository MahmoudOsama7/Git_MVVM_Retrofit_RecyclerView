package com.example.facebookv2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2.data.PostsClient;
import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//will create the ViewModel class from the architecture MVVM
public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postMutableLiveData=new MutableLiveData<>();
    public void getPosts(){
        PostsClient.getINSTANCE().getAllPosts().enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
                Log.d("Message",postMutableLiveData.getValue().size()+"");
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {

            }
        });
    }
}
