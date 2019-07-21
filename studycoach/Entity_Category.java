package com.example.studycoach;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "category")
public class Entity_Category   {
    @PrimaryKey//(autoGenerate = true)
    private int id;
    @NonNull
    private String value;

    public void setId (Integer id){
        this.id = id;
    }

    //ToDo: soll ich wirklich im Konstruktor die ID übergeben??
    public Entity_Category(@NonNull String value, int id){

        this.value = value;
        this.id = id;
        //
    }



    public int getId(){
        return id;
    }

    public String getValue(){
        return value;
    }
}
