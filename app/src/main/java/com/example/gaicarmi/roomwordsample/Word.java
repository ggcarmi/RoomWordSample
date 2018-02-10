package com.example.gaicarmi.roomwordsample;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by gaicarmi on 2/9/18.
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

//    @PrimaryKey(autoGenerate = true)
//    private int id;

    public Word(@NonNull String word){ this.mWord = word; }

    public String getWord(){
        return this.mWord;
    }
}
