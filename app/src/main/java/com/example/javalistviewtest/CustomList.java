package com.example.javalistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.javalistviewtest.databinding.CustomListCardBinding;

import java.util.List;

public class CustomList extends ArrayAdapter<Employee> {

    private final Context context;
    private final List<Employee> employees;

    public CustomList(@NonNull Context context, int resource, @NonNull List<Employee> objects) {
        super(context, resource, objects);

        this.context = context;
        this.employees = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomListCardBinding b;
        if (convertView == null) {
            b = CustomListCardBinding.inflate(LayoutInflater.from(context));
            convertView = b.getRoot();
        } else {
            b = CustomListCardBinding.bind(convertView);
        }
        Employee employee = employees.get(position);
        b.index.setText(""+employee.id);
        b.name.setText(""+employee.name);

        return convertView;
    }

}
