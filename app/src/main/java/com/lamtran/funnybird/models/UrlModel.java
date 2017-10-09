package com.lamtran.funnybird.models;

import com.google.gson.annotations.SerializedName;
import com.lamtran.funnybird.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by lamtran on 10/6/17.
 */

@Table(database = MyDatabase.class)
public class UrlModel extends BaseModel {
    @PrimaryKey(autoincrement = true)
    @Column
    private int id;
    @Column
    private String url;
    @Column @SerializedName("expanded_url")
    private String expandedUrl;
    @Column @SerializedName("display_url")
    private String displayUrl;
    @Column
    private String entitiesId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getEntitiesId() {
        return entitiesId;
    }

    public void setEntitiesId(String entitiesId) {
        this.entitiesId = entitiesId;
    }
}
