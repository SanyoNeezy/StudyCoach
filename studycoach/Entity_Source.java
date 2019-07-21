package com.example.studycoach;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Source")
public class Entity_Source {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String value;

    private int categoryId;

    public Entity_Source(@NonNull String value){
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public String getValue(){
        return value;
    }
}
