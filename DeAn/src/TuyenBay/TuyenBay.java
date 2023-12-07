package TuyenBay;

import java.util.Scanner;

public class TuyenBay {
	private String soHieuChuyenBay;
	private String sanBayDi;
	private String sanBayDen;
	private String gioDi;
	private String gioDen;
	private int deleted = 0;
	// constructor
	public TuyenBay() {
		soHieuChuyenBay = "";
		sanBayDi = "";
		sanBayDen = "";
		gioDi = "";
		gioDen = "";
		deleted = 0;
	}
	public TuyenBay(String sohieu,String sandi,String sanden,String giodi,String gioden, int deleted) {
		this.soHieuChuyenBay = sohieu;
		this.sanBayDi = sandi;
		this.sanBayDen = sanden;
		this.gioDi = giodi;
		this.gioDen = gioden;
		this.deleted = deleted;
	}
	public TuyenBay(TuyenBay a) {
		this.soHieuChuyenBay = a.soHieuChuyenBay;
		this.sanBayDi = a.sanBayDi;
		this.sanBayDen = a.sanBayDen;
		this.gioDi = a.gioDi;
		this.gioDen = a.gioDen;
		this.deleted = a.deleted;
	}
	
	// get/set
	public String getSoHieuChuyenBay() {
		return soHieuChuyenBay;
	}
	public void setSoHieuChuyenBay(String soHieuChuyenBay) {
		this.soHieuChuyenBay = soHieuChuyenBay;
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
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so hieu chuyen bay: ");
		this.soHieuChuyenBay = sc.nextLine();
		System.out.print("Nhap san bay di: ");
		this.sanBayDi = sc.nextLine();
		System.out.print("Nhap san bay den: ");
		this.sanBayDen = sc.nextLine();
		System.out.print("Nhap gio di: ");
		this.gioDi = sc.nextLine();	
		System.out.print("Nhap gio den: ");
		this.gioDen = sc.nextLine();	
	}
	
	public void xuat() {
		System.out.print(soHieuChuyenBay + "\t" + sanBayDi + "\t" + sanBayDen + "\t" + gioDi + "\t" + gioDen);
	}
	
}
