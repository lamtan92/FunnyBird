package com.lamtran.funnybird.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lamtran.funnybird.R;
import com.lamtran.funnybird.models.TweetModel;
import com.lamtran.funnybird.util.DateHelperUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lamtran on 10/6/17.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder> {

    private List<TweetModel> mTweetModels;
    private Context mContext;

    public TimeLineAdapter(List<TweetModel> mTweetModels, Context mContext) {
        this.mTweetModels = mTweetModels;
        this.mContext = mContext;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public TimeLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_timeline_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TweetModel tweetModel = mTweetModels.get(position);
        holder.userNameTextView.setText(tweetModel.getUser().getScreenName());
        holder.nameTextView.setText(tweetModel.getUser().getName());
        holder.timeStampTextView.setText(DateHelperUtil.getRelativeTimeAgo(tweetModel.getCreateAt()));
        holder.countFavoriteTextView.setText(String.valueOf(tweetModel.getFavouritesCount()));
        holder.countReTweet.setText(String.valueOf(tweetModel.getRetweetCount()));
        holder.bodyTweetTextView.setText(tweetModel.getText());
        Glide.with(mContext)
                .load(tweetModel.getUser().getProfileImgUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.userImageView);
    }

    @Override
    public int getItemCount() {
        return mTweetModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivUser)
        ImageView userImageView;
        @BindView(R.id.tvUserName)
        TextView userNameTextView;
        @BindView(R.id.tvName)
        TextView nameTextView;
        @BindView(R.id.tvTimeStamp)
        TextView timeStampTextView;
        @BindView(R.id.tvBodyTweet)
        TextView bodyTweetTextView;
        @BindView(R.id.ibtFavorite)
        ImageButton favoriteImageButton;
        @BindView(R.id.tvCountFavorite)
        TextView countFavoriteTextView;
        @BindView(R.id.ibtReply)
        ImageButton replyImageButton;
        @BindView(R.id.ibtRetweet)
        ImageButton reTweetImageButton;
        @BindView(R.id.tvCountRetweet)
        TextView countReTweet;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
