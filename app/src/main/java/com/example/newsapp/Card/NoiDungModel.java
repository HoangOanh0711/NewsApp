package com.example.newsapp.Card;

public class NoiDungModel {
    String tieude,thoigian,anhbao;

    public NoiDungModel(String tieude, String thoigian, String anhbao) {
        this.tieude = tieude;
        this.thoigian = thoigian;
        this.anhbao = anhbao;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getAnhbao() {
        return anhbao;
    }

    public void setAnhbao(String anhbao) {
        this.anhbao = anhbao;
    }
}
