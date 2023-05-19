package com.example.studentsdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.students = students;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.name.setText(student.getLastName() + " " + student.getName());
        holder.group.setText(student.getGroup());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, group;
        FloatingActionButton editButton, deleteButton;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.studentName);
            group = view.findViewById(R.id.studentGroup);
        }
    }
}
