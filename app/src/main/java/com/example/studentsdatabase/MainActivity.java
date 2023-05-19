package com.example.studentsdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentsdatabase.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    ActivityMainBinding binding;
    FloatingActionButton addStudentsButton;
    AddStudentsFragment addStudentsFragment = new AddStudentsFragment();
    ArrayList<Student> students = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DBHelper(this);

        recyclerView = binding.recyclerView;

        addStudentsButton = binding.addStudentButton;
        addStudentsButton.setOnClickListener(this);

        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

        getStudents();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addStudentButton) {
            findViewById(R.id.recyclerView).setVisibility(View.INVISIBLE);
            setNewFragment(addStudentsFragment);
        }
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameStudentsLayout, fragment);
        ft.commit();
    }

    public void getStudents() {
        for (Student student : dbHelper.getAll()) {
            students.add(student);
        }
    }
}