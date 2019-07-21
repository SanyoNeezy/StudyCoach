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
        new insertCategoryAsyncTask(mCategoryDao).execute(category);
    }
    public void deleteCategory (Entity_Category category){
        new deleteCategoryAsyncTask(mCategoryDao).execute(category);
    }


    private static class insertCategoryAsyncTask extends AsyncTask<Entity_Category, Void, Void> {
        private CategoryDao categoryDao;
        insertCategoryAsyncTask(CategoryDao dao) {
            categoryDao = dao;
        }
        @Override
        protected Void doInBackground(final Entity_Category... categories) {
            categoryDao.insert(categories[0]);
            return null;
        }
    }


    private static class deleteCategoryAsyncTask extends AsyncTask<Entity_Category, Void, Void> {
        private CategoryDao categoryDao;
        deleteCategoryAsyncTask(CategoryDao dao) {
            categoryDao = dao;
        }
        @Override
        protected Void doInBackground(final Entity_Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }
}