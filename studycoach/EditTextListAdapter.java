package com.example.studycoach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;


public class EditTextListAdapter extends RecyclerView.Adapter<EditTextListAdapter.EditTextItemViewHolder> {

    private LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    class EditTextItemViewHolder extends RecyclerView.ViewHolder{
        public final TextView editTextListItemView;
        final EditTextListAdapter mAdapter;

        //constructor
        public EditTextItemViewHolder(View itemView, com.example.studycoach.EditTextListAdapter adapter) {
            super(itemView);
            editTextListItemView = itemView.findViewById(R.id.quizzedword);
            this.mAdapter = adapter;
        }
    }

    public EditTextListAdapter(Context context, LinkedList<String> EditTextItemList){
        mInflater = LayoutInflater.from(context);
        this.mWordList = EditTextItemList;
    }

    @Override
    public EditTextItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.study_list_item, parent, false);
        return new EditTextItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(EditTextItemViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.editTextListItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
