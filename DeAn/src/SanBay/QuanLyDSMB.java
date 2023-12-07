package SanBay;

import java.util.Scanner;

import SanBay.DanhSachSanBay;

public class QuanLyDSMB {
private DanhSachSanBay ds = new DanhSachSanBay(99);
	
	//constructor
	public QuanLyDSMB() {
		ds = new DanhSachSanBay(99);
	}
	public QuanLyDSMB(DanhSachSanBay a) {
		this.ds = a;
	}
	public QuanLyDSMB(QuanLyDSMB x) {
		this.ds = x.ds;
	}
	
	// get/set
	public DanhSachSanBay getDs() {
		return ds;
	}
	public void setDs(DanhSachSanBay x) {
		this.ds = x;
	}
	
	// methods
	public void menu() {
		System.out.println();
		System.out.println("   =========================================");
		System.out.println("   !           ----- Menu -----            !");
		System.out.println("   !        1. Them san bay.               !");
		System.out.println("   !        2. Xem danh sach san bay.      !");
		System.out.println("   !        3. Tim kiem san bay.           !");
		System.out.println("   !        4. Sua san bay.                !");
		System.out.println("   !        5. Xoa san bay.                !");
		System.out.println("   !        6. Thong ke.                   !");
		System.out.println("   !        7. Thoat.                      !");
		System.out.println("   =========================================");
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt();
		System.out.println("");
		switch(n) {
			case 1:
				ds.them();
				menu();
				break;
			case 2:
				ds.xemds();
				menu();
				break;
			case 3:
				ds.timkiem();
				menu();
				break;
			case 4:
				ds.sua();
				menu();
				break;
			case 5:
				ds.xoa();
				menu();
				break;
			case 6:
				ds.thongke();
				break;
			case 7:
				System.out.println("Hen gap lai !!!");
				break;
			default: 
				System.out.println(" Lua chon kh hop le. Hay thu lai!!!");
				menu();
                break;
		}
	}
}
