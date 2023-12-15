package MayBay;

import java.util.Scanner;

public class QuanLyDSMB {
	private DanhSachMayBay ds = new DanhSachMayBay(100);
	
	//constructor
	public QuanLyDSMB() {
		ds = new DanhSachMayBay(100);
	}
	public QuanLyDSMB(DanhSachMayBay a) {
		this.ds = a;
	}
	public QuanLyDSMB(QuanLyDSMB x) {
		this.ds = x.ds;
	}
	
	// get/set
	public DanhSachMayBay getDs() {
		return ds;
	}
	public void setDs(DanhSachMayBay x) {
		this.ds = x;
	}
	
	// methods
	public void clearScreen(int n) {
		for(int i=0;i<n;i++) {
			System.out.println();
		}
	}
	public void menu() {
		ds.docfile();
		while(true) {
			System.out.println("");
			System.out.println("   ========================================");
			System.out.println("   !           ----- May Bay -----        !");
			System.out.println("   !        1. Them may bay.              !");
			System.out.println("   !        2. Danh sach may bay.         !");
			System.out.println("   !        3. Tim kiem may bay.          !");
			System.out.println("   !        4. Sua may bay.               !");
			System.out.println("   !        5. Xoa may bay.               !");
			System.out.println("   !        6. Thong ke.                  !");
			System.out.println("   !        0. Thoat.                     !");
			System.out.println("   ========================================");
			System.out.println("");
			Scanner sc = new Scanner(System.in);
			System.out.print(" - Chon hanh dong: ");
			int n = sc.nextInt();
			System.out.println("");
			switch(n) {
				case 1:
					clearScreen(5);
					ds.them();
					clearScreen(5);
					break;
				case 2:
					clearScreen(5);
					ds.xemds();
					// Thực hiện thao tác nhấn bất kì để tắt danh sách NV.
					System.out.println("");
					sc.nextLine();
					System.out.print(" Thoat (phim bat ky): ");
					sc.nextLine();
					clearScreen(5);
					break;
				case 3: 
					clearScreen(5);
					ds.timkiem();
					// Thực hiện thao tác nhấn bất kì để tắt danh sách NV
					System.out.println("");
					sc.nextLine();
					System.out.print(" Thoat (phim bat ky): ");
					sc.nextLine();
					clearScreen(5);
					break;
				case 4:
					clearScreen(5);
					ds.sua();
					clearScreen(5);
					break;
				case 5:
					clearScreen(5);
					ds.xoa();
					clearScreen(5);
					break;
				case 6:
					clearScreen(5);
					ds.thongke();
					// Thực hiện thao tác nhấn bất kì để tắt danh sách NV.
					System.out.println("");
					sc.nextLine();
					System.out.print(" Thoat (phim bat ky): ");
					sc.nextLine();
					clearScreen(5);
					break;
				case 0:
					return;
				default: 
					System.out.println(" Lua chon kh hop le. Hay thu lai!!!");
	                break;
			}
			ds.ghifile();
		}
	}
}