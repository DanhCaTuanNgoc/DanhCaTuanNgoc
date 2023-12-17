package HoaDon;

import java.util.Scanner;

import ChiTietHoaDon.DanhSachCTHoaDon;
import NhanVien.DanhSachNhanVien;
import KhachHang.DanhSachKhachHang;

public class HoaDon {
	private String maHoaDon;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayXuat;
	private int tongTien;
	private int deleted;
	
	DanhSachCTHoaDon cthd=new DanhSachCTHoaDon(100);
	DanhSachNhanVien nv = new DanhSachNhanVien(100);
	DanhSachKhachHang kh = new DanhSachKhachHang(100);
	DanhSachHoaDon hd = new DanhSachHoaDon(100);
	
	// constructor
	public HoaDon() {
		maHoaDon = "";
		maKhachHang = "";
		maNhanVien = "";
		ngayXuat = "";
		tongTien = 0;
		deleted = 0;
	}
	public HoaDon(String mahoadon, String makhachhang, String manhanvien, String ngayxuat, int tonghoadon, int deleted) {
		this.maHoaDon = mahoadon;
		this.maKhachHang = makhachhang;
		this.maNhanVien = manhanvien;
		this.ngayXuat = ngayxuat;
		this.tongTien = tonghoadon;
		this.deleted = deleted;
		
	}
	public HoaDon(HoaDon a) {
		this.maHoaDon = a.maHoaDon;
		this.maKhachHang = a.maKhachHang;
		this.maNhanVien = a.maNhanVien;
		this.ngayXuat = a.ngayXuat;
		this.tongTien = a.tongTien;
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
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTIen) {
		this.tongTien = tongTIen;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getDeleted() {
		return deleted;
	}
	// methods
	
	public void nhap() {
		kh.docfile(); hd.docfile(); nv.docfile();cthd.docfile();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(" - Nhap ma hoa don: ");
			this.maHoaDon = sc.nextLine();
			if(hd.Check_Available(maHoaDon)) {
				System.out.println("\t !! Ma hoa don da ton tai !!");
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print(" - Nhap ma khach hang: ");
			this.maKhachHang = sc.nextLine();
			if(!kh.Check_Available(maKhachHang)) {
				System.out.println("\t !! Ma khach hang khong ton tai !!");
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print(" - Nhap ma nhan vien: ");
			this.maNhanVien = sc.nextLine();
			if(!nv.Check_Available(maNhanVien)) {
				System.out.println("\t !! Ma nhan vien kh ton tai !!");
			} else {
				break;
			}
		}
		System.out.print(" - Nhap ngay xuat: ");
		this.ngayXuat = sc.nextLine();
		this.tongTien=cthd.tongtien(this.maHoaDon);
		System.out.print(" - Tong hoa don: "+this.tongTien);
	}
	
	public void xuat() {
		System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s", maHoaDon, maKhachHang,  maNhanVien, ngayXuat, tongTien);
	}
}