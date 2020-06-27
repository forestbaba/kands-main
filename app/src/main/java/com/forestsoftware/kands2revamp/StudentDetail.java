package com.forestsoftware.kands2revamp;

/**
 * Created by Adeoy3 on 6/27/2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class StudentDetail extends AppCompatActivity implements View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    TextView editTextEmail;
    EditText editTextAge;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (TextView) findViewById(R.id.editTextEmail);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
//        StudentRepo repo = new StudentRepo(this);
        DbBackend repo = new DbBackend(this);

//        ItemObject student = new ItemObject();
        QuizObject itemObject = new QuizObject();

//        student = repo.getStudentById(_Student_Id);

        itemObject = repo.getQuizById(_Student_Id);


       // editTextAge.setText(String.valueOf(student.age));
        editTextName.setText(itemObject.getWord());
        editTextEmail.setText(itemObject.getDefinition());
    }



    public void onClick(View view) {
//        if (view == findViewById(R.id.btnSave)){
////            StudentRepo repo = new StudentRepo(this);
//            DbBackend repo = new DbBackend(this);
//            QuizObject student = new QuizObject();
//            student.= Integer.parseInt(editTextAge.getText().toString());
//            student.email=editTextEmail.getText().toString();
//            student.name=editTextName.getText().toString();
//            student.student_ID=_Student_Id;
//
//            if (_Student_Id==0){
//                _Student_Id = repo.insert(student);
//
//                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
//            }else{
//
//                repo.update(student);
//                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
//            }
//        }else if (view== findViewById(R.id.btnDelete)){
//            StudentRepo repo = new StudentRepo(this);
//            repo.delete(_Student_Id);
//            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
//            finish();
//        }else if (view== findViewById(R.id.btnClose)){
//            finish();
//        }
//
//
    }

}