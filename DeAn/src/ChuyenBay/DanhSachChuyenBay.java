package ChuyenBay;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachChuyenBay {
	private ChuyenBay dsChuyenBay[];
	private int tongChuyenBay;
	
	//constructor
	public DanhSachChuyenBay(int max) {
		dsChuyenBay = new ChuyenBay[max];
		tongChuyenBay = 0;
	}
	public DanhSachChuyenBay(ChuyenBay dsChuyenBay[], int tongChuyenBay) {
		this.dsChuyenBay = dsChuyenBay;
		this.tongChuyenBay = tongChuyenBay;
	}
	public DanhSachChuyenBay(DanhSachChuyenBay a) {
		this.dsChuyenBay = a.dsChuyenBay;
		this.tongChuyenBay = a.tongChuyenBay;
	}
	
	
	// get/set
	public ChuyenBay[] getDsChuyenBay() {
		return dsChuyenBay;
	}
	public void setDsChuyenBay(ChuyenBay[] dsChuyenBay) {
		this.dsChuyenBay = dsChuyenBay;
	}
	public int gettongChuyenBay() {
		return tongChuyenBay;
	}
	public void settongChuyenBay(int tongChuyenBay) {
		this.tongChuyenBay = tongChuyenBay;
	}
	
	// methods 
	public void them() {
		System.out.println("----- Them chuyen bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Ban muon them bao nhieu chuyen bay: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			ChuyenBay ChuyenBay = null;
			ChuyenBay = new ChuyenBay();
			dsChuyenBay[this.tongChuyenBay] = ChuyenBay;
			ChuyenBay.nhap();  
			this.tongChuyenBay++;
		}
		System.out.println("");
	}
	public void xemds() {
		System.out.println("----- Danh sach chuyen bay -----");
		System.out.println("Tong chuyen bay: " + this.tongChuyenBay);
		for(ChuyenBay chuyenbay : dsChuyenBay) {
			if(chuyenbay != null) {
				chuyenbay.xuat();
				System.out.println("");
			}
		} 
		System.out.println("");
	}
	public void xoa() {
		System.out.println("----- Xoa chuyen bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chuyen bay can xoa: ");
		String x = sc.nextLine();
		int delete_point = -1;
		for(int i=0;i<this.tongChuyenBay;i++) {
			if(dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(x)) {
				delete_point = i;
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongChuyenBay-1;i++) {
				dsChuyenBay[i] = dsChuyenBay[i+1];
			} 
			this.tongChuyenBay--;
			dsChuyenBay = Arrays.copyOf(dsChuyenBay, this.tongChuyenBay);
			System.out.println("Da xoa ma chuyen bay " + x);
		} else {
			System.out.println("Khong tim thay ma chuyen bay " + x);
		}
		System.out.println("");
	}
	public void timkiem() {
		System.out.println("----- Tim kiem chuyen bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chuyen bay can tim kiem: ");
		String x = sc.nextLine(); int m = 1;
		for(int i=0;i<this.tongChuyenBay;i++) {
			if(dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(x)) {
				dsChuyenBay[i].xuat();
				System.out.println("");
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay chuyen bay co ma " + x);
		}
		System.out.println("");
	}
	public void sua() {
		System.out.println("----- Sua chuyen bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma chuyen bay can sua: ");
		String x = sc.nextLine();
			for(int i=0;i<this.tongChuyenBay;i++) {
				if(dsChuyenBay[i].getMaChuyenBay().equalsIgnoreCase(x)) {
					dsChuyenBay[i].nhap();
				}
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
