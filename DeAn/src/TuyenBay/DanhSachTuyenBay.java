package TuyenBay;

import java.util.Arrays;
import java.util.Scanner;

import NhanVien.NhanVien;
import TuyenBay.TuyenBay;

final class DanhSachTuyenBay {
	private TuyenBay dsTuyenBay[];
	private int tongTuyen;
	
	//constructor
	public DanhSachTuyenBay(int n) {
		dsTuyenBay = new TuyenBay[n];
		tongTuyen = 0;
	}
	public DanhSachTuyenBay(TuyenBay dsTuyenBay[], int tongTuyen) {
		this.dsTuyenBay = dsTuyenBay;
		this.tongTuyen = tongTuyen;
	}
	public DanhSachTuyenBay(DanhSachTuyenBay a) {
		this.dsTuyenBay = a.dsTuyenBay;
		this.tongTuyen = a.tongTuyen;
	}
	
	
	// get/set
	public TuyenBay[] getdsTuyenBay() {
		return dsTuyenBay;
	}
	public void setdsTuyenBay(TuyenBay[] dsTuyenBay) {
		this.dsTuyenBay = dsTuyenBay;
	}
	public int gettongTuyen() {
		return tongTuyen;
	}
	public void settongTuyen(int tongTuyen) {
		this.tongTuyen = tongTuyen;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println("------------ Them tuyen bay ------------");
		this.tongTuyen++;
		System.out.println("	$ Nhap thong tin tuyen bay $");
		dsTuyenBay = Arrays.copyOf(dsTuyenBay, this.tongTuyen);
		dsTuyenBay[this.tongTuyen - 1] = new TuyenBay();
		dsTuyenBay[this.tongTuyen - 1].nhap();
		System.out.println("");
		System.out.print(" Tiep tuc (1) | Dung lai (2): ");
		int n = sc.nextInt();
		System.out.println("");
		if(n == 1) { them(); } 
		else { 
			System.out.println(" -------- Hoan tat thao tac --------");
			System.out.println("");
		}
		
	}
	public void xemds() {
		System.out.println(" ---------- Danh sach tuyen bay ----------");
		System.out.println("Tong tuyen bay: " + this.tongTuyen);
		System.out.printf("%-15s %-7s %-15s %-10s %-10s %-10s","Sohieuchuyenbay","san di","san den","gio di","gio den");
		for(TuyenBay TuyenBay : dsTuyenBay) {
			if(TuyenBay.getDeleted() != 1) {
				TuyenBay.xuat();
				System.out.println("");
			}
		}
		System.out.println("");
	}
	public void xoa() {
		System.out.println(" ------------ Xoa tuyen bay ------------");
		System.out.println("	1. Xoa tuyen bay.");
		System.out.println("	2. Xem danh danh sach tuyen bay da xoa.");
		System.out.println("	3. Thoat.");
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt();
		System.out.println();
		switch (n) {
			case 1:
				System.out.println(" ----------------------------------");
				System.out.print(" - Hay nhap ma tuyen bay can xoa: ");
				String x = sc.next(); int m = 1;
				for(int i=0;i<this.tongTuyen;i++) {
					if(dsTuyenBay[i].getSoHieuChuyenBay().equalsIgnoreCase(x) && dsTuyenBay[i].getDeleted() != 1) {
						dsTuyenBay[i].setDeleted(1); m++;
						System.out.println(" -------- Hoan tat thao tac --------");
						break;
					}
				}
				System.out.println("");
				if(m == 1) {
					System.out.println(" -------- Khong tim thay ma tuyen bay --------");
				}
				break;
			case 2:
				System.out.println(" ------- Danh sach tuyen bay da xoa --------");
				System.out.printf("%-15s %-7s %-15s","Ma tuyen bay","Ten","Dia chi");
				System.out.println("");
				for(TuyenBay sb : dsTuyenBay) {
			        	if (sb.getDeleted() == 1) {
			            	sb.xuat(); System.out.println("");
			        	}
			    }
				System.out.println("");
				 System.out.println("        1. Khoi phuc.");
				 System.out.println("        2. Xoa vinh vien.");
				 System.out.println("        3. Thoat.");
				 System.out.print(" - Chon hanh dong: ");
				 int a = sc.nextInt();
				 System.out.println("");
				 switch (a) {
				 	case 1:
				 		System.out.println(" ----------- Khoi phuc ------------");
				 		System.out.print(" - Hay nhap ma tuyen bay can khoi phuc: ");
				 		String maKP = sc.next(); int k = 1;
				 		for(int i=0;i<this.tongTuyen;i++) {
				 			if(dsTuyenBay[i].getSoHieuChuyenBay	().equalsIgnoreCase(maKP) && dsTuyenBay[i].getDeleted() == 1) {
				 				dsTuyenBay[i].setDeleted(0); k++;
				 				System.out.println(" -------- Hoan tat khoi phuc -------");
				 				 break;
				 			}
				 		}
				 		System.out.println("");
				 		if(k == 1) {
				 			System.out.println(" -------- Khong tim thay ma tuyen bay --------");
				 		}
				 		break;
				 	case 2: 
				 		System.out.println(" ---------- Xoa vinh vien ----------");
				 		System.out.print(" - Hay nhap ma tuyen bay can xoa: ");
				 		String xoaVV = sc.next();
				 		int delete_point = -1;
						for(int i=0;i<this.tongTuyen;i++) {
							if(dsTuyenBay[i].getSoHieuChuyenBay().equalsIgnoreCase(xoaVV) && dsTuyenBay[i].getDeleted() == 1) {
								delete_point = i;
								break;
							}
						}
						if(delete_point != -1) {
							for(int i=delete_point;i<this.tongTuyen-1;i++) {
								dsTuyenBay[i] = dsTuyenBay[i+1];
							} 
							this.tongTuyen--;
							dsTuyenBay = Arrays.copyOf(dsTuyenBay, this.tongTuyen);
							System.out.println("");
							System.out.println(" ------ Hoan tat thao tac xoa vinh vien ------");
						} else {
							System.out.println("");
							System.out.println(" ------ Khong tim thay ma tuyen bay ------");
						} 
						break;
				 	case 3:
				 		break;
				 	default: 
				 		System.out.println(" Lua chon khong hop le, xin vui long chon lai !!!");
				 		break;
				 }
				 break;
			case 3:
				break;
			default: 
				System.out.println(" Lua chon khong hop le, xin vua long chon lai !!!");
				xoa(); break;
		}
	}
	// Phương thức tìm kiếm chưa hoàn thành.
//	public void timkiem() {
//		System.out.println(" ------------ Tim kiem tuyen bay ------------");
//		sc.nextLine();
//		System.out.print(" Nhap ma tuyen bay (bo qua nhan phim 0): ");
//		String ma = sc.nextLine();
//		System.out.print(" Nhap ten tuyen bay (bo qua nhan phim 0): ");
//		String ten = sc.nextLine();
//		System.out.print(" Nhap dia chi tuyen bay (bo qua nhan phim 0): ");
//		String dc = sc.nextLine();
//		
//		for(TuyenBay sb : dsTuyenBay) {
//			if(sb.getDeleted() != 1) {
//				if(sb.getSoHieuChuyenBay().equalsIgnoreCase(ma) || sb.().equalsIgnoreCase(ten) || sb.getDiaChiTuyenBay().equalsIgnoreCase(dc)) {
//					sb.xuat();
//				}
//			}
//		}
//	}
	public void sua() {
		System.out.println(" ------------ Sua tuyen bay ------------");
		System.out.print(" - Hay nhap so hieu chuyen bay can sua: ");
		String x = sc.next(); int m = 1;
		// Nhap Ma sau do tuy chon cach sua.
		for (int i=0;i<this.tongTuyen;i++) {
			if(dsTuyenBay[i].getSoHieuChuyenBay().equalsIgnoreCase(x) && dsTuyenBay[i].getDeleted() != 1) {
				System.out.println("(1) Sua so hieu chuyen bay.");
				System.out.println("(2) Sua san bay.");
				System.out.println("(3) Sua thoi gian.");
				System.out.println("(4) Sua tat ca thong tin.");
				System.out.println("(0) Thoat.");
				System.out.print(" - Chon hanh dong: ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.println(" -------------------------------");
						System.out.print(" - Nhap so hieu chuyen bay: ");
						String ma = sc.next();
						dsTuyenBay[i].setSoHieuChuyenBay(ma);
						break;
					case 2:
						System.out.println(" -------------------------------");
						System.out.print(" - Nhap san bay di: ");
						String ten1 = sc.nextLine();
						System.out.print(" - Nhap san bay den: ");
						String ten2 = sc.nextLine();
						dsTuyenBay[i].setSanBayDen(ten2);
						dsTuyenBay[i].setSanBayDi(ten1);
						break;
					case 3: 
						System.out.println(" -------------------------------");
						System.out.print(" - Nhap gio di: ");
						String tg1 = sc.nextLine();
						System.out.print(" - Nhap gio den: ");
						String tg2 = sc.nextLine();
						dsTuyenBay[i].setGioDen(tg2);
						dsTuyenBay[i].setGioDi(tg1);
						break;
					case 4: 
						dsTuyenBay[i].nhap();
						break;
					case 0:
						m = -1;
						break;
					default:
						System.out.println("Lua chon khong hop le, vui long nhap lai !!!");
						sua();
						break;
				}
				break;
			}
		}
		if (m == 1) {
			System.out.println("");
			System.out.println(" ------ Khong tim thay tuyen bay ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("");
			System.out.println(" ----- Hoan tat sua thong tin tuyen bay -----");
		}
		System.out.println("");
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
