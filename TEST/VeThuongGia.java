/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

/**
 *
 * @author Luong Thanh Tuan
 */
import java.io.*;
public class VeThuongGia extends Ve {
    DanhSachVe dsv = new DanhSachVe();
    DanhSachChuyenBay dsCB = new DanhSachChuyenBay();
    private String maPhongCho, dichVuVIP;
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public VeThuongGia() {
        maPhongCho = "";
        dichVuVIP = "";
    }
    public VeThuongGia(String maVe, String maChuyenBay, float gia, String maPhongCho, String dichVuVIP) {
        super(maVe, maChuyenBay, gia);
        this.maPhongCho = maPhongCho;
        this.dichVuVIP = dichVuVIP;
    }
    public VeThuongGia(VeThuongGia a) {
        super((Ve) a);
        maPhongCho = a.maPhongCho;
        dichVuVIP = a.dichVuVIP;
    }
    // GET AND SET
    public String getMaPhongCho() {
        return maPhongCho;
    }

    public void setMaPhongCho(String maPhongCho) {
        this.maPhongCho = maPhongCho;
    }

    public String getDichVuVIP() {
        return dichVuVIP;
    }

    public void setDichVuVIP(String dichVuVIP) {
        this.dichVuVIP = dichVuVIP;
    }
    // INPUT
    @Override
    public void nhap() {
        do {
            System.out.println("Ma Ve, Toi Thieu 3 Ki Tu Va Toi Da 5 Ki Tu: ");
            System.out.println("Nhap Ma Ve: ");
            maVe = sc.nextLine();
            if(maVe.length() < 3 || maVe.length() > 5) {
                System.err.println("Nhap Thieu Hoac Thua Ki Tu, Hay Nhap Lai!!!");
            }
        }while(maVe.length() < 3 || maVe.length() > 5);
        do {
          //  dsCB.DocFileJava("KhachHang.txt");// FILE
            dsCB.xemds();
            System.out.println("Nhap ma chuyen bay: ");
            maChuyenBay = sc.nextLine();
            if(dsCB.truyenDuLieu_CB(maChuyenBay) == null)
                System.out.println("Ma chuyen bay vua nhap khong co trong danh sach");
        }while(dsCB.truyenDuLieu_CB(maChuyenBay) == null);
        
        System.out.println("Gia Tien Cua Ve(VND): ");
        gia = sc.nextFloat();
        sc.nextLine();
        do {
            System.out.println("Ma Phong Cho, Toi Thieu 3 Ki Tu Va Toi Da 5 Ki Tu: ");
            System.out.println("Nhap Ma Phong Cho: ");
            maPhongCho = sc.nextLine();
            if(maPhongCho.length() < 3 || maPhongCho.length() > 5) {
                System.err.println("Nhap Thieu Hoac Thua Ki Tu, Hay Nhap Lai!!!");
            }
        }while(maPhongCho.length() < 3 || maPhongCho.length() > 5);
        
        System.out.println("Dich Vu VIP: ");
        dichVuVIP = sc.nextLine();
    }
    // OUTPUT
    @Override
    public void xuat() {
        System.out.format("| %-8s | %-8s | %-8.2f | %-9s | %-8s\n", maVe, maChuyenBay, gia, maPhongCho, dichVuVIP);

    }
    // FILE
    @Override
	public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		int code = 0;
		dos.writeInt(code);
		dos.writeUTF(maVe);
		dos.writeUTF(maChuyenBay);
		dos.writeFloat(gia);
                dos.writeUTF(maPhongCho);
                dos.writeUTF(dichVuVIP);
		dos.close();
	}

}
