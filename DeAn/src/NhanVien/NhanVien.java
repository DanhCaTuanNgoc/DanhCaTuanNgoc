package NhanVien;

import java.util.Scanner;

public class NhanVien {
	private String maNhanVien;
	private String ho;
	private String sdt;
	private String ten;
	private int deleted = 0; // 0 => chua xoa, 1 => nguoc lai
	// constructor
	public NhanVien() {
		maNhanVien = "";
		ho = "";
		sdt = "";
		ten = "";
		deleted = 0;
	}
	public NhanVien(String manhanvien,String ho,String sdt,String ten, int deleted) {
		this.maNhanVien = manhanvien;
		this.ho = ho;
		this.ten = ten;
		this.sdt = sdt;
		this.deleted = deleted;
	}
	public NhanVien(NhanVien a) {
		this.maNhanVien = a.maNhanVien;
		this.ho = a.ho;
		this.sdt = a.sdt;
		this.ten = a.ten;
		this.deleted = a.deleted;
	}
	// get/set
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
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
		System.out.print(" - Nhap ma nhan vien: ");
		this.maNhanVien = sc.nextLine();
		System.out.print(" - Nhap ho nhan vien: ");
		this.ho = sc.nextLine();
		System.out.print(" - Nhap ten nhan vien: ");
		this.ten = sc.nextLine();
		System.out.print(" - Nhap sdt nhan vien: ");
		this.sdt = sc.nextLine();		
	}
	
	public void xuat() {
		System.out.printf("| %-15s | %-7s | %-15s | %-10s",maNhanVien, ho, ten, sdt);
	}
}