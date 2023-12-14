package ChiTietHoaDon;

import java.util.Scanner;

public class CTHoaDon {
	private String maHoaDon;
	private String maVe;
	private int soLuong;
	private int giaTien;
	private int deleted;
	// constructor
	public CTHoaDon() {
		maHoaDon = "";
		maVe = "";
		soLuong = 0;
		giaTien = 0;
		deleted = 0;
	}
	public CTHoaDon(String mahoadon, String mave, int soluong, int giatien, int deleted) {
		this.maHoaDon = mahoadon;
		this.maVe = mave;
		this.soLuong = soluong;
		this.giaTien = giatien;
		this.deleted = deleted;
	}
	public CTHoaDon(CTHoaDon a) {
		this.maHoaDon = a.maHoaDon;
		this.maVe = a.maVe;
		this.soLuong = a.soLuong;
		this.giaTien = a.giaTien;
		this.deleted = a.deleted;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
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
		System.out.print(" - Nhap ma hoa don: ");
		this.maHoaDon = sc.nextLine();
		System.out.print(" - Nhap ma ve: ");
		this.maVe = sc.nextLine();
		System.out.print(" - Nhap so luong: ");
		this.soLuong = sc.nextInt();
		System.out.print(" - Nhap gia tien: ");
		this.giaTien = sc.nextInt();	
	}
	
	public void xuat() {
		System.out.printf("| %-15s | %-15s | %-10s | %-15s |",maHoaDon, maVe, soLuong, giaTien);
	}
}
