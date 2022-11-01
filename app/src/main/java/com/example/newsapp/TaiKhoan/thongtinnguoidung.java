package com.example.newsapp.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.taikhoan;
import com.example.newsapp.XoSo.xoso;

public class thongtinnguoidung extends AppCompatActivity {

    //sửa đây thành Image button luôn
    ImageButton IMG_thongtinnguoidung_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinnguoidung);
        IMG_thongtinnguoidung_back = findViewById(R.id.img_thongtinnguoidung_back);

        // gọi click này
        IMG_thongtinnguoidung_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gọi intent cho nó chuyển về á
                Intent intentTTND = new Intent(getApplicationContext(), taikhoan.class);
                startActivity(intentTTND);
             }
        });
    }
    // vậy là xong thôi
//    //Hàm quay về màn hình trước
//    public void backFromTTND(View view){
//
//        Intent intent = new Intent(getApplicationContext(), taikhoan.class);
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(findViewById(R.id.LayoutTTND),"transition_taikhoan");
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(thongtinnguoidung.this,pairs);
//            startActivity(intent,options.toBundle());
//        }else {
//            startActivity(intent);
//        }
//    }
    // muốn bôi đen thế này bạn dùng ctrl + / nha
}