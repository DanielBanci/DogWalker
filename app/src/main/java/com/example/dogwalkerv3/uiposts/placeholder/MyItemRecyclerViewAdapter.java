package com.example.dogwalkerv3.uiposts.placeholder;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dogwalkerv3.R;
import com.example.dogwalkerv3.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.dogwalkerv3.databinding.FragmentContentBinding;
import com.example.dogwalkerv3.uiposts.UserDetailsFragment;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;
    private final FragmentManager mFragmentManager;


    public MyItemRecyclerViewAdapter(List<PlaceholderItem> items,FragmentManager fragmentManager) {

        mValues = items;
        mFragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id + "GH");
        holder.mRatingBar.setRating(3.5f);

        //holder.mtextViewDescription.setText("");

        //holder.mContentView.setText(mValues.get(position).content);
        holder.mDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                UserDetailsFragment myNewFragment = new UserDetailsFragment(mFragmentManager);
                fragmentTransaction.replace(R.id.fragmentContainerView, myNewFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        //public final TextView mContentView;
        public final RatingBar mRatingBar;
        public final Button mDetailsButton;
        private final TextView mtextViewDescription;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentContentBinding binding) {
            super(binding.getRoot());
            mIdView = binding.textViewName;
            mRatingBar = binding.ratingBar;
            mDetailsButton = binding.buttonDetails;
            mtextViewDescription = (TextView) binding.textViewDescription;
            //mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() /*+ " '" + mContentView.getText() + "'"*/;
        }
    }
}