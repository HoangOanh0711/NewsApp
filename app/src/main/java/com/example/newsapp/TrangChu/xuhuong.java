package com.example.newsapp.TrangChu;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.newsapp.Card.CardTrangChu_Adapter;
import com.example.newsapp.Card.CardXuHuong_Adapter;
import com.example.newsapp.Card.ClickItem;
import com.example.newsapp.Card.ClickItem1;
import com.example.newsapp.Card.NoiDungModel;
import com.example.newsapp.Card.XuHuongModel;
import com.example.newsapp.DocBao.docbao;
import com.example.newsapp.DocBao.docbaovideo;
import com.example.newsapp.R;
import com.example.newsapp.TinTuc.fg_moi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class xuhuong extends Fragment {
    private View view;

    private RecyclerView recyclerView;
    private CardXuHuong_Adapter cardXuHuong_adapter;
    private List<XuHuongModel> xuHuongModelList = new ArrayList<>();
    Elements data;
    Document document;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_xuhuong, container, false);
        recyclerView = view.findViewById(R.id.recycler_fg_xuhuong);

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
            cardXuHuong_adapter = new CardXuHuong_Adapter((ArrayList<XuHuongModel>) xuHuongModelList, new ClickItem1() {
                @Override
                public void onClickItem(XuHuongModel xuHuongModel) {
                    Intent intentgiavang = new Intent(getActivity(), docbaovideo.class);
                    startActivity(intentgiavang);
                }
            });
            recyclerView.setAdapter(cardXuHuong_adapter);
            cardXuHuong_adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String url = "https://tv.tuoitre.vn/";
                document = Jsoup.connect(url).get();
                data = document.select("div.box-highlight").select("ul").select("li.autonext-item");
                int size = data.size();
                for (int i=0; i<size;i++) {
                    String tieude = data.select("a.name-video-list").eq(i).text();
                    String tgiandangbai = data.select("b.time-ago").eq(i).text();
                    String anhbao = data.select("a.item").eq(i).select("img").attr("src");
                    String tgianvid = data.select("span.duration-video").eq(i).text();
                    String linkbao = data.select("a.img212x132.pos-rlt").eq(i).text();
                    Log.e("link bao",linkbao);
                    xuHuongModelList.add(new XuHuongModel(tieude,tgiandangbai,anhbao,tgianvid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}