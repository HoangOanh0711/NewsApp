package com.example.newsapp.Thoitiet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class quanlydiaphuong extends AppCompatActivity {
    LinearLayout btn_themdiaphuong;
    ImageView btn_quaylai;

    RecyclerView rcvThoitiet3;
    Thoitiet3_Adapter thoitiet3_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlydiaphuong);

        khaibao();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Địa phương đã chọn");
            Log.e("Địa phương đã chọn",value);
        }

        rcvThoitiet3 = findViewById(R.id.recyclerView_quanlydiaphuong);
        thoitiet3_adapter = new Thoitiet3_Adapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvThoitiet3.setLayoutManager(linearLayoutManager1);

        thoitiet3_adapter.setMthoitiet3(getList_thoitiet1());
        rcvThoitiet3.setAdapter(thoitiet3_adapter);

        btn_themdiaphuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quanlydiaphuong.this, chonthanhpho.class);
                startActivity(intent);
            }
        });

        btn_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quanlydiaphuong.this, thoitiet.class);
                startActivity(intent);
            }
        });
    }

    private List<Thoitiet3> getList_thoitiet1() {
        List<Thoitiet3> list = new ArrayList<>();
        list.add(new Thoitiet3("TP. Hồ Chí Minh","Nhiều mây","32ºC",R.drawable.img_cloudy_day));
        list.add(new Thoitiet3("TP. Hồ Chí Minh","Nhiều mây","32ºC",R.drawable.img_cloudy_day));
        list.add(new Thoitiet3("TP. Hồ Chí Minh","Nhiều mây","32ºC",R.drawable.img_cloudy_day));
        return list;
    }

    private void khaibao() {
        btn_themdiaphuong = findViewById(R.id.btn_themdiaphuong);
        btn_quaylai = findViewById(R.id.img_quaylai_quanlydiaphuong);
    }
}