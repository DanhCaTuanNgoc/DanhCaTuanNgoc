package HoaDon;

import java.util.Scanner;

public class HoaDon {
	private String maHoaDon;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayXuat;
	private String tongHoaDon;
	// constructor
	public HoaDon() {
		maHoaDon = "";
		maKhachHang = "";
		maNhanVien = "";
		ngayXuat = "";
		tongHoaDon = "";
	}
	public HoaDon(String mahoadon, String makhachhang, String manhanvien, String ngayxuat, String tonghoadon) {
		mahoadon = this.maHoaDon;
		makhachhang = this.maKhachHang;
		manhanvien = this.maNhanVien;
		ngayxuat = this.ngayXuat;
		tonghoadon = this.tongHoaDon;
	}
	public HoaDon(HoaDon a) {
		a.maHoaDon = this.maHoaDon;
		a.maKhachHang = this.maKhachHang;
		a.maNhanVien = this.maNhanVien;
		a.ngayXuat = this.ngayXuat;
		a.tongHoaDon = this.tongHoaDon;
	}
	
	// get/set
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
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	public String getTongHoaDon() {
		return tongHoaDon;
	}
	public void setTongHoaDon(String tongHoaDon) {
		this.tongHoaDon = tongHoaDon;
	}
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don: ");
		this.maHoaDon = sc.nextLine();
		System.out.print("Nhap ma khach hang: ");
		this.maKhachHang = sc.nextLine();
		System.out.print("Nhap ma nhan vien: ");
		this.maNhanVien = sc.nextLine();
		System.out.print("Nhap ngay xuat: ");
		this.ngayXuat = sc.nextLine();	
		System.out.print("Nhap tong hoa don: ");
		this.tongHoaDon = sc.nextLine();
	}
	
	public void xuat() {
		System.out.print(maHoaDon + "\t" + maKhachHang + "\t" + maNhanVien + "\t" + ngayXuat + "\t" + tongHoaDon);
	}
}