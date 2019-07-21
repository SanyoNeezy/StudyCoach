package com.example.studycoach;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDao  {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Entity_Category category);
    @Delete
    void delete(Entity_Category category);
    @Query("SELECT * from category ORDER BY value asc" )
    LiveData<List<Entity_Category>> getAllCategories();
}
