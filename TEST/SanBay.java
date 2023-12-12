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
public class SanBay {
    private String maSanBay;
    private String tenSanBay;
    private String diaChi;
    // CONSTRUCTOR DEFAULT / PROPERTY
    public SanBay() {
        maSanBay = "";
        tenSanBay = "";
        diaChi = "";
    }
    public SanBay(String maSanBay, String tenSanBay, String diaChi) {
	this.maSanBay = maSanBay;
	this.tenSanBay = tenSanBay;
	this.diaChi = diaChi;
	}
    public SanBay(SanBay a) {
        a.maSanBay = maSanBay;
        a.tenSanBay = tenSanBay;
        a.diaChi = diaChi;
    }
    public String getMaSanBay() {
		return maSanBay;
	}
	public void setMaSanBay(String maSanBay) {
		this.maSanBay = maSanBay;
	}
	public String getTenSanBay() {
		return tenSanBay;
	}
	public void setTenSanBay(String tenMayBay) {
		this.tenSanBay = tenSanBay;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
    // METHOD
        public void nhap() {
        Scanner sc = new Scanner(System.in) ;
        do {
            System.out.println("Ma San Bay, toi thieu 3 ky tu va toi da 5 ky tu: ");
            System.out.print("Nhap Ma San Bay: ");
            maSanBay =  sc.nextLine();
            if(maSanBay.length() < 3 || maSanBay.length() > 5) {
                System.err.println("Nhap Thieu Hoac Thua Ki Tu, Hay Nhap Lai!!!");
            }
        }while(maSanBay.length() < 3 || maSanBay.length() > 5);
        
        System.out.print("Nhap Ten: ");
        tenSanBay = sc.nextLine();
        System.out.print("Nhap Dia Chi: ");
        diaChi = sc.nextLine();
    }
    public void xuat() {
        System.out.println("Thong Tin San Bay : ");
        System.out.println("Ma San Bay : " + maSanBay + 
                " / Ten : " + tenSanBay +
                " / Dia chi: " + diaChi);
    }
    public static void main(String [] args) {
        SanBay sb = new SanBay();
        sb.nhap();
        sb.xuat();
    }
}
