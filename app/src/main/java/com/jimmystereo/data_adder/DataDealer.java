package com.jimmystereo.data_adder;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DataDealer extends AppCompatActivity {
    public boolean checkData(){
        EditText type,name,difficulty,least_people,people_per_ball,other;
        type = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.name);
        difficulty = (EditText) findViewById(R.id.difficulty);
        least_people = (EditText) findViewById(R.id.least_people);
        people_per_ball = (EditText) findViewById(R.id.people_per_ball);
        other = (EditText) findViewById(R.id.other);
        if (type.getText()==null||name.getText()==null||difficulty.getText()==null||least_people.getText()==null||people_per_ball.getText()==null||other.getText()==null){
            return false;
        }
        if (!difficulty.getText().equals("低")||!difficulty.getText().equals("中")||!difficulty.getText().equals("高")){
            return false;
        }
        try{int a = Integer.parseInt(least_people.getText().toString());}
        catch (Exception e){
            Toast.makeText(DataDealer.this, "最少人數格式錯誤", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{int a = Integer.parseInt(people_per_ball.getText().toString());}
        catch (Exception e){
            Toast.makeText(DataDealer.this, "人數/球數格式錯誤", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    }
