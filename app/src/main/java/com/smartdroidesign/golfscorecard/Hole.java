package com.smartdroidesign.golfscorecard;

public class Hole {
    private String mLabel;
    private int mStrokeCount;

    public Hole(String mLabel, int mStrokeCount) {
        this.mLabel = mLabel;
        this.mStrokeCount = mStrokeCount;
    }

    public String getmLabel() {
        return mLabel;
    }

    public void setmLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public int getmStrokeCount() {
        return mStrokeCount;
    }

    public void setmStrokeCount(int mStrokeCount) {
        this.mStrokeCount = mStrokeCount;
    }
}
