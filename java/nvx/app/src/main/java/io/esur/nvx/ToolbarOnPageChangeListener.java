package io.esur.nvx;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

class ToolbarOnPageChangeListener extends ViewPager.SimpleOnPageChangeListener {

    private ImageView firstIconLeft, secondIconLeft, thirdIconLeft;
    private ImageView firstIconRight, secondIconRight, thirdIconRight;
    private int toolbarAnimTime = 280;

    // ugly. fix it. this is just to see whether animation is good enough. later - should be fluent fade.
    ToolbarOnPageChangeListener(MainActivity mainActivity) {
        firstIconLeft = (ImageView) mainActivity.findViewById(R.id.first_icon);
        secondIconLeft = (ImageView) mainActivity.findViewById(R.id.second_icon);
        thirdIconLeft = (ImageView) mainActivity.findViewById(R.id.third_icon);

        // really bad - need to review animations
        firstIconRight = (ImageView) mainActivity.findViewById(R.id.first_icon_right);
        secondIconRight = (ImageView) mainActivity.findViewById(R.id.second_icon_right);
        thirdIconRight = (ImageView) mainActivity.findViewById(R.id.third_icon_right);

        firstIconLeft.setAlpha(0.0f);
        firstIconRight.setAlpha(0.0f);
        secondIconLeft.setAlpha(0.0f);
        thirdIconLeft.setAlpha(0.0f);
    }

    private void pageFadeOut(ImageView imageView){
        imageView.animate().alpha(0.0f).setDuration(toolbarAnimTime);
    }

    private void pageFadeIn (ImageView imageView){
        imageView.animate().alpha(1.0f).setDuration(toolbarAnimTime);
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);

        if (position == 0) {
            pageFadeOut(firstIconLeft);
            pageFadeOut(secondIconLeft);
            pageFadeIn(secondIconRight);
        }

        if (position == 1) {
            pageFadeIn(firstIconLeft);
            pageFadeIn(thirdIconRight);
            pageFadeOut(secondIconLeft);
            pageFadeOut(secondIconRight);
        }
        if (position == 2) {
            pageFadeIn(secondIconLeft);
            pageFadeOut(thirdIconLeft);
            pageFadeOut(thirdIconRight);
        }
    }
}
