package com.example.facebookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the viewModel object
        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        RecyclerView recyclerView= findViewById(R.id.recycler);
        final PostAdapter adapter=new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}