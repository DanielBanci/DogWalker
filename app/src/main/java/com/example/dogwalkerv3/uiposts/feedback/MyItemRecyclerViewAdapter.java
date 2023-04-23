package com.example.dogwalkerv3.uiposts.feedback;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dogwalkerv3.databinding.FragmentFeedbackBinding;
import com.example.dogwalkerv3.uiposts.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public MyItemRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentFeedbackBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content);
        holder.mTextViewName.setText("Name " + mValues.get(position).id);
        holder.mTextViewMessage.setText("A nice and kind person, did the job really good and he's always on time!\n" +
                "Don t hesitate to get in touch with him!");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final TextView mIdView;
        //public final TextView mContentView;
        public PlaceholderItem mItem;
        public TextView mTextViewName;
        public TextView mTextViewMessage;

        public ViewHolder(FragmentFeedbackBinding binding) {
            super(binding.getRoot());
            //mIdView = binding.itemNumber;
            //mContentView = binding.content;
            mTextViewName = binding.textViewNameFeedback;
            mTextViewMessage = binding.textViewMessageFeedback;
        }

        @Override
        public String toString() {
            return super.toString() /*+ " '" + mContentView.getText() + "'"*/;
        }
    }
}