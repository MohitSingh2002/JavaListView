package com.example.javalistviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.javalistviewtest.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        showSimpleListView();

//        showCustomListView();

        customListView();

    }

    void showSimpleListView() {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            arrayList.add(i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        binding.listView.setAdapter(arrayAdapter);

    }

    void showCustomListView() {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            arrayList.add(i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(MainActivity.this, R.layout.card_list, R.id.text, arrayList);
        binding.listView.setAdapter(arrayAdapter);
    }

    void customListView() {
        List<Employee> employees = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            if(i%2 == 0) {
                Employee employee = new Employee(i, "Mohit");
                employees.add(employee);
            } else {
                Employee employee = new Employee(i, "Singh");
                employees.add(employee);
            }
        }

        CustomList customList = new CustomList(MainActivity.this, R.layout.custom_list_card, employees);

        binding.listView.setAdapter(customList);

    }

}
