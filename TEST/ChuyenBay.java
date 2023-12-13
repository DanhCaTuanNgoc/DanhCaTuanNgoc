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
public final class ChuyenBay {
    DanhSachMayBay dsMB = new DanhSachMayBay();
    DanhSachSanBay dsSB = new DanhSachSanBay();
    protected String maChuyenBay, maMayBay;
    protected String maSanBay;
    private String ngayDi, ngayDen;
    private String sanBayDi, sanBayDen ;
    private String gioDi, gioDen ;
    private int tongSoVe;
    Scanner sc = new Scanner(System.in);
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public ChuyenBay() {
        maChuyenBay = "";
	maMayBay = "";
        maSanBay = "";
	ngayDi = "";
	ngayDen = "";
	tongSoVe = 0;
        sanBayDi = "" ;
        sanBayDen = "" ;
        gioDi = "" ;
        gioDen = "" ; 
    }
    public ChuyenBay(ChuyenBay a) {
        maChuyenBay = a.maChuyenBay;
	maMayBay = a.maMayBay;
        maSanBay = a.maSanBay;
	ngayDi = a.ngayDi;
	ngayDen = a.ngayDen;
        sanBayDi = a.sanBayDi;
        sanBayDen =a.sanBayDen;
        gioDi = a.gioDi;
        gioDen = a.gioDen;
	a.tongSoVe = a.tongSoVe;
    }
    // GETTER AND SETTER
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    public String getGioDi() {
        return gioDi;
    }

    public void setGioDi(String gioDi) {
        this.gioDi = gioDi;
    }

    public String getGioDen() {
        return gioDen;
    }

    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }

    public int getTongSoVe() {
        return tongSoVe;
    }

    public void setTongSoVe(int tongSoVe) {
        this.tongSoVe = tongSoVe;
    }
    // METHOD
    public void nhap() {
        do {
            System.out.println("Ma chuyen bay, toi thieu 3 ki tu va toi da 5 ki tu: ");
            System.out.println("Nhap ma chuyen bay: ");
            maChuyenBay = sc.nextLine();
            if(maChuyenBay.length() < 3 || maChuyenBay.length() > 5) {
                System.err.println("Ban thua hoac thieu ki tu!!!");
            }
        }while(maChuyenBay.length() < 3 || maChuyenBay.length() > 5);
//        do {
//          //  dsMB.DocFileJava("MayBay.txt");// FILE
//          //  dsMB.hienThi();
//            System.out.print("Nhap ma may bay: ");
//            maMayBay = sc.nextLine();
//         //   if(dsMB.truyenDuLieu_MB(maMayBay) == null)
//                System.out.println("Ma may bay vua nhap khong co trong danh sach");
//        }while(dsMB.truyenDuLieu_MB(maMayBay) == null);
//        do {
//          //  dsSB.DocFileJava("SanBay.txt");// FILE
//            dsSB.hienThi();
//            System.out.print("Nhap ma san bay: ");
//            maSanBay = sc.nextLine();
//            if(dsSB.truyenDuLieu_SB(maSanBay) == null)
//                System.out.println("Ma san bay vua nhap khong co trong danh sach");
//        }while(dsSB.truyenDuLieu_SB(maSanBay) == null);
        System.out.print("Nhap ngay di: ");
        ngayDi = sc.nextLine();
        System.out.print("Nhap ngay den: ");
        ngayDen = sc.nextLine();
        System.out.print("Nhap san bay di: ");
        sanBayDi = sc.nextLine();
        System.out.print("Nhap san bay den: ");
        sanBayDen = sc.nextLine();
        System.out.print("Nhap gio di: ");
        gioDi = sc.nextLine();
        System.out.print("Nhap gio den: ");
        gioDen = sc.nextLine();
        System.out.print("Tong so ve: ");
        tongSoVe = sc.nextInt();
    }
    public void xuat() {
        System.out.println("Thong tin Chuyen Bay: ");
        System.out.println("Ma chuyen bay: " + maChuyenBay 
                           + "Ma may bay: " + maMayBay
                           + "Ma san bay: " + maSanBay
                           + "Ngay di: " + ngayDi
                           + "Ngay den: " + ngayDen
                           + "San bay di: " + sanBayDi
                           + "San bay den: " + sanBayDen
                           + "Gio di: " + gioDi
                           + "Gio den: " + gioDen
                           + "Tong so ve: " + tongSoVe);
    }
        
    
    
}
