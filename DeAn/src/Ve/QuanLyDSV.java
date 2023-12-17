package Ve;

import java.util.Scanner;

public class QuanLyDSV {
    private DanhSachVe ds=new DanhSachVe(100);
    public QuanLyDSV(){
        ds=new DanhSachVe(100);
    }
    public QuanLyDSV(DanhSachVe ds) {
        this.ds = ds;
    }

    public DanhSachVe getDs() {
        return ds;
    }

    public void setDs(DanhSachVe ds) {
        this.ds = ds;
    }
    public static void clearScreen(int n) {
		for(int i=0;i<n;i++) {
			System.out.println();
		}
	}
    public void menu() {
		ds.docfile();
		while(true) {
			System.out.println("");
			System.out.println("  	===================================");
			System.out.println("  	!           ----- Ve -----        !");
			System.out.println("  	!        1. Them ve.              !");
			System.out.println("  	!        2. Danh sach ve.         !");
			System.out.println("  	!        3. Tim kiem ve.          !");
			System.out.println("  	!        4. Sua ve.               !");
			System.out.println(" 	!        5. Xoa ve.               !");
			System.out.println("  	!        0. Thoat.                !");
			System.out.println("  	===================================");
			System.out.println("");
			Scanner sc = new Scanner(System.in);
			System.out.print(" - Chon hanh dong: ");
			int n = sc.nextInt();
			switch(n) {
				case 1:
					clearScreen(5);
					ds.them();
					clearScreen(5);
					break;
				case 2:
					clearScreen(5);
					ds.xemds();
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
