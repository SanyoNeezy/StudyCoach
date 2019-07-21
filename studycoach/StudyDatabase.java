package com.example.studycoach;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Entity_Category.class}, version = 1, exportSchema = false)
public abstract class StudyDatabase extends RoomDatabase {

    private static volatile StudyDatabase INSTANCE;
    public abstract CategoryDao categoryDao();
    static StudyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudyDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudyDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final CategoryDao mDao;
        String[] categories = {"español","english","maths"};

        PopulateDbAsync(StudyDatabase db) {
            mDao = db.categoryDao();
        }
        @Override
        protected Void doInBackground(final Void... params) {
            Entity_Category category = new Entity_Category("Hello", 0);
            mDao.insert(category);
            /*
            Entity_Category category2 = new Entity_Category("Hello", 1);
            mDao.insert(category2);
            for (int i = 0; i <= categories.length - 1; i++) {
                Entity_Category word = new Entity_Category(categories[i], (i+2));
                mDao.insert(word);
            }*/
            return null;
        }
    }
}
