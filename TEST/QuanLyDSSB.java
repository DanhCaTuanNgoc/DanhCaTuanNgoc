package TEST;

import java.util.Scanner;

public class QuanLyDSSB {
	private DanhSachSanBay ds = new DanhSachSanBay();
	
	//constructor
	public QuanLyDSSB() {
		ds = new DanhSachSanBay();
	}
	public QuanLyDSSB(DanhSachSanBay a) {
		this.ds = a;
	}
	public QuanLyDSSB(QuanLyDSSB x) {
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
			System.out.println("   !           ----- San Bay -----         !");
			System.out.println("   !        1. Them san bay.               !");
			System.out.println("   !        2. Danh sach san bay.          !");
			System.out.println("   !        3. Danh sach san bay da xoa.   !");
			System.out.println("   !        4. Tim kiem san bay.           !");
			System.out.println("   !        5. Sua san bay.                !");
			System.out.println("   !        6. Xoa san bay.                !");
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
					// Thực hiện thao tác nhấn bất kì để tắt danh sách NV.
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
					System.out.println("Hen gap lai !!!");
					return;
				default: 
					System.out.println(" Lua chon kh hop le. Hay thu lai!!!");
	                		break;
			}
			ds.ghifile();
		}
	}
}