package com.lamtran.funnybird.models;

import com.google.gson.annotations.SerializedName;
import com.lamtran.funnybird.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
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
public class TweetModel extends BaseModel {
    @PrimaryKey @Column
    Long id;
    @Column @SerializedName("id_str")
    private String idStr;
    @Column @SerializedName("created_at")
    private String createAt;
    @Column @SerializedName("text")
    private String text;
    @Column @SerializedName("retweet_count")
    private int retweetCount;
    @Column @SerializedName("favorite_count")
    private int favouritesCount;
    @Column @ForeignKey(saveForeignKeyModel = true)
    private EntitiesModel entities;
    @Column @ForeignKey(saveForeignKeyModel = true)
    private UserModel user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public EntitiesModel getEntities() {
        return entities;
    }

    public void setEntities(EntitiesModel entities) {
        this.entities = entities;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public TweetModel() {
        super();
    }

    public TweetModel(JSONObject object) {
        super();

//        try {
//            this.userId = object.getString("user_id");
//            this.userHandle = object.getString("user_username");
//            this.timeStamp = object.getString("timestamp");
//            this.body = object.getString("body");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    public ArrayList<TweetModel> fromJson(JSONArray jsonArray) {
        ArrayList<TweetModel> tweetModels = new ArrayList<TweetModel>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject tweetJson = null;

            try {
                tweetJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }

            TweetModel tweetModel = new TweetModel(tweetJson);
            tweetModel.save();
            tweetModels.add(tweetModel);
        }

        return tweetModels;
    }
}
