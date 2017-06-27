package io.esur.nvx;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class EntityMain {

    private final Context context;
    private String entityMainName;

    private int entityMainDescriptionLogo;
    private int entityMainDescription;
    private int leftMargin;
    private int topMargin;

    private ArrayList<Integer> entityImageNameList;
    private List<EntityImage> entityImageList;

    EntityMain(String entityName, Context context) {
        this.context = context;
        this.entityMainName = entityName;
        this.entityMainDescription = R.string.lorem_ipsum;

        // mock mock mock mock. MOCK. 4 am. MOOOOOOOOOOO
        if (Objects.equals(this.entityMainName, "mock1")) {
            this.entityMainDescriptionLogo = R.drawable.sun;
            this.leftMargin = 310;
            this.topMargin = 5;
        }
        if (Objects.equals(this.entityMainName, "mock2")) {
            this.entityMainDescriptionLogo = R.drawable.max;
            this.leftMargin = 510;
            this.topMargin = 3;
        }
        if (Objects.equals(this.entityMainName, "mock3")) {
            this.entityMainDescriptionLogo = R.drawable.hippie;
            this.leftMargin = 590;
            this.topMargin = 3;
        }
        if (Objects.equals(this.entityMainName, "mock4")) {
            this.entityMainDescriptionLogo = R.drawable.ball;
            this.leftMargin = 320;
            this.topMargin = 5;
        }

//        this.leftMargin = 350;
//        this.topMargin = 5;

//        this.leftMargin = context.getResources().
//                getDrawable(entityMainDescriptionLogo, null).getIntrinsicWidth() /9;
//        this.topMargin = context.getResources().
//                getDrawable(entityMainDescriptionLogo, null).getIntrinsicHeight() / 56 + 1;
//        this.entityMainDescription = R.string.lorem_ipsum;

        getImageSet();
        makeImageSet();
    }

    private void makeImageSet() {
        entityImageList = new ArrayList<>();

        for (Integer item : entityImageNameList) {
            entityImageList.add(new EntityImage(item));
        }
    }

    // mock
    private void getImageSet() {
        entityImageNameList = new ArrayList<>();

        entityImageNameList.add(R.drawable.house);
        entityImageNameList.add(R.drawable.hitman);
        entityImageNameList.add(R.drawable.zoe);
        entityImageNameList.add(R.drawable.rage);
    }

    public void setEntityMainDescriptionLogo(int entityMainDescriptionLogo) {
        this.entityMainDescriptionLogo = entityMainDescriptionLogo;
    }

    int getEntityMainDescriptionLogo() {
        return entityMainDescriptionLogo;
    }

    int getEntityMainDescription() {
        return entityMainDescription;
    }

    //    SpannableString getEntityMainDescription() {
//        String text = context.getResources().getString(R.string.lorem_ipsum);
//        SpannableString SS = new SpannableString(text);
//        Log.d("OMG:", "topMargin: "+ topMargin + " leftMargin: " +leftMargin);
//        SS.setSpan(new EntityLeadingMarginSpan2(topMargin,leftMargin),0,SS.length(),0);
//
//        return SS;
//    }

    List<EntityImage> getEntityImageList() {
        return entityImageList;
    }
}

/*
package io.esur.nvx;

import android.content.Context;
import android.text.SpannableString;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class EntityMain {

    private final Context context;
    private String entityMainName;

    private int entityMainDescriptionLogo;
    private int entityMainDescription;
    private int leftMargin;
    private int topMargin;

    private ArrayList<Integer> entityImageNameList;
    private List<EntityImage> entityImageList;

    EntityMain(String entityName, Context context) {
        this.context = context;
        this.entityMainName = entityName;

        if (Objects.equals(this.entityMainName, "mock1")) {
            this.entityMainDescriptionLogo = R.drawable.mnk_n;
            this.leftMargin = 310;
            this.topMargin = 5;
        }
        if (Objects.equals(this.entityMainName, "mock2")) {
            this.entityMainDescriptionLogo = R.drawable.mocak_n;
            this.leftMargin = 510;
            this.topMargin = 3;
        }
        if (Objects.equals(this.entityMainName, "mock3")) {
            this.entityMainDescriptionLogo = R.drawable.louvre_n;
            this.leftMargin = 590;
            this.topMargin = 3;
        }
        if (Objects.equals(this.entityMainName, "mock4")) {
            this.entityMainDescriptionLogo = R.drawable.gugg_n;
            this.leftMargin = 320;
            this.topMargin = 5;
        }

//        this.leftMargin = 350;
//        this.topMargin = 5;

//        this.leftMargin = context.getResources().
//                getDrawable(entityMainDescriptionLogo, null).getIntrinsicWidth() /9;
//        this.topMargin = context.getResources().
//                getDrawable(entityMainDescriptionLogo, null).getIntrinsicHeight() / 56 + 1;
//        this.entityMainDescription = R.string.lorem_ipsum;

        getImageSet();
        makeImageSet();
    }

    private void makeImageSet() {
        entityImageList = new ArrayList<>();

        for (Integer item : entityImageNameList) {
            entityImageList.add(new EntityImage(item));
        }
    }

    private void getImageSet() {
        entityImageNameList = new ArrayList<>();

        entityImageNameList.add(R.drawable.house);
        entityImageNameList.add(R.drawable.hitman);
        entityImageNameList.add(R.drawable.zoe);
        entityImageNameList.add(R.drawable.rage);
    }

    public void setEntityMainDescriptionLogo(int entityMainDescriptionLogo) {
        this.entityMainDescriptionLogo = entityMainDescriptionLogo;
    }

    int getEntityMainDescriptionLogo() {
        return entityMainDescriptionLogo;
    }

    SpannableString getEntityMainDescription() {
        String text = context.getResources().getString(R.string.lorem_ipsum);
        SpannableString SS = new SpannableString(text);
        Log.d("OMG:", "topMargin: "+ topMargin + " leftMargin: " +leftMargin);
        SS.setSpan(new EntityLeadingMarginSpan2(topMargin,leftMargin),0,SS.length(),0);

        return SS;
    }

    List<EntityImage> getEntityImageList() {
        return entityImageList;
    }
}
 */