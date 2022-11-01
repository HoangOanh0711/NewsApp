package com.example.newsapp.Card;

public class XuHuongModel {
    String tieude,tgiandangbai,anhbao,tgianvid;

    public XuHuongModel(String tieude, String tgiandangbai, String anhbao, String tgianvid) {
        this.tieude = tieude;
        this.tgiandangbai = tgiandangbai;
        this.anhbao = anhbao;
        this.tgianvid = tgianvid;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getTgiandangbai() {
        return tgiandangbai;
    }

    public void setTgiandangbai(String tgiandangbai) {
        this.tgiandangbai = tgiandangbai;
    }

    public String getAnhbao() {
        return anhbao;
    }

    public void setAnhbao(String anhbao) {
        this.anhbao = anhbao;
    }

    public String getTgianvid() {
        return tgianvid;
    }

    public void setTgianvid(String tgianvid) {
        this.tgianvid = tgianvid;
    }
}
