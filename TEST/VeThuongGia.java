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
    //DanhSachChuyenBay dsCB = new DanhSachChuyenBay();
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
    public void Nhap() {
        do {
			System.out.println("Khi nhap ma ve, toi thieu 3 ki tu va toi da 5 ki tu:");
			System.out.print("MMoi nhap ma Ve: ");
			maVe = sc.nextLine();
			if(maVe.length() < 3 || maVe.length() > 5) 
				System.err.println("Ban nhap thua haoc thieu ki tu moi nhap lai!!!");
		}while(maVe.length() < 3 || maVe.length() > 5);
		
		
		// KHOA NGOAI
//		do {
//			dsCB.DocFileJava("ChuyenBay.txt");
//			dsCB.XuatDanhSach();
//			System.out.print("Nhap ma chuyen bay: ");
//			dsCB = sc.nextLine();
//			if(dsCB.TruyenDuLieu_CB(maChuyenBay) == null)
//				System.err.println("\nMa chuyen bay khong hop le hoac khong cho trong danh sach!!!");
//		}while(dsCB.TruyenDuLieu_CB(maChuyenBay) == null);

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
        
        System.out.println("Gia Tien Cua Ve(VND): ");
        gia = sc.nextFloat();
    }
    // OUTPUT
    @Override
    public void Xuat() {
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
