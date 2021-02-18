package com.android.example.wordlistsql;

public class WordItem {
    private int mId;
    private String mWord;
    private String definition;

    public WordItem() {
    }

    //<editor-fold desc="Getters and Setters">
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmWord() {
        return mWord;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    //</editor-fold>


}
