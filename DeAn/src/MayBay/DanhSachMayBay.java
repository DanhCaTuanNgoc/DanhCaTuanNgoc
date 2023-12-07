package MayBay;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachMayBay {
	private MayBay dsMayBay[];
	private int tongMayBay;
	
	//constructor
	public DanhSachMayBay(int max) {
		dsMayBay = new MayBay[max];
		tongMayBay = 0;
	}
	public DanhSachMayBay(MayBay dsMayBay[], int tongMayBay) {
		this.dsMayBay = dsMayBay;
		this.tongMayBay = tongMayBay;
	}
	public DanhSachMayBay(DanhSachMayBay a) {
		this.dsMayBay = a.dsMayBay;
		this.tongMayBay = a.tongMayBay;
	}
	
	
	// get/set
	public MayBay[] getDsMayBay() {
		return dsMayBay;
	}
	public void setDsMayBay(MayBay[] dsMayBay) {
		this.dsMayBay = dsMayBay;
	}
	public int gettongMayBay() {
		return tongMayBay;
	}
	public void settongMayBay(int tongMayBay) {
		this.tongMayBay = tongMayBay;
	}
	
	// methods 
	public void them() {
		System.out.println("----- Them may bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Ban muon them bao nhieu may bay: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			MayBay maybay = null;
			maybay = new MayBay();
			dsMayBay[this.tongMayBay] = maybay;
			maybay.nhap();  
			this.tongMayBay++;
		}
		System.out.println("");
	}
	public void xemds() {
		System.out.println("----- Danh sach may bay -----");
		System.out.println("Tong may bay: " + this.tongMayBay);
		for(MayBay maybay : dsMayBay) {
			if(maybay != null) {
				maybay.xuat();
				System.out.println("");
			}
		} 
		System.out.println("");
	}
	public void xoa() {
		System.out.println("----- Xoa may bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma may bay can xoa: ");
		String x = sc.nextLine();
		int delete_point = -1;
		for(int i=0;i<this.tongMayBay;i++) {
			if(dsMayBay[i].getMaMayBay().equalsIgnoreCase(x)) {
				delete_point = i;
				break;
			}
		}
		if(delete_point != -1) {
			for(int i=delete_point;i<this.tongMayBay-1;i++) {
				dsMayBay[i] = dsMayBay[i+1];
			} 
			this.tongMayBay--;
			dsMayBay = Arrays.copyOf(dsMayBay, this.tongMayBay);
			System.out.println("Da xoa ma may bay " + x);
		} else {
			System.out.println("Khong tim thay ma may bay " + x);
		}
		System.out.println("");
	}
	public void timkiem() {
		System.out.println("----- Tim kiem may bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma may bay can tim kiem: ");
		String x = sc.nextLine(); int m = 1;
		for(int i=0;i<this.tongMayBay;i++) {
			if(dsMayBay[i].getMaMayBay().equalsIgnoreCase(x)) {
				dsMayBay[i].xuat();
				System.out.println("");
			}
		}
		if(m == 1) {
			System.out.println("Khong tim thay may bay co ma " + x);
		}
		System.out.println("");
	}
	public void sua() {
		System.out.println("----- Sua may bay -----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Hay nhap ma may bay can sua: ");
		String x = sc.nextLine();
			for(int i=0;i<this.tongMayBay;i++) {
				if(dsMayBay[i].getMaMayBay().equalsIgnoreCase(x)) {
					dsMayBay[i].nhap();
				}
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
