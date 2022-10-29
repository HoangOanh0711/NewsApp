package com.example.newsapp.TinTuc;

import static android.content.ContentValues.TAG;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Card.CardTrangChu_Adapter;
import com.example.newsapp.Card.NoiDungModel;
import com.example.newsapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class fg_thoisu extends Fragment {
    private View view;

    private RecyclerView recyclerView;
    private CardTrangChu_Adapter cardTrangChu_adapter;
    private List<NoiDungModel> noiDungModelList = new ArrayList<>();
    Elements data;
    Document document;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fg_thoisu, container, false);
        recyclerView = view.findViewById(R.id.recycler_fg_thoisu);

        cardTrangChu_adapter = new CardTrangChu_Adapter((ArrayList<NoiDungModel>) noiDungModelList,this);
        Content content = new Content();
        content.execute();

        return view;
    }

    private class Content extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            cardTrangChu_adapter = new CardTrangChu_Adapter((ArrayList<NoiDungModel>) noiDungModelList, fg_thoisu.this);
            recyclerView.setAdapter(cardTrangChu_adapter);
            cardTrangChu_adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            /*try {
                String url = "https://tuoitre.vn/thoi-su.htm";
                document = Jsoup.connect(url).get();
                data = document.select("ul.list-news-content").select("li.news-item");
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    String tieude = data.select("h3.title-news").eq(i).text();
                    String thoigian = data.select("p.sapo").eq(i).text();
                    String anhbao = data.select("a.img212x132.pos-rlt").eq(i).select("img").attr("src");
                    noiDungModelList.add(new NoiDungModel(tieude, thoigian, anhbao));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            try {
                String url = "https://tv.tuoitre.vn/";
                document = Jsoup.connect(url).get();
                data = document.select("div.list-video.box-highlight").select("li.clsVideo.autonext-item.count-processed");
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    Log.e(TAG,"OK");
                    String tieude = data.select("h3").eq(i).select("a.name-video-list").text();
                    String thoigian = data.select("p.sapo").eq(i).text();
                    String anhbao = data.select("a.item").eq(i).select("img").attr("src");
                    Log.e("anhbao",tieude.toString());
                    //noiDungModelList.add(new NoiDungModel(tieude, thoigian, anhbao));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}