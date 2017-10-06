package com.lamtran.funnybird.models;

import com.lamtran.funnybird.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lamtran on 10/5/17.
 */

@Table(database = MyDatabase.class)
public class Tweet extends BaseModel {
    @PrimaryKey @Column
    Long id;
    @Column
    String userId;
    @Column
    String userHandle;
    @Column
    String timeStamp;
    @Column
    String body;

    public Tweet() {
        super();
    }

    public Tweet(JSONObject object) {
        super();

        try {
            this.userId = object.getString("user_id");
            this.userHandle = object.getString("user_username");
            this.timeStamp = object.getString("timestamp");
            this.body = object.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tweet> fromJson(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<Tweet>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject tweetJson = null;

            try {
                tweetJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }

            Tweet tweet = new Tweet(tweetJson);
            tweet.save();
            tweets.add(tweet);
        }

        return  tweets;
    }
}
