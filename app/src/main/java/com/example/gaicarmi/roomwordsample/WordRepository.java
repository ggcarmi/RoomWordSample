package com.example.gaicarmi.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by gaicarmi on 2/25/18.
 */

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    public void insert(Word word){
        new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao asyncTaskDao;

        insertAsyncTask(WordDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            asyncTaskDao.insert(words[0]);
            return null;
        }
    }
}

