package com.example.newsapp.Thoitiet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class thoitiet extends AppCompatActivity {
    RecyclerView rcvThoitiet1, rcvThoitiet2;
    Thoitiet1_Adapter thoitiet1_adapter;
    Thoitiet2_Adapter thoitiet2_adapter;
    ImageView danhsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoitiet);

        danhsach = findViewById(R.id.img_danhsach_thoitiet);

        rcvThoitiet1 = findViewById(R.id.recycler_ngang_thoitiet);
        thoitiet1_adapter = new Thoitiet1_Adapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        rcvThoitiet1.setLayoutManager(linearLayoutManager1);

        thoitiet1_adapter.setMthoitiet1(getList_thoitiet1());
        rcvThoitiet1.setAdapter(thoitiet1_adapter);

        rcvThoitiet2 = findViewById(R.id.recycler_doc_thoitiet);
        thoitiet2_adapter = new Thoitiet2_Adapter(this);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvThoitiet2.setLayoutManager(linearLayoutManager2);

        thoitiet2_adapter.setMthoitiet2(getList_thoitiet2());
        rcvThoitiet2.setAdapter(thoitiet2_adapter);

        danhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thoitiet.this, quanlydiaphuong.class);
                startActivity(intent);
            }
        });
    }

    private List<Thoitiet1> getList_thoitiet1() {
        List<Thoitiet1> list = new ArrayList<>();
        list.add(new Thoitiet1("13h","32??C",R.drawable.img_cloudy_day));
        list.add(new Thoitiet1("14h","32??C",R.drawable.img_cloud));
        list.add(new Thoitiet1("15h","32??C",R.drawable.img_cloudy_day));
        list.add(new Thoitiet1("16h","32??C",R.drawable.img_cloud));
        list.add(new Thoitiet1("17h","32??C",R.drawable.img_hail));
        list.add(new Thoitiet1("18h","32??C",R.drawable.img_cloudy_day));
        list.add(new Thoitiet1("19h","32??C",R.drawable.img_cloudy_day));
        list.add(new Thoitiet1("14h","32??C",R.drawable.img_cloud));
        list.add(new Thoitiet1("15h","32??C",R.drawable.img_cloudy_day));
        list.add(new Thoitiet1("16h","32??C",R.drawable.img_cloud));
        list.add(new Thoitiet1("17h","32??C",R.drawable.img_hail));
        list.add(new Thoitiet1("18h","32??C",R.drawable.img_cloudy_day));

        return list;
    }

    private List<Thoitiet2> getList_thoitiet2() {
        List<Thoitiet2> list = new ArrayList<>();
        list.add(new Thoitiet2("H??m nay, ng??y 18/10","32??/24??","Nhi???u m??y",R.drawable.img_cloudy_day));
        list.add(new Thoitiet2("Th??? t??, ng??y 19/10","32??/24??","M??a gi??ng v??o bu???i chi???u",R.drawable.img_hail));
        list.add(new Thoitiet2("Th??? n??m, ng??y 20/10","32??/24??","Nhi???u m??y",R.drawable.img_cloudy_day));
        list.add(new Thoitiet2("H??m nay, ng??y 18/10","32??/24??","Nhi???u m??y",R.drawable.img_cloud));
        list.add(new Thoitiet2("H??m nay, ng??y 18/10","32??/24??","Nhi???u m??y",R.drawable.img_hail));
        list.add(new Thoitiet2("H??m nay, ng??y 18/10","32??/24??","Nhi???u m??y",R.drawable.img_cloud));
        list.add(new Thoitiet2("H??m nay, ng??y 18/10","32??/24??","Nhi???u m??y",R.drawable.img_cloudy_day));

        return list;
    }
}