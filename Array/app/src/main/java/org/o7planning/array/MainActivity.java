package org.o7planning.array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
private ListView simplelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[][] nama={{"Andik","Tomu","Timu","Teru"},{"100","200","300","400"}};
        Integer i,k;
        for(i=0;i<nama.length;i++){
            for(k=0;k<4;k++){
                System.out.println(nama[i][k]);
            }
        }
        String[] dafNama={"Andik","Tomu","Timu","Teru"};
        simplelist = findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dafNama);

        simplelist.setAdapter(arrayAdapter);

    }

}
