package HoaDon;

import java.util.Scanner;

public class QuanLyDSHD {
	private DanhSachHoaDon ds = new DanhSachHoaDon(100);
	
	//constructor
	public QuanLyDSHD() {
		ds = new DanhSachHoaDon(100);
	}
	public QuanLyDSHD(DanhSachHoaDon a) {
		this.ds = a;
	}
	public QuanLyDSHD(QuanLyDSHD x) {
		this.ds = x.ds;
	}
	
	// get/set
	public DanhSachHoaDon getDs() {
		return ds;
	}
	public void setDs(DanhSachHoaDon x) {
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
			System.out.println("   =========================================");
			System.out.println("   !           ----- Hoa Don -----         !");
			System.out.println("   !        1. Them hoa don.               !");
			System.out.println("   !        2. Danh sach hoa don.          !");
			System.out.println("   !        3. Danh sach hoa don da xoa.   !");
			System.out.println("   !        4. Tim kiem hoa don.           !");
			System.out.println("   !        5. Sua hoa don.                !");
			System.out.println("   !        6. Xoa hoa don.                !");
			System.out.println("   !        7. Thong ke.                   !");
			System.out.println("   !        0. Thoat.                      !");
			System.out.println("   =========================================");
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
					ds.xemdsXoa();
					clearScreen(5);
					break;
				case 4: 
					clearScreen(5);
					ds.timkiem();
					// Thực hiện thao tác nhấn bất kì để tắt danh sách NV
					System.out.println("");
					sc.nextLine();
					System.out.print(" Thoat (phim bat ky): ");
					sc.nextLine();
					clearScreen(5);
					break;
				case 5:
					clearScreen(5);
					ds.sua();
					clearScreen(5);
					break;
				case 6:
					clearScreen(5);
					ds.xoa();
					clearScreen(5);
					break;
				case 7:
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