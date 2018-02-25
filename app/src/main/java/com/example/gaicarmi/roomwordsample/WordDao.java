package com.example.gaicarmi.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by gaicarmi on 2/9/18.
 *
 *  this interface is the way to connect between the code and the database
 *
 *  DAO: Data access object. A mapping of SQL queries to functions.
 *  You used to have to define these painstakingly in your SQLiteOpenHelper class.
 *  When you use a DAO, you call the methods, and Room takes care of the rest.
 *
 *  In the DAO (data access object), you specify SQL queries and associate them with method calls.
 *  The compiler checks the SQL and generates queries from convenience annotations
 *  for common queries, such as @Insert.
 */

@Dao
public interface WordDao {

    // we need to handle conflict strategy - for duplicate item
    // @Insert(onConflict = OnConflictStrategy.REPLACE)

    @Insert // or @Delete or @Update
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();


}

