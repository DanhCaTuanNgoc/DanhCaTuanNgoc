/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import java.util.Scanner;

/**
 *
 * @author Luong Thanh Tuan
 */
public class DanhSachChuyenBay {
    public ChuyenBay [] dsChuyenBay ;
    public int soLuongChuyenBay;
    // CONSTRUCTOR DEFAULT
    public DanhSachChuyenBay() {
        dsChuyenBay = new ChuyenBay[0] ;
        soLuongChuyenBay = 0 ;
    }
    // CONSTRUCTOR PROPERTY
    public DanhSachChuyenBay(ChuyenBay [] dsChuyenBay , int soLuongChuyenBay) {
        this.dsChuyenBay = dsChuyenBay ;
        this.soLuongChuyenBay = soLuongChuyenBay ;
    }
    // COPY CONSTRUCTOR
    public DanhSachChuyenBay(DanhSachChuyenBay dsCB1) {
        dsChuyenBay = dsCB1.dsChuyenBay ;
        soLuongChuyenBay = dsCB1.soLuongChuyenBay ;
    }

    //GET AND SET
    public ChuyenBay [] getDSChuyenBay() {
        return dsChuyenBay ;
    }
    public void setDSChuyenBay(ChuyenBay [] dsChuyenBay) {
        this.dsChuyenBay = dsChuyenBay ;
    }
    public int getSoLuongChuyenBay() {
        return soLuongChuyenBay ;
    }
    public void setSoLuongChuyenBay(int soLuongChuyenBay) {
        this.soLuongChuyenBay = soLuongChuyenBay ;
    }
    Scanner input = new Scanner(System.in) ;
    // METHOD 
    // NHAP SO LUONG
    public void soLuong(int n) {
    if (soLuongChuyenBay + n > dsChuyenBay.length) {
        System.err.println("Vuot qua so luong Chuyen Bay cho phep");
        return;
    }
    for (int i = 0; i < n; i++) {
        ChuyenBay cb = new ChuyenBay();
        cb.nhap();
        dsChuyenBay[soLuongChuyenBay] = cb;
        soLuongChuyenBay ++;
        System.out.println("Da Nhap Xong So Luong Chuyen Bay !!!");
    }
}
    // ADD VE
    public void them() {
        if(soLuongChuyenBay < dsChuyenBay.length) {
            ChuyenBay cb = new ChuyenBay() ;
            cb.nhap();
            dsChuyenBay[soLuongChuyenBay] = cb ;
            soLuongChuyenBay ++ ;
            System.out.println("Da Them Chuyen Bay Thanh Cong !!!");
        } 
    }
    // ALERT
    public void sua(String maChuyenBay) {
    boolean ok = false;
    for (int i = 0; i < soLuongChuyenBay; i++) {
        if (dsChuyenBay[i] != null && dsChuyenBay[i].getMaChuyenBay().equals(maChuyenBay)) {
            dsChuyenBay[i].nhap();
            ok = true;
            break;
        }
    }
    if (!ok) {
        System.out.println("Khong tim thay chuyen bay co ma: " + maChuyenBay);
    }
}
    // SUB 
    boolean daXoa = false ;
    int index = 0 ;
    public void xoa(String ngayDi) {
        while(index < soLuongChuyenBay) {
            if(dsChuyenBay[index] != null) {
                ChuyenBay cb = (ChuyenBay) dsChuyenBay[index] ;
                if(cb.getNgayDi().equals(ngayDi)) {
                    int j = index ;
                    while(j < soLuongChuyenBay - 1) {
                        dsChuyenBay[j] = dsChuyenBay[j + 1] ;
                        j ++ ;
                    }
                    dsChuyenBay[soLuongChuyenBay - 1] = null ;
                    soLuongChuyenBay -- ;
                } else {
                    index ++ ;
                }
            } else {
                index ++ ;
            }
        }
    }
    // SearchVE
    public void timKiem(String ngayDen) {
    boolean daTimThay = false;
    for (int i = 0; i < soLuongChuyenBay; i++) {
        if (dsChuyenBay[i] != null && dsChuyenBay[i].getNgayDen().equals(ngayDen)) {
            dsChuyenBay[i].xuat();
            daTimThay = true;
            break;
        }
    }
    if (!daTimThay) {
        System.out.println("Khong tim thay chuyen bay co ngay den: " + ngayDen);
    }
}
    // SHOW
    public void hienThi() {
        System.out.println("Danh Sach Chuyen Bay:");
        for(ChuyenBay cb1 : dsChuyenBay) {
            if(cb1 != null) {
                cb1.xuat();
            }
        }
    }
    //THONG KE
public void thongKe(String maChuyenBay, String ngayDi) {
    int countCB = 0;
    for (ChuyenBay cb1 : dsChuyenBay) {
        if (cb1 != null && (cb1.getMaChuyenBay().equals(maChuyenBay) || cb1.getNgayDi().equals(ngayDi))) {
            countCB++;
        }
    }

    // Tính tỷ lệ phần trăm
    double percentKH = (countCB / (double) dsChuyenBay.length) * 100;

    // In ra bảng thống kê
    System.out.println("THONG KE KHACH HANG CO MA CHUYEN BAY : " + maChuyenBay + " VA NGAY DI: " + ngayDi);
    System.out.println("+----------------------+---------------+");
    System.out.printf("| SO LUONG             | TI LE         |\n");
    System.out.println("+----------------------+---------------+");
    System.out.printf("| %-20d | %-15s |\n", countCB, calculatePercentage(countCB, dsChuyenBay.length));
    System.out.println("+----------------------+---------------+");
}

private String calculatePercentage(int count, int total) {
    double percentage = (double) count / total * 100;
    return String.format("%.2f%%", percentage);
}
public String truyenDuLieu_CB(String maChuyenBay) {
            for(int i = 0; i < soLuongChuyenBay; i ++) {
                if(dsChuyenBay[i].getMaChuyenBay().equals(maChuyenBay)) {
                    return dsChuyenBay[i].maChuyenBay + "" + dsChuyenBay[i].maMayBay;
                }
            }
            return null;
        }
}

