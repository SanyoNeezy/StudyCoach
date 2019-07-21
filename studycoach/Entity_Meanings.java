package com.example.studycoach;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meanings")
public class Entity_Meanings {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String value;

    private int sourceId;
    private int studyItemId;

    public Entity_Meanings(@NonNull String value){
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public String getValue(){
        return value;
    }
}
