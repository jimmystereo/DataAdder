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
        final EditText number,type,name,difficulty,least_people,ball_per_people,other,amount_people,amount_ball;
        Map<String,Object> start_training_list = new HashMap<>();
        number = (EditText) findViewById(R.id.number);
        type = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.name);
        difficulty = (EditText) findViewById(R.id.difficulty);
        least_people = (EditText) findViewById(R.id.least_people);
        ball_per_people = (EditText) findViewById(R.id.ball_per_people);
        other = (EditText) findViewById(R.id.other);
        amount_ball = (EditText) findViewById(R.id.amount_ball);
        amount_people = (EditText) findViewById(R.id.amount_people);
        if (type.getText().equals("")||name.getText().equals("")||difficulty.getText().equals("")||least_people.getText().equals("")||ball_per_people.getText().equals("")||other.getText().equals("")){
            Toast.makeText(MainActivity.this, "please leave no blank", Toast.LENGTH_SHORT).show();
        }
        else{start_training_list.put("type",type.getText().toString().trim());
        start_training_list.put("number",number.getText().toString().trim());
        start_training_list.put("name",name.getText().toString().trim());
        start_training_list.put("difficulty",difficulty.getText().toString().trim());
        start_training_list.put("least_people",least_people.getText().toString().trim());
        start_training_list.put("ball_per_people",ball_per_people.getText().toString().trim());
        start_training_list.put("other",other.getText().toString().trim());
        start_training_list.put("amount_people",amount_people.getText().toString().trim());
        start_training_list.put("amount_ball",amount_ball.getText().toString().trim());
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("start_training_list").add(start_training_list).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "upload success", Toast.LENGTH_SHORT).show();
                number.setText("");name.setText("");amount_ball.setText("");amount_people.setText("");
                type.setText("");other.setText("");least_people.setText("");ball_per_people.setText("");
                difficulty.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        });

    }}
}
