package com.example.julmiste.instagramclient;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by julmiste on 5/10/16.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto>{

    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo,parent,false);

        }

        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ImageView ivUserProfile = (ImageView) convertView.findViewById(R.id.ivUserProfile) ;
        TextView tvUserName =(TextView)convertView.findViewById(R.id.tvUserName) ;
        TextView tvTimeStamp =(TextView) convertView.findViewById(R.id.tvTimeStamp);
        TextView tvLikesCount =(TextView) convertView.findViewById(R.id.tvLikesCount) ;


        ivPhoto.setImageResource(0);
        ivUserProfile.setImageResource(0);

        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        Picasso.with(getContext()).load(photo.profilePicture).into(ivUserProfile);

        tvUserName.setText(photo.username);
        tvUserName.setTextColor(Color.BLUE);

        tvLikesCount.setText(photo.likesCount + "likes");
        tvLikesCount.setTextColor(Color.BLUE);

        Spannable caption = new SpannableString(photo.username + " " + photo.caption) ;
        caption.setSpan(new ForegroundColorSpan(Color.BLUE),0,photo.username.length(),0);
        //tvCaption.setText(photo.caption);
        tvCaption.setText(caption, TextView.BufferType.SPANNABLE);

        String relativeTimeStamp = DateUtils.getRelativeTimeSpanString(
                photo.createdTime
                ,System.currentTimeMillis()
                ,DateUtils.DAY_IN_MILLIS
                ,DateUtils.FORMAT_ABBREV_RELATIVE
        ).toString();
        tvTimeStamp.setText(relativeTimeStamp);

        Transformation trans =new RoundedTransformationBuilder().borderColor(Color.TRANSPARENT).cornerRadiusDp(20).oval(false).build();
        Picasso.with(getContext()).load(photo.profilePicture).fit().transform(trans).into(ivUserProfile);
        return convertView;
    }
}
