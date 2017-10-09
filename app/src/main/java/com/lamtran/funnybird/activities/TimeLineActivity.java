package com.lamtran.funnybird.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lamtran.funnybird.R;
import com.lamtran.funnybird.RestApplication;
import com.lamtran.funnybird.RestClient;
import com.lamtran.funnybird.adapters.TimeLineAdapter;
import com.lamtran.funnybird.models.TweetModel;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class TimeLineActivity extends AppCompatActivity {
    @BindView(R.id.rvTimeLine)
    RecyclerView rvTimeLine;

    ArrayList<TweetModel> arrTweet;
    TimeLineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        ButterKnife.bind(this);

        arrTweet = new ArrayList<TweetModel>();
        adapter = new TimeLineAdapter(arrTweet, this);
        rvTimeLine.setAdapter(adapter);
        rvTimeLine.setLayoutManager(new LinearLayoutManager(this));

        getTimeLineJSON();
    }

    private void getTimeLineJSON() {
        RestClient client = RestApplication.getRestClient();
        client.getHomeTimeline(1, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                Log.d("DEBUG", "timeline: " + jsonArray.toString());
                // Load json array into model classes
                Gson gson = new Gson();
                Type listType = new TypeToken<List<TweetModel>>() {

                }.getType();
                List<TweetModel> result = gson.fromJson(jsonArray.toString(), listType);
                arrTweet.addAll(result);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
