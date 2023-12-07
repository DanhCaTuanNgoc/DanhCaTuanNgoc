package KhachHang;

import java.util.Scanner;

public class KhachHang {
	private String maKhachHang;
	private String ho;
	private String ten;
	private String cccd;
	private String diaChi;
    private String sdt;
	// constructor
	public KhachHang() {
		maKhachHang = "";
		ho = "";
		ten = "";
		cccd = "";
		diaChi = "";
        sdt = "";
	}
	public KhachHang(String makhachhang, String ho, String ten, String cccd, String diachi, String sdt) {
		makhachhang = this.maKhachHang;
		ho = this.ho;
		ten = this.ten;
		cccd = this.cccd;
		diachi = this.diaChi;
        sdt = this.sdt;
	}
	public KhachHang(KhachHang a) {
		a.maKhachHang = this.maKhachHang;
		a.ho = this.ho;
		a.ten = this.ten;
		a.cccd = this.cccd;
		a.diaChi = this.diaChi;
		a.sdt = this.sdt;
	}
	
	//get/set
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma khach hang: ");
		this.maKhachHang = sc.nextLine();
		System.out.print("Nhap ho: ");
		this.ho = sc.nextLine();
		System.out.print("Nhap ten: ");
		this.ten = sc.nextLine();
		System.out.print("Nhap can cuoc cong dan: ");
		this.cccd = sc.nextLine();	
		System.out.print("Nhap dia chi: ");
		this.diaChi = sc.nextLine();
		System.out.print("Nhap sdt: ");
		this.sdt = sc.nextLine();
	}
	
	public void xuat() {
		System.out.print(maKhachHang + "\t" + ho + "\t" + ten + "\t" + ho + "\t" + diaChi + "\t" + sdt);
	}
}
	