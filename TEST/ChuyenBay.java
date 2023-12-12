package TEST;

import java.util.Scanner;

public class ChuyenBay {
	protected String maChuyenBay, maMayBay;
	protected String ngayDi, ngayDen;
        protected String sanBayDi, sanBayDen ;
        protected String gioDi, gioDen ;
	protected int tongSoVe, soVeConLai;
	// constructor
	public ChuyenBay() {
		maChuyenBay = "";
		maMayBay = "";
		ngayDi = "";
		ngayDen = "";
		tongSoVe = 0;
		soVeConLai = 0;
	}
	public ChuyenBay(String machuyenbay, String mamaybay, String ngaydi, String ngayden, int tongsove, int soVeConLai) {
		machuyenbay = this.maChuyenBay;
		mamaybay = this.maMayBay;
		ngaydi = this.ngayDi;
		ngayden = this.ngayDen;
		tongsove = this.tongSoVe;
                soVeConLai = this.soVeConLai;
	}
	public ChuyenBay(ChuyenBay a) {
		a.maChuyenBay = this.maChuyenBay;
		a.maMayBay = this.maMayBay;
		a.ngayDi = this.ngayDi;
		a.ngayDen = this.ngayDen;
		a.tongSoVe = this.tongSoVe;
		a.soVeConLai = this.soVeConLai;
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
	
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma chuyen bay: ");
		this.maChuyenBay = sc.nextLine();
		System.out.print("Nhap ma may bay: ");
		this.maMayBay = sc.nextLine();
		System.out.print("Nhap ngay di: ");
		this.ngayDi = sc.nextLine();
		System.out.print("Nhap ngay den: ");
		this.ngayDen = sc.nextLine();	
		System.out.print("Nhap tong so ve: ");
		this.tongSoVe = sc.nextInt();
		System.out.print("Nhap so ve con lai: ");
		this.soVeConLai = sc.nextInt();
	}
	
	public void xuat() {
		System.out.print(maChuyenBay + "\t" + maMayBay + "\t" + ngayDi + "\t" + ngayDen + "\t" + tongSoVe + "\t" + soVeConLai);
	}
}
