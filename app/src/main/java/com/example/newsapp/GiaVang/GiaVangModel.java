package com.example.newsapp.GiaVang;

public class GiaVangModel {
    String giatienmua,tangmua,phantrammua,giatienban,tangban,phantramban;

    public GiaVangModel(String giatienmua, String tangmua, String phantrammua, String giatienban, String tangban, String phantramban) {
        this.giatienmua = giatienmua;
        this.tangmua = tangmua;
        this.phantrammua = phantrammua;
        this.giatienban = giatienban;
        this.tangban = tangban;
        this.phantramban = phantramban;
    }

    public String getGiatienmua() {
        return giatienmua;
    }

    public void setGiatienmua(String giatienmua) {
        this.giatienmua = giatienmua;
    }

    public String getTangmua() {
        return tangmua;
    }

    public void setTangmua(String tangmua) {
        this.tangmua = tangmua;
    }

    public String getPhantrammua() {
        return phantrammua;
    }

    public void setPhantrammua(String phantrammua) {
        this.phantrammua = phantrammua;
    }

    public String getGiatienban() {
        return giatienban;
    }

    public void setGiatienban(String giatienban) {
        this.giatienban = giatienban;
    }

    public String getTangban() {
        return tangban;
    }

    public void setTangban(String tangban) {
        this.tangban = tangban;
    }

    public String getPhantramban() {
        return phantramban;
    }

    public void setPhantramban(String phantramban) {
        this.phantramban = phantramban;
    }
}
