package HoaDon_KhachHang;

import java.util.Scanner;

public class HoaDon_KhachHang {
	private String maHoaDon;
	private String maKhachHang;
	// constructor
	public HoaDon_KhachHang() {
		maHoaDon = "";
		maKhachHang = "";
	}
	public HoaDon_KhachHang(String mahoadon, String makhachhang) {
		mahoadon = this.maHoaDon;
		makhachhang = this.maKhachHang;
	}
	public HoaDon_KhachHang(HoaDon_KhachHang a) {
		a.maHoaDon = this.maHoaDon;
		a.maKhachHang = this.maKhachHang;
	}
	
	//get/set
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma khach hang: ");
		this.maKhachHang = sc.nextLine();
		System.out.print("Nhap ma hoa don: ");
		this.maHoaDon = sc.nextLine();
	}
	
	public void xuat() {
		System.out.print(maKhachHang + "\t" + maHoaDon);
	}
}
