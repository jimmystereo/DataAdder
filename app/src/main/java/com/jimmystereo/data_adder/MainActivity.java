package com.jimmystereo.data_adder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View view){
        EditText number,type,name,difficulty,least_people,people_per_ball,other;
        Map<String,Object> start_training_list = new HashMap<>();
        number = (EditText) findViewById(R.id.number);
        type = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.name);
        difficulty = (EditText) findViewById(R.id.difficulty);
        least_people = (EditText) findViewById(R.id.least_people);
        people_per_ball = (EditText) findViewById(R.id.people_per_ball);
        other = (EditText) findViewById(R.id.other);
        if (type.getText().equals("")||name.getText().equals("")||difficulty.getText().equals("")||least_people.getText().equals("")||people_per_ball.getText().equals("")||other.getText().equals("")){
            Toast.makeText(MainActivity.this, "please leave no blank", Toast.LENGTH_SHORT).show();
        }
        else{start_training_list.put("type",type.getText().toString().trim());
        start_training_list.put("number",number.getText().toString().trim());
        start_training_list.put("name",name.getText().toString().trim());
        start_training_list.put("difficulty",difficulty.getText().toString().trim());
        start_training_list.put("least_people",least_people.getText().toString().trim());
        start_training_list.put("ball_per_people",people_per_ball.getText().toString().trim());
        start_training_list.put("other",other.getText().toString().trim());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("start_training_list").add(start_training_list).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "upload success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        });

    }}
}
