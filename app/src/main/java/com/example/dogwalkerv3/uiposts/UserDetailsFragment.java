package com.example.dogwalkerv3.uiposts;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dogwalkerv3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentManager mFragmentManager;
    private Button mBackButton;
    private View rootView;
    private TextView mTextViewDescription;
    private TextView mTextViewPrice;
    private TextView mTextViewLocation;
    private Button mSentFeedbackButton;
    private RatingBar mRatingBarNewFeedback;

    public UserDetailsFragment() {
        // Required empty public constructor
    }

    public UserDetailsFragment(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserDetailsFragment newInstance(String param1, String param2) {
        UserDetailsFragment fragment = new UserDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
        mBackButton = rootView.findViewById(R.id.buttonBack);
        mTextViewLocation = rootView.findViewById(R.id.textViewLocationDetails);
        mTextViewPrice = rootView.findViewById(R.id.textViewPriceDetails);
        mTextViewPrice.setText("25 ron/h");
        mTextViewLocation.setText("Timisoara,Timis,Romania");
        mTextViewDescription = rootView.findViewById(R.id.textViewDescriptioDetails);
        mSentFeedbackButton = rootView.findViewById(R.id.buttonSendFeedback);
        mRatingBarNewFeedback = rootView.findViewById(R.id.ratingBarNewFeedback);
        mRatingBarNewFeedback.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                for (int i = 0; i < stars.getNumberOfLayers(); i++) {
                    Drawable drawable = stars.getDrawable(i);
                    if (i < rating) {
                        drawable.setState(new int[] { android.R.attr.state_selected });
                    } else {
                        drawable.setState(new int[] { -android.R.attr.state_selected });
                    }
                }
            }
        });

        mTextViewDescription.setText("kjnfdslkav lakshflajk glakhr glkahrgl kahgk lag adkl ghlakgh la glag lja" +
                " GA GKAG RKJADKJVB ADKJGH ljkshljdk gsdkhgljkdshflg ahrlguhald asdkgh adlkjfgh kaulhglakbgljsdfkgh " +
                "dgsm kjshg kjldfljkhlghlkjrgndflskjhaihglsrtjkhnflkbjnsn; dfhalkghal kh;a hald ghalr hga hgalhga" +
                "a lrhago hga;rghlakdjhbn;akldfhbbaer hg;a g;adigh arhgaer;gna;rvbhna;rghaerpg aphrtgksghiarugbaoergbr " +
                "rg agaherlgjkbadflkghaeruihg  ioareughoaiu uaerhlghab rieuhoiua irgbiar aeg ha reughlaerhgnerjkhgo " +
                "g arghalrhguia larjknglauhrgo haerlgal.grkln noiarglabg agparhg anrlgajkghai hgrarhglkajbn;a" +
                "arhgk abrlgjahl dkfhg a;kenglkjran ;rghp agh;akerhglkar pauhpgh a;" +
                "If you can’t uninstall the Launcher on Windows 11, a dedicated third-party tool can do it. It also saves time as you won’t have to follow extra steps.\n" +
                "\n" +
                "Numerous alternative third-party software removal utilities will uninstall Epic Games Launcher without any issues.\n" +
                "\n" +
                "Uninstallers are completely safe utilities that not only remove the selected app but also scan your PC for any leftover files or registry entries related to that app and remove them as well.\n" +
                "\n" +
                "This guarantees that your PC is clutter-free, and you will be able to reinstall the program in the future without old files interfering with new ones and causing errors such as crashing your installation.\n" +
                "\n" +
                "Dedicated uninstallers also help you remove browser toolbars, malicious software, bloatware, and more." +
                "If you can’t uninstall the Launcher on Windows 11, a dedicated third-party tool can do it. It also saves time as you won’t have to follow extra steps.\n" +
                "\n" +
                "Numerous alternative third-party software removal utilities will uninstall Epic Games Launcher without any issues.\n" +
                "\n" +
                "Uninstallers are completely safe utilities that not only remove the selected app but also scan your PC for any leftover files or registry entries related to that app and remove them as well.\n" +
                "\n" +
                "This guarantees that your PC is clutter-free, and you will be able to reinstall the program in the future without old files interfering with new ones and causing errors such as crashing your installation.\n" +
                "\n" +
                "Dedicated uninstallers also help you remove browser toolbars, malicious software, bloatware, and more.");
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentManager.popBackStack();
            }
        });
        return rootView;
    }
}