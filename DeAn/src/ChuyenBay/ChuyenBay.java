package ChuyenBay;

import java.util.InputMismatchException;
import java.util.Scanner;

import MayBay.DanhSachMayBay;
import SanBay.DanhSachSanBay;

public class ChuyenBay {
	private String maChuyenBay;
	private String maMayBay;
	private String maSanBay;
	private String ngayDi;
	private String ngayDen;
	private String maSanBayDi;
	private String maSanBayDen;
	private String gioDi;
	private String gioDen;
	private int tongSoVe;
    private int soVeConLai;
	private int deleted = 0;
	
	DanhSachMayBay mb = new DanhSachMayBay(100);
	DanhSachSanBay sb = new DanhSachSanBay(100);
	
	
	// constructor
	public ChuyenBay() {
		maChuyenBay = "";
		maMayBay = "";
		ngayDi = "";
		ngayDen = "";
		maSanBayDi = "";
		maSanBayDen = "";
		gioDi = "";
		gioDen = "";
		tongSoVe = 0;
		soVeConLai = 0;
		deleted = 0;
	}
	public ChuyenBay(String machuyenbay, String mamaybay, String ngaydi, String ngayden, String sandi,String sanden,String giodi,String gioden, int tongsove, int veconlai, int deleted) {
		this.maChuyenBay = machuyenbay;
		this.maMayBay = mamaybay;
		this.ngayDi = ngaydi;
		this.ngayDen = ngayden;
		this.maSanBayDi = sandi;
		this.maSanBayDen = sanden;
		this.gioDi = giodi;
		this.gioDen = gioden;
		this.tongSoVe = tongsove;
        this.soVeConLai = veconlai;
		this.deleted = deleted;
		
	}
	public ChuyenBay(ChuyenBay a) {
		this.maChuyenBay = a.maChuyenBay;
		this.maMayBay = a.maMayBay;
		this.ngayDi = a.ngayDi;
		this.ngayDen = a.ngayDen;
		this.maSanBayDi = a.maSanBayDi;
		this.maSanBayDen = a.maSanBayDen;
		this.gioDi = a.gioDi;
		this.gioDen = a.gioDen;
		this.tongSoVe = a.tongSoVe;
		this.soVeConLai = a.soVeConLai;
		this.deleted = a.deleted;
	}
	
	//get/set
	public String getMaChuyenBay() {
		return maChuyenBay;
	}
	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}
	public String getMaMayBay() {
		return maMayBay;
	}
	public void setMaMayBay(String maMayBay) {
		this.maMayBay = maMayBay;
	}
	public String getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}
	public String getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(String ngayDen) {
		this.ngayDen = ngayDen;
	}
	public int getTongSoVe() {
		return tongSoVe;
	}
	public void setTongSoVe(int tongSoVe) {
		this.tongSoVe = tongSoVe;
	}
	public int getSoVeConLai() {
		return soVeConLai;
	}
	public void setSoVeConLai(int soVeConLai) {
		this.soVeConLai = soVeConLai;
	}
	public String getMaSanBayDi() {
		return maSanBayDi;
	}
	public void setMaSanBayDi(String sanBayDi) {
		this.maSanBayDi = sanBayDi;
	}
	public String getMaSanBayDen() {
		return maSanBayDen;
	}
	public void setMaSanBayDen(String sanBayDen) {
		this.maSanBayDen = sanBayDen;
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
		sb.docfile();
		mb.docfile();
		System.out.print(" - Nhap ma chuyen bay: ");
		this.maChuyenBay = sc.nextLine();
		while(true) { // rang buoc du lieu ma may bay
			try {
				System.out.print(" - Nhap ma may bay: ");
				this.maMayBay = sc.nextLine();
				if(mb.Check_Available(this.maMayBay)) {
					break;
				} else {
					System.err.println("\n Ma may bay kh ton tai trong he thong, vui long nhap lai !!!");
				}
			} catch(InputMismatchException in) {
				System.out.println("LOI! VUI LONG NHAP LAI!");sc.nextLine();
			}
		}
		while(true) { // rang buoc du lieu ma san bay
			try {
				System.out.print(" - Nhap ma san bay di: ");
				this.maSanBayDi = sc.nextLine();
				System.out.print(" - Nhap ma san bay den: ");
				this.maSanBayDen = sc.nextLine();
				if(sb.Check_Available(this.maSanBayDi) && sb.Check_Available(this.maSanBayDen)) {
					break;
				} else {
					System.err.println("\n Ma san bay kh ton tai trong he thong, vui long nhap lai !!!");
				}
			} catch(InputMismatchException in) {
				System.out.println("LOI! VUI LONG NHAP LAI!");sc.nextLine();
			}
		}
		System.out.print(" - Nhap ngay di: ");
		this.ngayDi = sc.nextLine();
		System.out.print(" - Nhap ngay den: ");
		this.ngayDen = sc.nextLine();	
		System.out.print(" - Nhap gio di: ");
		this.gioDi = sc.nextLine();	
		System.out.print(" - Nhap gio den: ");
		this.gioDen = sc.nextLine();
		System.out.print(" - Nhap tong so ve: ");
		this.tongSoVe = sc.nextInt();
		System.out.print(" - Nhap so ve con lai: ");
		this.soVeConLai = sc.nextInt();
	}
	
	public void xuat() {
		System.out.printf("| %-15s | %-15s | %-10s | %-10s | %-20s | %-20s | %-10s | %-10s | %-10s | %-10s", maChuyenBay, maMayBay, ngayDi, ngayDen, maSanBayDi, maSanBayDen, gioDi, gioDen, tongSoVe, soVeConLai);
	}
}
