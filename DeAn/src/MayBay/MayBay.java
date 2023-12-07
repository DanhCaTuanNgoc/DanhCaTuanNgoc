package MayBay;

import java.util.Scanner;

public class MayBay {
	private String maMayBay;
	private String tenMayBay;
	private int soGhe;
	// constructor
	public MayBay() {
		maMayBay = "";
		tenMayBay = "";
		soGhe = 0;
	}
	public MayBay(String mamaybay,String tenmaybay,int soghe) {
		mamaybay = this.maMayBay;
		tenmaybay = this.tenMayBay;
		soghe = this.soGhe;
	}
	public MayBay(MayBay a) {
		a.maMayBay = this.maMayBay;
		a.tenMayBay = this.tenMayBay;
		a.soGhe = this.soGhe;
    }
	// get/set
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
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma may bay: ");
		this.maMayBay = sc.nextLine();
		System.out.print("Nhap ten may bay: ");
		this.tenMayBay = sc.nextLine();
		System.out.print("Nhap so ghe: ");
		this.soGhe = sc.nextInt();	
	}
	
	public void xuat() {
		System.out.print(maMayBay + "\t" + tenMayBay + "\t" + soGhe);
	}
}
