package e.pramu.craftmall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NotifikasiActivity extends AppCompatActivity{
TextView TV;
private ArrayList<String> NA;
ListView listView;
ListViewAdapterNotifikasi LVadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);
        TV = findViewById(R.id.textViewNotifikasi);
        listView = findViewById(R.id.listnotifikasi);
        NA = new ArrayList<>();
        NA.add("aaa");
        //LVadapter = new ListViewAdapterNotifikasi(NA,this);
        listView.setAdapter(LVadapter);
    }

    }
