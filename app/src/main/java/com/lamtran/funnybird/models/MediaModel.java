package com.lamtran.funnybird.models;

import com.google.gson.annotations.SerializedName;
import com.lamtran.funnybird.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by lamtran on 10/6/17.
 */

@Table(database = MyDatabase.class)
public class MediaModel extends BaseModel {
    @PrimaryKey(autoincrement = true) @Column
    private long id;
    @Column @SerializedName("id_str")
    private String idString;
    @Column @SerializedName("media_url")
    private String mediaUrl;
    @Column @SerializedName("media_url_https")
    private String mediaUrlHttps;
    @Column @SerializedName("display_url")
    private String displayUrl;
    @Column @SerializedName("expanded_url")
    private String expandedUrl;
    @Column
    private String type;
    @Column
    private String url;
    @Column
    @ForeignKey(saveForeignKeyModel = true)
    private SizeModel sizes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SizeModel getSizes() {
        return sizes;
    }

    public void setSizes(SizeModel sizes) {
        this.sizes = sizes;
    }

    @Table(database = MyDatabase.class)
    public static class SizesModel extends BaseModel {
        @PrimaryKey(autoincrement = true) @Column
        private long id;
        @Column
        @ForeignKey(saveForeignKeyModel = true)
        private SizeModel small;
        @Column
        @ForeignKey(saveForeignKeyModel = true)
        private SizeModel large;
        @Column
        @ForeignKey(saveForeignKeyModel = true)
        private SizeModel medium;
        @Column
        @ForeignKey(saveForeignKeyModel = true)
        private SizeModel thumb;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public SizeModel getSmall() {
            return small;
        }

        public void setSmall(SizeModel small) {
            this.small = small;
        }

        public SizeModel getLarge() {
            return large;
        }

        public void setLarge(SizeModel large) {
            this.large = large;
        }

        public SizeModel getMedium() {
            return medium;
        }

        public void setMedium(SizeModel medium) {
            this.medium = medium;
        }

        public SizeModel getThumb() {
            return thumb;
        }

        public void setThumb(SizeModel thumb) {
            this.thumb = thumb;
        }
    }

    @Table(database = MyDatabase.class)
    public static class SizeModel extends BaseModel {
        @PrimaryKey(autoincrement = true) @Column
        private long id;
        @Column
        private int w;
        @Column
        private int h;
        @Column
        private String resize;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public String getResize() {
            return resize;
        }

        public void setResize(String resize) {
            this.resize = resize;
        }
    }
}
