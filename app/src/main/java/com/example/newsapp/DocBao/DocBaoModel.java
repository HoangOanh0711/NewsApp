package com.example.newsapp.DocBao;

public class DocBaoModel {
    String chude,tieude1,tgian,tieude2,ndung,tacgia,anhbao;

    public DocBaoModel(String chude, String tieude1, String tgian, String tieude2, String ndung, String tacgia, String anhbao) {
        this.chude = chude;
        this.tieude1 = tieude1;
        this.tgian = tgian;
        this.tieude2 = tieude2;
        this.ndung = ndung;
        this.tacgia = tacgia;
        this.anhbao = anhbao;
    }

    public String getChude() {
        return chude;
    }

    public void setChude(String chude) {
        this.chude = chude;
    }

    public String getTieude1() {
        return tieude1;
    }

    public void setTieude1(String tieude1) {
        this.tieude1 = tieude1;
    }

    public String getTgian() {
        return tgian;
    }

    public void setTgian(String tgian) {
        this.tgian = tgian;
    }

    public String getTieude2() {
        return tieude2;
    }

    public void setTieude2(String tieude2) {
        this.tieude2 = tieude2;
    }

    public String getNdung() {
        return ndung;
    }

    public void setNdung(String ndung) {
        this.ndung = ndung;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getAnhbao() {
        return anhbao;
    }

    public void setAnhbao(String anhbao) {
        this.anhbao = anhbao;
    }
}
