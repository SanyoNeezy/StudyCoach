package com.example.studycoach;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudyViewModel extends AndroidViewModel {

    private StudyRepository mRepository;
    private LiveData<List<Entity_Category>> allCategories;
    //private LiveData<List<Entity_Source>> allSources;

        public StudyViewModel(Application application/*, Class type*/){
            super(application);
            mRepository = new StudyRepository(application);
            /*if (type == Entity_Category.class){*/
                allCategories = mRepository.getAllCategories();
            /*}else if (type ==Entity_Source.class){
                //ToDo:allSources = mRepository.getAllSources();
            }*/

        }

    LiveData<List<Entity_Category>> getAllCategories() { return allCategories; }
    public void insert (Entity_Category category){
            mRepository.insert(category);
    }


    public void deleteCategory(Entity_Category category){
            mRepository.deleteCategory(category);
        }
}
