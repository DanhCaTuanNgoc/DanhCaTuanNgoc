package HoaDon;

import java.util.Scanner;
import NhanVien.DanhSachNhanVien;
import KhachHang.DanhSachKhachHang;
import HoaDon.DanhSachHoaDon;

public class HoaDon {
	private String maHoaDon;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayXuat;
	private String tongHoaDon;
	private int deleted;
	
	DanhSachNhanVien nv = new DanhSachNhanVien(100);
	DanhSachKhachHang kh = new DanhSachKhachHang(100);
	DanhSachHoaDon hd = new DanhSachHoaDon(100);
	
	// constructor
	public HoaDon() {
		maHoaDon = "";
		maKhachHang = "";
		maNhanVien = "";
		ngayXuat = "";
		tongHoaDon = "";
		deleted = 0;
	}
	public HoaDon(String mahoadon, String makhachhang, String manhanvien, String ngayxuat, String tonghoadon, int deleted) {
		this.maHoaDon = mahoadon;
		this.maKhachHang = makhachhang;
		this.maNhanVien = manhanvien;
		this.ngayXuat = ngayxuat;
		this.tongHoaDon = tonghoadon;
		this.deleted = deleted;
		
	}
	public HoaDon(HoaDon a) {
		this.maHoaDon = a.maHoaDon;
		this.maKhachHang = a.maKhachHang;
		this.maNhanVien = a.maNhanVien;
		this.ngayXuat = a.ngayXuat;
		this.tongHoaDon = a.tongHoaDon;
		this.deleted = a.deleted;
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
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getDeleted() {
		return deleted;
	}
	// methods
	
	public void nhap() {
		kh.docfile(); hd.docfile(); nv.docfile();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(" - Nhap ma hoa don: ");
			this.maHoaDon = sc.nextLine();
			if(hd.Check_Available(maHoaDon)) {
				System.err.println("\n Ma hoa don da ton tai !!! Vui long nhap lai");
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print(" - Nhap ma khach hang: ");
			this.maKhachHang = sc.nextLine();
			if(!kh.Check_Available(maKhachHang)) {
				System.err.println("\n Ma khach hang khong ton tai !!! Vui long nhap lai");
			} else {
				break;
			}
		}
		while(true) {
			System.out.print(" - Nhap ma nhan vien: ");
			this.maNhanVien = sc.nextLine();
			if(!nv.Check_Available(maNhanVien)) {
				System.err.println("\n Ma nhan vien kh ton tai !!! Vui long nhap lai");
			} else {
				break;
			}
		}
		System.out.print(" - Nhap ngay xuat: ");
		this.ngayXuat = sc.nextLine();	
		System.out.print(" - Nhap tong hoa don: ");
		this.tongHoaDon = sc.nextLine();
	}
	
	public void xuat() {
		System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s", maHoaDon, maKhachHang,  maNhanVien, ngayXuat, tongHoaDon);
	}
}