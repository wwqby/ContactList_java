package com.zy.contacttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * /*@Description
 * /*created by wwq on 2019/7/29
 * /*@company zhongyiqiankun
 */
public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.LetterHolder> {

    private List<String> letterList;
    private List<Integer> letterPosition;
    private RecyclerView mRecyclerView;


    public LetterAdapter(List<String> letterList, List<Integer> letterPosition, RecyclerView recyclerView) {
        this.letterList = letterList;
        this.letterPosition = letterPosition;
        mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public LetterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.letter_item,parent,false);
        return new LetterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterHolder holder, final int position) {
        holder.mLetter.setText(letterList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.smoothScrollToPosition(letterPosition.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return letterList.size();
    }

    class LetterHolder extends RecyclerView.ViewHolder{

        private TextView mLetter;
        public LetterHolder(@NonNull View itemView) {
            super(itemView);
            mLetter=itemView.findViewById(R.id.letter);
        }
    }
}
