package SanBay;

import java.util.Arrays;
import java.util.Scanner;

final class DanhSachSanBay {
	private SanBay dsSanBay[];
	private int tongSan;
	
	//constructor
	public DanhSachSanBay(int n) {
		dsSanBay = new SanBay[n];
		tongSan = 0;
	}
	public DanhSachSanBay(SanBay dssanbay[], int tongsan) {
		this.dsSanBay = dssanbay;
		this.tongSan = tongsan;
	}
	public DanhSachSanBay(DanhSachSanBay a) {
		this.dsSanBay = a.dsSanBay;
		this.tongSan = a.tongSan;
	}
	
	
	// get/set
	public SanBay[] getDsSanBay() {
		return dsSanBay;
	}
	public void setDsSanBay(SanBay[] dsSanBay) {
		this.dsSanBay = dsSanBay;
	}
	public int getTongSan() {
		return tongSan;
	}
	public void setTongSan(int tongSan) {
		this.tongSan = tongSan;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println("------------ Them san bay ------------");
		this.tongSan++;
		System.out.println("	$ Nhap thong tin san bay $");
		dsSanBay = Arrays.copyOf(dsSanBay, this.tongSan);
		dsSanBay[this.tongSan - 1] = new SanBay();
		dsSanBay[this.tongSan - 1].nhap();
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
		System.out.println(" ---------- Danh sach san bay ----------");
		System.out.println("Tong san bay: " + this.tongSan);
		System.out.printf("%-15s %-7s %-15s","Ma san bay","Ten","Dia chi");
		for(SanBay sanbay : dsSanBay) {
			if(sanbay.getDeleted() != 1) {
				sanbay.xuat();
				System.out.println("");
			}
		}
		System.out.println("");
	}
	public void xoa() {
		System.out.println(" ------------ Xoa san bay ------------");
		System.out.println("	1. Xoa san bay.");
		System.out.println("	2. Xem danh danh sach san bay da xoa.");
		System.out.println("	3. Thoat.");
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt();
		System.out.println();
		switch (n) {
			case 1:
				System.out.println(" ----------------------------------");
				System.out.print(" - Hay nhap ma san bay can xoa: ");
				String x = sc.next(); int m = 1;
				for(int i=0;i<this.tongSan;i++) {
					if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(x) && dsSanBay[i].getDeleted() != 1) {
						dsSanBay[i].setDeleted(1); m++;
						System.out.println(" -------- Hoan tat thao tac --------");
						break;
					}
				}
				System.out.println("");
				if(m == 1) {
					System.out.println(" -------- Khong tim thay ma san bay --------");
				}
				break;
			case 2:
				System.out.println(" ------- Danh sach san bay da xoa --------");
				System.out.printf("%-15s %-7s %-15s","Ma san bay","Ten","Dia chi");
				System.out.println("");
				for(SanBay sb : dsSanBay) {
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
				 		System.out.print(" - Hay nhap ma san bay can khoi phuc: ");
				 		String maKP = sc.next(); int k = 1;
				 		for(int i=0;i<this.tongSan;i++) {
				 			if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(maKP) && dsSanBay[i].getDeleted() == 1) {
				 				dsSanBay[i].setDeleted(0); k++;
				 				System.out.println(" -------- Hoan tat khoi phuc -------");
				 				 break;
				 			}
				 		}
				 		System.out.println("");
				 		if(k == 1) {
				 			System.out.println(" -------- Khong tim thay ma san bay --------");
				 		}
				 		break;
				 	case 2: 
				 		System.out.println(" ---------- Xoa vinh vien ----------");
				 		System.out.print(" - Hay nhap ma san bay can xoa: ");
				 		String xoaVV = sc.next();
				 		int delete_point = -1;
						for(int i=0;i<this.tongSan;i++) {
							if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(xoaVV) && dsSanBay[i].getDeleted() == 1) {
								delete_point = i;
								break;
							}
						}
						if(delete_point != -1) {
							for(int i=delete_point;i<this.tongSan-1;i++) {
								dsSanBay[i] = dsSanBay[i+1];
							} 
							this.tongSan--;
							dsSanBay = Arrays.copyOf(dsSanBay, this.tongSan);
							System.out.println("");
							System.out.println(" ------ Hoan tat thao tac xoa vinh vien ------");
						} else {
							System.out.println("");
							System.out.println(" ------ Khong tim thay ma san bay ------");
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
	public void timkiem() {
		System.out.println(" ------------ Tim kiem san bay ------------");
		sc.nextLine();
		System.out.print(" Nhap ma san bay (bo qua nhan phim 0): ");
		String ma = sc.nextLine();
		System.out.print(" Nhap ten san bay (bo qua nhan phim 0): ");
		String ten = sc.nextLine();
		System.out.print(" Nhap dia chi san bay (bo qua nhan phim 0): ");
		String dc = sc.nextLine();
		
		for(SanBay sb : dsSanBay) {
			if(sb.getDeleted() != 1) {
				if(sb.getMaSanBay().equalsIgnoreCase(ma) || sb.getTenSanBay().equalsIgnoreCase(ten) || sb.getDiaChiSanBay().equalsIgnoreCase(dc)) {
					sb.xuat();
				}
			}
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua san bay ------------");
		System.out.print(" - Hay nhap ma san bay can sua: ");
		String x = sc.next(); int m = 1;
		// Nhap Ma sau do tuy chon cach sua.
		for (int i=0;i<this.tongSan;i++) {
			if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(x) && dsSanBay[i].getDeleted() != 1) {
				System.out.println("	1. Sua ma san bay.");
				System.out.println("	2. Sua ten san bay.");
				System.out.println("	3. Sua dia chi san bay.");
				System.out.println("	4. Sua tat ca thong tin.");
				System.out.println(" 	5. Thoat.");
				System.out.print(" - Chon hanh dong: ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Nhap ma san bay: ");
						String ma = sc.next();
						dsSanBay[i].setMaSanBay(ma);
						break;
					case 2:
						System.out.print(" - Nhap ten san bay: ");
						String ten = sc.nextLine();
						dsSanBay[i].setTenSanBay(ten);
						break;
					case 3: 
						System.out.print(" - Nhap dia chi san bay: ");
						String dc = sc.nextLine();
						dsSanBay[i].setDiaChiSanBay(dc);
						break;
					case 4: 
						dsSanBay[i].nhap();
						break;
					case 5:
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
			System.out.println(" ------ Khong tim thay nhan vien ------");
			System.out.println("");
		} else if(m == -1) {
			;
		} else {
			System.out.println("");
			System.out.println(" ----- Hoan tat sua thong tin nhan vien -----");
			System.out.println("");
		}
	}
	public void thongke() {
		System.out.println("...Updating");
	}
}
