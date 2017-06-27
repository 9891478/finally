package io.esur.nvx;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CommentFragment extends Fragment {

    //    private OnFragmentInteractionListener mListener;
    private String fragmentMainComment;

    public CommentFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comment_main_cv, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.max);
        TextView MessageView = ( TextView ) view.findViewById ( R.id.message_view ) ;

        int lineHeight = MessageView.getLineHeight();

        Drawable DICON = getResources().getDrawable(R.drawable.max, null);
        int leftMargin = DICON.getIntrinsicWidth() +30;
        int topMargin = (DICON.getIntrinsicHeight() / lineHeight ) +1;

        Log.d("TOP MARGIN:", "" +topMargin);
        Log.d("line height:", "" +lineHeight);


        String text = getString (R.string.lorem_ipsum_comment);
        SpannableString SS = new SpannableString (text);
        SS.setSpan(new EntityLeadingMarginSpan2(topMargin,leftMargin),0,SS.length(),0);

        MessageView.setText ( SS ) ;
    }

    public String getFragmentMainComment() {
        return fragmentMainComment;
    }

    public void setFragmentMainComment(String fragmentMainComment) {
        this.fragmentMainComment = fragmentMainComment;
    }

//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }
}
