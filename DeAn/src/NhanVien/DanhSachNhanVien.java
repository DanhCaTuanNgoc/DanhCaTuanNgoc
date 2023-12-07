package NhanVien;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

final class DanhSachNhanVien {
	private NhanVien dsNhanVien[];
	private int tongNV; 
	private int soNVHH; // so nhan vien hien huu ( bien dem cho so nv kh nam trong danh sach xoa ) 
	File d = new File("src/InputOutput/DanhSachNhanVien.txt");
	
	//constructor
	public DanhSachNhanVien(int n) {
		dsNhanVien = new NhanVien[n];
	}
	public DanhSachNhanVien(NhanVien dsNhanVien[], int tongNV, int soNVHH) {
		this.dsNhanVien = dsNhanVien;
		this.tongNV = tongNV;
		this.soNVHH = soNVHH;
	}
	public DanhSachNhanVien(DanhSachNhanVien a) {
		this.dsNhanVien = a.dsNhanVien;
		this.tongNV = a.tongNV;
		this.soNVHH = a.soNVHH;
	}
	
	
	// get/set
	public NhanVien[] getDsNhanVien() {
		return dsNhanVien;
	}
	public void setDsNhanVien(NhanVien[] dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	public int gettongNV() {
		return tongNV;
	}
	public void settongNV(int tongNV) {
		this.tongNV = tongNV;
	}
	public void setSoNVHH(int soNVHH) {
		this.soNVHH = soNVHH;
	}
	public int getSoNVHH() {
		return this.soNVHH;
	}
	
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them nhan vien ------------");
		System.out.print(" - Ban muon them bao nhieu nhan vien: ");
		int n = sc.nextInt(); int m = 0;
		if(n <= 0) {
			System.out.println("So nhan vien khong hop le !!!"); 
		}
		for(int i=0;i<n;i++) {
			this.tongNV++; this.soNVHH++; m++; 
			System.out.println(" 	$ Nhap thong tin nhan vien thu " + this.tongNV);
			dsNhanVien = Arrays.copyOf(dsNhanVien, this.tongNV);
			dsNhanVien[this.tongNV - 1] = new NhanVien();
			dsNhanVien[this.tongNV - 1].nhap(); int k = this.tongNV - 1;
//			try {
//				if(!d.exists()) {
//					d.createNewFile();
//				} 
//				FileWriter f = new FileWriter(d,true);
//				BufferedWriter bf = new BufferedWriter(f);
//				bf.write(dsNhanVien[k].getHo() + "/" + dsNhanVien[k].getTen() + "/" + dsNhanVien[k].getMaNhanVien() + '/' + dsNhanVien[k].getSdt());
//				
//			} catch (IOException ioe) {
//				System.out.println("Erorr!!!");
//			}
		}
		System.out.println("");
		if( m == 0) {
			System.out.println(" --- Hoan tat thao tac them nhan vien ---");
		}
	}	
	public void docfile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			int n = 0;
			FileReader fr = new FileReader(d);
			BufferedReader br = new BufferedReader(fr);
			String lines = br.readLine();
			while(lines != null) {
				String []line = lines.split("/");
				dsNhanVien[n] = new NhanVien(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]));
				n++;
				lines = br.readLine();
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("error!");
		}
		
	}
	public void ghifile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileWriter fr = new FileWriter(d, true);
			BufferedWriter br = new BufferedWriter(fr);
			for(NhanVien nv : dsNhanVien) {
				if(nv != null) {
					br.write(nv.getHo() + "/" + nv.getTen() + "/" + nv.getMaNhanVien() + "/" + nv.getSdt() + "/" + nv.getDeleted() + "\n");
				} else {
					break;
				}
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("error!");
		}
	}
	public void xemds() {
//		docfile();
        //xuat du
//        System.out.printf("%-15s %-5s %-10s %-15s","Ma nhan vien","Ho","Ten","SoDienThoai");
//        System.out.println("");
//        for(int i=0;i<this.tongNV;i++){
//            dsNhanVien[i].xuat(); System.out.println("");
//        }
		System.out.println(" ------------ Danh sach nhan vien ------------");
		System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
		System.out.println();
        for(NhanVien nv : dsNhanVien) {
        	if (nv.getDeleted() != 1) {
            	nv.xuat(); System.out.println("");
        	}
        }
	}
	public void xoa() {
		System.out.println(" ------------ Xoa nhan vien ------------");
		System.out.println("	1. Xoa nhan vien.");
		System.out.println("	2. Xem danh sach nhan vien da xoa.");
		System.out.println("	3. Thoat.");
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt();
		System.out.println();
		switch (n) {
			case 1:
				System.out.println(" ----------------------------------");
				System.out.print(" - Hay nhap ma nhan vien can xoa: ");
				String x = sc.next(); int m = 1;
				for(int i=0;i<this.tongNV;i++) {
					if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
						dsNhanVien[i].setDeleted(1); m++; this.soNVHH--;
					}
				}
				System.out.println("");
				if(m == 1) {
					System.out.println(" ----- Khong tim thay nhan vien ------");
				} else {
					System.out.println(" ------ Hoan tat thao tac xoa nhan vien ------");
				}
				break;
			case 2:
				System.out.println(" ------- Danh sach nhan vien da xoa --------");
				System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
				System.out.println("");
				for(NhanVien nv : dsNhanVien) {
			        	if (nv.getDeleted() == 1) {
			            	nv.xuat(); System.out.println("");
			        	}
			    }
				System.out.println("");
				 System.out.println("        1. Khoi phuc nhan vien.");
				 System.out.println("        2. Xoa vinh vien.");
				 System.out.println("        3. Thoat.");
				 System.out.print(" - Chon hanh dong: ");
				 int a = sc.nextInt();
				 System.out.println("");
				 switch (a) {
				 	case 1:
				 		System.out.println(" ----------- Khoi phuc ------------");
				 		System.out.print(" - Hay nhap ma nhan vien can khoi phuc: ");
				 		String maKP = sc.next(); int k = 1;
				 		for(int i=0;i<this.tongNV;i++) {
				 			if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(maKP) && dsNhanVien[i].getDeleted() == 1) {
				 				dsNhanVien[i].setDeleted(0); this.soNVHH++;
				 				k++; break;
				 			}
				 		}
				 		System.out.println("");
				 		if(k == 1) {
				 			System.out.println(" ------ Khong tim thay ma nhan vien ------");
				 		} else {
				 			System.out.println(" ------ Hoan tat khoi phuc nhan vien ------");
				 		}
				 		break;
				 	case 2: 
				 		System.out.println(" ---------- Xoa vinh vien ----------");
				 		System.out.print(" - Hay nhap ma nhan vien can xoa: ");
				 		String xoaVV = sc.next();
				 		int delete_point = -1;
						for(int i=0;i<this.tongNV;i++) {
							if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(xoaVV) && dsNhanVien[i].getDeleted() == 1) {
								delete_point = i;
								break;
							}
						}
						if(delete_point != -1) {
							for(int i=delete_point;i<this.tongNV-1;i++) {
								dsNhanVien[i] = dsNhanVien[i+1];
							} 
							this.tongNV--;
							dsNhanVien = Arrays.copyOf(dsNhanVien, this.tongNV);
							System.out.println("");
							System.out.println(" ------ Hoan tat thao tac xoa vinh vien ------");
						} else {
							System.out.println("");
							System.out.println(" ------ Khong tim thay ma nhan vien ------");
						} 
						break;
				 	case 3:
				 		break;
				 	default: 
				 		System.out.println(" Lua chon khong hop le, xin thu lai !!!");
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
		System.out.println(" ------------ Tim kiem nhan vien ------------");
		System.out.println("	1. Tim kiem theo ma nhan vien."); // khoang cach vao = 1 tab
		System.out.println("	2. Tim kiem theo ho ten nhan vien."); // ma va sdt deu la khoa chinh nen kh the tim kiem chung.
		System.out.println("	3. Tim kiem theo so dien thoai nhan vien.");
		System.out.println("	4. Thoat.");
		System.out.print(" - Chon hanh dong: ");
		int n = sc.nextInt(); int m = 1;
		switch (n) {
			case 1: 
				System.out.print(" - Hay nhap ma nhan vien can tim kiem: ");
				String x = sc.next(); 
				System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
				System.out.println("");
				for(int i=0;i<this.tongNV;i++) {
					if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
						dsNhanVien[i].xuat(); m++;
						break;
					}
				}
				break;
			case 2:
				System.out.print(" - Hay nhap ho nhan vien can tim kiem: ");
				String ho = sc.next();
				sc.nextLine();
				System.out.print(" - Hay nhap ten nhan vien can tim kiem: ");
				String ten = sc.nextLine();
				System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
				System.out.println("");
				for(int i=0;i<this.tongNV;i++) {
					if(dsNhanVien[i].getHo().equalsIgnoreCase(ho) && dsNhanVien[i].getTen().equalsIgnoreCase(ten) && dsNhanVien[i].getDeleted() != 1) {
						dsNhanVien[i].xuat(); m++;
						System.out.println("");
					}
				}
				break;
			case 3:
				System.out.print(" - Hay nhap sdt nhan vien can tim kiem: ");
				String sdt = sc.next();
				System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
				System.out.println("");
				for(int i=0;i<this.tongNV;i++) {
					if(dsNhanVien[i].getSdt().equalsIgnoreCase(sdt) && dsNhanVien[i].getDeleted() != 1) {
						dsNhanVien[i].xuat(); m++;
						break;
					}
				}
				break;
			case 4: 
				m = -1;
				break;
			default:
				System.out.println(" Lua chon kh hop le, vui long nhap lai !!!");
				timkiem();
				break;
		}
		if (m == 1) {
			System.out.println("");
			System.out.println(" ----- Khong tim thay nhan vien ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("");
			System.out.println(" ----- Hoan tat thao tac tim kiem -----");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua nhan vien ------------");
		System.out.print(" - Hay nhap ma nhan vien can sua: ");
		String x = sc.next(); int m = 1;
		// Nhap ma nhan vien sau do tuy chon cach sua.
		for (int i=0;i<this.tongNV;i++) {
			if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
				m++;
				System.out.println("	1. Sua ma nhan vien.");
				System.out.println("	2. Sua ho ten nhan vien.");
				System.out.println("	3. Sua so dien thoai.");
				System.out.println("	4. Sua tat ca thong tin.");
				System.out.println(" 	5. Thoat.");
				System.out.print(" - Chon hanh dong: ");
				int n = sc.nextInt();
				switch (n) {
					case 1:
						System.out.print(" - Nhap ma nhan vien: ");
						String ma = sc.next();
						dsNhanVien[i].setMaNhanVien(ma);
						break;
					case 2:
						System.out.print(" - Nhap ho nhan vien: ");
						String ho = sc.next();
						sc.nextLine();
						System.out.print(" - Nhap ten nhan vien: ");
						String ten = sc.nextLine();
						dsNhanVien[i].setHo(ho);
						dsNhanVien[i].setTen(ten);
						break;
					case 3: 
						System.out.print(" - Nhap sdt nhan vien: ");
						String sdt = sc.next();
						dsNhanVien[i].setSdt(sdt);
						break;
					case 4: 
						dsNhanVien[i].nhap();
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
		} else if(m == -1) {
			;
		} else {
			System.out.println("");
			System.out.println(" ----- Hoan tat sua thong tin nhan vien -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so nhan vien: " + this.soNVHH);
	}
}
