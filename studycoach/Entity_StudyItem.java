package com.example.studycoach;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudyItem")
public class Entity_StudyItem{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String value;

    private int sourceId;

    public Entity_StudyItem(@NonNull String value){
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public String getValue(){
        return value;
    }
}
