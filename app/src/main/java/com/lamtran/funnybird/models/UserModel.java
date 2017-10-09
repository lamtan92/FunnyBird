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
public class UserModel extends BaseModel {
    @PrimaryKey(autoincrement = true)
    @Column
    private long id;
    @Column @SerializedName("id_str")
    private long idString;
    @Column
    private String name;
    @Column @SerializedName("screen_name")
    private String screenName;
    @Column
    private String location;
    @Column
    private String description;
    @Column
    private String url;
    @Column
    @SerializedName("followers_count")
    private long followersCount;
    @Column
    @SerializedName("friends_count")
    private long friendsCount;
    @Column
    @SerializedName("listed_count")
    private long listedCount;
    @Column
    @SerializedName("created_at")
    private String createdAt;
    @Column
    @SerializedName("favourites_count")
    private long favouritesCount;
    @Column
    private boolean verified;
    @Column
    @SerializedName("statuses_count")
    private long statusesCount;
    @Column
    @SerializedName("profile_background_image_url")
    private String profileBgImgUrl;
    @Column
    @SerializedName("profile_background_image_url_https")
    private String profileBgImgUrlHttps;
    @Column
    @SerializedName("profile_image_url")
    private String profileImgUrl;
    @Column
    @SerializedName("profile_image_url_https")
    private String profileImgUrlHttps;
    @Column
    @SerializedName("profile_banner_url")
    private String profileBannerUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdString() {
        return idString;
    }

    public void setIdString(long idString) {
        this.idString = idString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public long getListedCount() {
        return listedCount;
    }

    public void setListedCount(long listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getProfileBgImgUrl() {
        return profileBgImgUrl;
    }

    public void setProfileBgImgUrl(String profileBgImgUrl) {
        this.profileBgImgUrl = profileBgImgUrl;
    }

    public String getProfileBgImgUrlHttps() {
        return profileBgImgUrlHttps;
    }

    public void setProfileBgImgUrlHttps(String profileBgImgUrlHttps) {
        this.profileBgImgUrlHttps = profileBgImgUrlHttps;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getProfileImgUrlHttps() {
        return profileImgUrlHttps;
    }

    public void setProfileImgUrlHttps(String profileImgUrlHttps) {
        this.profileImgUrlHttps = profileImgUrlHttps;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }
}
