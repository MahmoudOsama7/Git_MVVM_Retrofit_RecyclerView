package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    //url to be used
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    //interface to use it with each request done by Retrofit
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        //creating retrofit instance
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        //creating the interface of type PostInterface that we created before that contain all HTTP requests
        postInterface=retrofit.create(PostInterface.class);
    }
    //will use the getInstance method as to create only one object fo the class PostClient
    //to use it because we don't want to create new instance each we use this class
    //however after that will use it to continue and create the api itself of type get or Post and so on
    //so the postClient constructor is SINGLETON object and that is why we use static
    public static PostsClient getINSTANCE() {
        if(INSTANCE==null)
        {
            //if null will create new one , if not will use the already created one
            INSTANCE=new PostsClient();
        }
        return INSTANCE;
    }
    //method to get the data from teh getRequest and that is why the return type is Call<PostModel>
    //to get only one post
    public Call<PostModel> getPosts()
    {
        //that is similar to var call = api.getPost() but in kotlin
        //here will return the value returned from the getPost in our api that is called PostInterface
        //and we already referenced the postInterface upward that is postInterface=retrofit.create(PostInterface.class); like api.getPost() but in kotlin
        return postInterface.getPosts();
    }
    //to get all the posts from the retrofit
    public Call<ArrayList<PostModel>> getAllPosts()
    {
        return postInterface.getAllPosts();
    }
}
