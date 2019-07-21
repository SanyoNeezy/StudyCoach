package com.example.studycoach;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudyRepository {

    private CategoryDao mCategoryDao;
    private LiveData<List<Entity_Category>> mAllCategories;

    StudyRepository(Application application) {
        StudyDatabase db = StudyDatabase.getDatabase(application);
        //ToDO Check if correct #Original Code# mWordDao = db.wordDao();
        mCategoryDao = db.categoryDao();
        mAllCategories = mCategoryDao.getAllCategories();
    }

    LiveData<List<Entity_Category>> getAllCategories() {
        return mAllCategories;
    }


    public void insert (Entity_Category category) {
        new insertAsyncTask(mCategoryDao).execute(category);
    }

    private static class insertAsyncTask extends AsyncTask<Entity_Category, Void, Void> {

        private CategoryDao mAsyncTaskDao;

        insertAsyncTask(CategoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Entity_Category... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}