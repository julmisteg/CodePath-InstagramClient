package com.example.julmiste.instagramclient;

import android.content.Context;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gaetanejulmiste on 5/12/16.
 */
public class InstagramCommentAdapter extends ArrayAdapter<InstagramComment> {

    public InstagramCommentAdapter(Context context, int resource, List<InstagramComment> objects) {
        super(context, resource, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramComment comment = getItem(position);
        ImageView ivUsrProfile = (ImageView) convertView.findViewById(R.id.ivUsrProfile_Comment);
        TextView tvcomment = (TextView) convertView.findViewById(R.id.tvComment);
        TextView tvTimeStamp = (TextView) convertView.findViewById(R.id.tvTimeStamp_Comment);

        String relativeTSComment = DateUtils.getRelativeTimeSpanString(
                comment.createdT,System.currentTimeMillis(),DateUtils.DAY_IN_MILLIS,DateUtils.FORMAT_ABBREV_RELATIVE
        ).toString();


        String htmlComment = comment.usrName + " " + comment.text;
        tvcomment.setText(Html.fromHtml(htmlComment));

        Picasso.with(getContext()).load(comment.profilePic).into(ivUsrProfile);

        return convertView;
    }




}
