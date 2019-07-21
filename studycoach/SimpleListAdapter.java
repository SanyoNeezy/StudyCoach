package com.example.studycoach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;


public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleItemViewHolder> {

    //private LinkedList<String> mWordList;
    private List<Entity_Category> categories;
    private LayoutInflater mInflater;

    public SimpleListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        //ToDo: Test in dem ich diesen Parameter aus dem Konstruktor und die nachfolgende Codezeile
        // entfernt habe:
        // , LinkedList<Entity_Category> SimpleItemList
        // this.categories = SimpleItemList;
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.simple_list_item, parent, false);
        return new SimpleItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SimpleItemViewHolder holder, int position) {
        if (categories != null){
            Entity_Category mCurrent = categories.get(position);
            holder.simpleListItemView.setText(mCurrent.getValue());
        }
        else holder.simpleListItemView.setText("EMPTY!");
    }

    void setCategories(List<Entity_Category> categories){
        this.categories = categories;
        notifyDataSetChanged();
    }

    public Entity_Category getCategoryAt(int position){
        return categories.get(position);
    }



    @Override
    public int getItemCount() {
        if (categories!=null){
            return categories.size();
        }else
            return 0;
    }

    class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView simpleListItemView;
        SimpleListAdapter mAdapter;

        //constructor
        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            simpleListItemView = itemView.findViewById(R.id.category);
        }
        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int position = getLayoutPosition();
            //itemView.chi
            //mAdapter.notifyDataSetChanged();
        }

    }

}
