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
import com.bumptech.glide.Glide;
import com.example.newsapp.Card.CardTrangChu_Adapter;
import com.example.newsapp.Card.ClickItem;
import com.example.newsapp.Card.NoiDungModel;
import com.example.newsapp.R;
import com.example.newsapp.TinTuc.fg_moi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class docbao extends AppCompatActivity {
    String linkbao,chude,tieude1,tgian,tieude2,anhbao,ndung,tacgia;

    TextView txt_chude,txt_tieude1,txt_tgian,txt_tieude2,txt_ghichuanh,txt_ndung,txt_tacgia;
    RecyclerView rcv_lienquan;
    ImageView img_quaylai, img_anhbao;

    Elements data;
    Document document;

    DocBaoModel docBaoModel;
    private List<DocBaoModel> listthongtin = new ArrayList();

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

    private void gangiatri() {
        txt_chude.setText(chude);
        txt_tieude1.setText(tieude1);
        txt_tgian.setText(tgian);
        txt_tieude2.setText(tieude2);
        txt_ndung.setText(ndung);
        txt_tacgia.setText(tacgia);
        Glide.with(img_anhbao).load(anhbao).into(img_anhbao);
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
                Log.e("url", url);
                document = Jsoup.connect(url).get();
                data = document.select("div.content");

                String chude = data.select("div.content-left>div.bread-crumbs>ul>li.fl").eq(0).select("a").text();
                txt_chude.setText(chude);
                Log.e("chude", chude);

                //txt_tieude1,txt_tgian,txt_tieude2,txt_ghichuanh,txt_ndung,txt_tacgia

                String tieude1 = data.select("div.content-detail>div.w980>h1.article-title").text();
                //txt_tieude1.setText(tieude1);
                Log.e("tieu1",tieude1);

                String tgian = data.select("div.content-detail>div.w980>div.date-time").text();
                //txt_tgian.setText(tgian);
                Log.e("time",tgian);

                String tieude2 = data.select("div.column-first-second>div.main-content-body>h2.sapo").text();
                //txt_tieude2.setText(tieude2);
                Log.e("tieu2",tieude2);


                //int size = data.select("div.column-first-second>div.main-content-body>div.content").size();


                String anhbao = data.select("div.column-first-second>div.main-content-body>div.content").select("div.VCSortableInPreviewMode[type='photo']").select("img").attr("src");
                //img_anhbao.setAnhbao(anhbao);
                Log.e("anh",anhbao);

                String ndung = data.select("div.column-first-second>div.main-content-body>div.content>p").text();
                //txt_ndung.setText(ndung);
                Log.e("ndung",ndung);
//                    for (int i=0; i<size;i++) {
//                        Log.e("i", String.valueOf(0));
//
////                        if (data.select("div.main-content-body").select("div.content").select("p.VCObjectBoxRelatedNewsItemSapo").eq(i).text()!="") {
////                            continue;
////                        }
//
//                        if (data.select("div.main-content-body").select("div.content").select("div.VCSortableInPreviewMode").select("a.detail-img-lightbox").eq(i).select("img").attr("src")!=""){
//                            String anhbao = data.select("div.main-content-body").select("div.content").select("div.VCSortableInPreviewMode").eq(0).select("img").attr("src");
//                            //img_anhbao.setAnhbao(anhbao);
//                            //Glide.with(img_anhbao).load(anhbao).into(img_anhbao);
//                            Log.e("anh",anhbao);
//                        }
//
////                        if (data.select("div.main-content-body").select("div.content").select("p").eq(i).text()!=""){
////                            String ndung1 = data.select("div.main-content-body").select("div.content").select("p").eq(i).text();
////                            //txt_ndung.setText(ndung1);
////                            Log.e("ndung1",ndung1);
////                        }
//                        if (data.select("div.main-content-body").select("div.content").eq(i).select("span").text()!=""){
//                            String ndung2 = data.select("div.main-content-body").select("div.content").eq(0).select("span").text();
//                            //txt_ndung.setText(ndung2);
//                            Log.e("ndung2",ndung2);
//                        }
//
////                        if (data.select("div.main-content-body").select("div.content").select("div.VCSortableInPreviewMode").eq(i).select("p.VCObjectBoxRelatedNewsItemSapo").text()!="") {
////                            break;
////                        }
//
//
//                    }

                String tacgia = data.select("div.column-first-second>div.main-content-body>div.author").text();
                //txt_tacgia.setText(tacgia);
                Log.e("tacgia",tacgia);


            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}