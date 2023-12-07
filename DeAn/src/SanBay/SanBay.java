package SanBay;

import java.util.Scanner;

public class SanBay {
	private String maSanBay;
	private String tenSanBay;
	private String diaChiSanBay;
	private int deleted = 0;

	// constructor
	public SanBay() {
		maSanBay = "";
		tenSanBay = "";
		diaChiSanBay = "";
		deleted = 0;
	}
	public SanBay(String masanbay, String tensanbay, String diachisanbay, int deleted) {
		this.maSanBay = masanbay;
		this.tenSanBay = tensanbay;
		this.diaChiSanBay = diachisanbay;
		this.deleted = deleted;
	}
	public SanBay(SanBay a) {
	    this.maSanBay = a.maSanBay ;
	    this.tenSanBay = a.tenSanBay;
	    this.diaChiSanBay = a.diaChiSanBay;
	    this.deleted = a.deleted;
	}

	// get/set
	public String getMaSanBay() {
		return maSanBay;
	}
	public void setMaSanBay(String maSanBay) {
		this.maSanBay = maSanBay;
	}
	public String getTenSanBay() {
		return tenSanBay;
	}
	public void setTenSanBay(String tenSanBay) {
		this.tenSanBay = tenSanBay;
	}
	public String getDiaChiSanBay() {
		return diaChiSanBay;
	}
	public void setDiaChiSanBay(String diaChiSanBay) {
		this.diaChiSanBay = diaChiSanBay;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma san bay: ");
		this.maSanBay = sc.nextLine();
		System.out.print("Nhap ten san bay: ");
		this.tenSanBay = sc.nextLine();
		System.out.print("Nhap dia chi san bay: ");
		this.diaChiSanBay = sc.nextLine();	
	}
	
	public void xuat() {
		System.out.print(maSanBay + "\t" + tenSanBay + "\t" + diaChiSanBay);
	}
}
