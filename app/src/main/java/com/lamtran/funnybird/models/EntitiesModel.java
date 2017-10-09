package com.lamtran.funnybird.models;

import com.lamtran.funnybird.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by lamtran on 10/6/17.
 */

@Table(database = MyDatabase.class)
public class EntitiesModel extends BaseModel {
    @PrimaryKey(autoincrement = true) @Column
    private int id;

    List<UrlModel> urls;
    List<MediaModel> medias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "urls")
    public List<UrlModel> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlModel> urls) {
        this.urls = urls;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "medias")
    public List<MediaModel> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaModel> medias) {
        this.medias = medias;
    }
}
