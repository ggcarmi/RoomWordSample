package com.example.gaicarmi.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by gaicarmi on 2/10/18.
 *
 *  this class represent the database (singelton)
 *
 *  Room database: Database layer on top of SQLite database that takes care of mundane tasks
 *  that you used to handle with an SQLiteOpenHelper. Database holder that serves as an
 *  access point to the underlying SQLite database. The Room database uses the DAO to issue
 *  queries to the SQLite database.
 *
 */

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase INSTANCE;
    public abstract WordDao wordDao();

    public static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // create database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}





