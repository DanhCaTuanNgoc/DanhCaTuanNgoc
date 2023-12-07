package ChiTietHoaDon;

import java.util.Scanner;

public class CTHoaDon {
	private String maHoaDon;
	private String maVe;
	private String soLuong;
	private String giaTien;
	// constructor
	public CTHoaDon() {
		maHoaDon = "";
		maVe = "";
		soLuong = "";
		giaTien = "";
	}
	public CTHoaDon(String mahoadon, String mave, String soluong, String giatien) {
		mahoadon = this.maHoaDon;
		mave = this.maVe;
		soluong = this.soLuong;
		giatien = this.giaTien;
	}
	public CTHoaDon(CTHoaDon a) {
		a.maHoaDon = this.maHoaDon;
		a.maVe = this.maVe;
		a.soLuong = this.soLuong;
		a.giaTien = this.giaTien;
	}
	
	// get/set
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don: ");
		this.maHoaDon = sc.nextLine();
		System.out.print("Nhap ma ve: ");
		this.maVe = sc.nextLine();
		System.out.print("Nhap so luong: ");
		this.soLuong = sc.nextLine();
		System.out.print("Nhap gia tien: ");
		this.giaTien = sc.nextLine();	
	}
	
	public void xuat() {
		System.out.print(maHoaDon + "\t" + maVe + "\t" + soLuong + "\t" + giaTien);
	}
}
