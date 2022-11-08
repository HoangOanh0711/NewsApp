package com.example.newsapp.DocBao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.animation.content.Content;
import com.example.newsapp.Card.CardTrangChu_Adapter;
import com.example.newsapp.Card.ClickItem;
import com.example.newsapp.Card.NoiDungModel;
import com.example.newsapp.R;
import com.example.newsapp.TinTuc.fg_moi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class docbao extends AppCompatActivity {
    String linkbao;

    TextView txt_chude,txt_tieude1,txt_tgian,txt_tieude2,txt_ghichuanh,txt_ndung,txt_tacgia;
    RecyclerView rcv_lienquan;
    ImageView img_quaylai, img_anhbao;

    Elements data;
    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docbao);

        Intent intent = getIntent();
        linkbao = intent.getStringExtra("Link báo");

        khaibao();

        Content content = new Content();
        content.execute();
    }

    private void khaibao() {
        txt_chude = findViewById(R.id.txt_chude_docbao);
        txt_tieude1 = findViewById(R.id.txt_tieude1_docbao);
        txt_tgian = findViewById(R.id.txt_tgian_docbao);
        txt_tieude2 = findViewById(R.id.txt_tieude2_docbao);
        txt_ghichuanh = findViewById(R.id.txt_ghichuanh_docbao);
        txt_ndung = findViewById(R.id.txt_noidung_docbao);
        txt_tacgia = findViewById(R.id.txt_tacgia_docbao);

        rcv_lienquan = findViewById(R.id.rcv_tinlienquan_docbao);

        img_quaylai = findViewById(R.id.img_quaylai_docbao);
        img_anhbao = findViewById(R.id.img_anhbao_docbao);
    }

    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String url = linkbao;
                document = Jsoup.connect(url).get();
                data = document.select("ul.list-news-content").select("li.news-item");
                int size = data.size();
                for (int i=0; i<size;i++) {
                    String tieude = data.select("h3.title-news").eq(i).text();
                    String thoigian = data.select("p.sapo").eq(i).text();
                    String anhbao = data.select("a.img212x132.pos-rlt").eq(i).select("img").attr("src");
                    //linkbao = data.select("a.img212x132.pos-rlt").eq(i).text();
                    Log.e("link bao",linkbao);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}