/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

/**
 *
 * @author Luong Thanh Tuan
 */
import java.util.Scanner;
import java.io.*;
public abstract class Ve implements Serializable {
    DanhSachChuyenBay dscb = new DanhSachChuyenBay();
    protected String maVe, maChuyenBay;
    protected float gia;
    public transient Scanner sc = new Scanner(System.in);
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public Ve() {
        maVe = "";
        maChuyenBay = "";
        gia = 0;
    }
    public Ve(String maVe, String maChuyenBay, float gia) {
        this.maChuyenBay = maChuyenBay ;
        this.maVe = maVe;
        this.gia = gia;
    }
    public Ve(Ve a) {
        maVe = a.maVe;
        maChuyenBay = a.maChuyenBay;
        gia = a.gia;
    }
    // GET AND SET
    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    
    // INPUT
    public abstract void nhap();
    public abstract void xuat();
    // OUTPUT
    public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		dos.writeUTF(maVe);
		dos.writeUTF(maChuyenBay);
		dos.writeFloat(gia);
		dos.close();
	}
}
