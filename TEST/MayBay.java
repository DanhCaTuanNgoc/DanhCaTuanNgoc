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
public class MayBay {
    private String maMayBay;
    private String tenMayBay;
    private int soGhe;
    // CONSTRUCTOR DEFAULT / PROPERTY
    public MayBay() {
        maMayBay = "";
        tenMayBay = "";
        soGhe = 0;
    }
    public MayBay(String maMayBay, String tenMayBay, int soGhe) {
	this.maMayBay = maMayBay;
	this.tenMayBay = tenMayBay;
	this.soGhe = soGhe;
    }
	public String getMaMayBay() {
		return maMayBay;
	}
	public void setMaMayBay(String maMayBay) {
		this.maMayBay = maMayBay;
	}
	public String getTenMayBay() {
		return tenMayBay;
	}
	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
	}
	public int getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
        // METHOD
        public void nhap() {
        Scanner sc = new Scanner(System.in) ;
        do {
            System.out.println("Ma may bay, toi thieu 3 ky tu va toi da 5 ky tu: ");
            System.out.print("Ma may bay: ");
            maMayBay =  sc.nextLine();
            if(maMayBay.length() < 3 || maMayBay.length() > 5) {
                System.err.println("Nhap Thieu Hoac Thua Ki Tu, Hay Nhap Lai!!!");
            }
        }while(maMayBay.length() < 3 || maMayBay.length() > 5);
        
        System.out.print("Nhap Ten: ");
        tenMayBay = sc.nextLine();
        System.out.print("So ghe: ");
        soGhe = sc.nextInt();
    }
    public void xuat() {
        System.out.println("Thong Tin May Bay : ");
        System.out.println("Ma May Bay : " + maMayBay + 
                " / Ten : " + tenMayBay +
                " / soGhe: " + soGhe);
    }
    public static void main(String [] args) {
        MayBay mb = new MayBay();
        mb.nhap();
        mb.xuat();
    }
}
