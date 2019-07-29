package com.zy.contacttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * /*@Description
 * /*created by wwq on 2019/7/29
 * /*@company zhongyiqiankun
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> mContactList;

    public ContactAdapter(List<Contact> contactList) {
        mContactList = contactList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact data=mContactList.get(position);
        holder.mLetter.setText(data.getFirstLetter());
        holder.mName.setText(data.getName());
        holder.mPhone.setText(data.getPhone());
        Glide.with(holder.mPic.getContext()).load(data.getPicUrl()).into(holder.mPic);

    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder{

        private TextView mLetter;
        private TextView mName;
        private TextView mPhone;
        private ImageView mPic;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name);
            mLetter=itemView.findViewById(R.id.letter);
            mPhone=itemView.findViewById(R.id.phone);
            mPic=itemView.findViewById(R.id.pic);
        }
    }
}
