package com.example.task_1_grocery_items;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity2 extends AppCompatActivity {
    ListView lv;

    String[] items = new String[] {
            "Apple",
            "Banana",
            "Bread",
            "Celery",
            "Cheese",
            "Egg",
            "Ginger",
            "Milk",
            "Mushrooms",
            "Oil",
            "Orange",
            "Tea",
            "Tomatoes",
            "Turmeric",
            "Yogurt"
    };
    int[] grocery_items = new int[]{
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.bread,
            R.drawable.celery,
            R.drawable.cheese,
            R.drawable.egg,
            R.drawable.ginger,
            R.drawable.milk,
            R.drawable.mushrooms,
            R.drawable.oil,
            R.drawable.orange,
            R.drawable.tea,
            R.drawable.tomatoes,
            R.drawable.turmeric,
            R.drawable.yogurt
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        lv = (ListView) findViewById(R.id.lv);
        ArrayList<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<15;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("ite",items[i]);
            hm.put("flag", Integer.toString(grocery_items[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"ite","flag"};

        // Ids of views in listview_layout
        int[] to = { R.id.item, R.id.flag};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

        lv.setAdapter(simpleAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long arg3) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
            }
        });


    }
}
