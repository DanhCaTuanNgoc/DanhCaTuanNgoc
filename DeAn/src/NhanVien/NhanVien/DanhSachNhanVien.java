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
	private NhanVien nv = new NhanVien();
	private int tongNV; 
	private int soNVHH; // so nhan vien hien huu ( bien dem cho so nv kh nam trong danh sach xoa ) 
	File d = new File("src/InputOutput/DanhSachNhanVien.txt");
	
	//constructor
	public DanhSachNhanVien(int n) {
		dsNhanVien = new NhanVien[n];
		this.tongNV=0;
		this.soNVHH=0;
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
		this.tongNV++; this.soNVHH++; 
		System.out.println(" 	$ Nhap thong tin nhan vien $ ");
		dsNhanVien = Arrays.copyOf(dsNhanVien, this.tongNV);
		dsNhanVien[this.tongNV - 1] = new NhanVien();
		dsNhanVien[this.tongNV - 1].nhap(); 
		System.out.println("");
		System.out.print(" Tiep tuc (1) | Dung lai (phim bat ky): ");
		int n = sc.nextInt();
		System.out.println("");
		if(n == 1) { them(); } 
		else { 
			System.out.println(" -------- Hoan tat thao tac --------");
		}
	}	
	public void docfile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileReader fr = new FileReader(d);
			BufferedReader br = new BufferedReader(fr);
			String lines = br.readLine();
			while(lines != null) {
				String []line = lines.split("/");
				dsNhanVien[tongNV] = new NhanVien(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]));
				if(line[4].equalsIgnoreCase("0")) {
					this.soNVHH++;
				}
				tongNV++;
				lines = br.readLine();
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("File Error!");
		}
		
	}
	public void ghifile() {
		try {
			if(!d.exists()) {
				d.createNewFile();
			}
			FileWriter er = new FileWriter(d);
			BufferedWriter cr = new BufferedWriter(er);
			cr.write("");
			cr.close();
			FileWriter fr = new FileWriter(d, true);
			BufferedWriter br = new BufferedWriter(fr);
			for(NhanVien nv : dsNhanVien) {
				if(nv != null) {
					br.write(nv.getMaNhanVien() + "/" + nv.getHo() + "/" + nv.getTen() + "/" + nv.getSdt() + "/" + nv.getDeleted() + "\n");
				} else {
					break;
				}
			}
			br.close();
		} catch(IOException ioe) {
			System.out.println("File Error!");
		}
	}
	public void xemds() {
		System.out.println(" ------------ Danh sach nhan vien ------------");
		System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
		System.out.println();
		int checkList = -1;
        for(NhanVien nv : dsNhanVien) {
        	if (nv != null && nv.getDeleted() != 1) {
            	nv.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
            System.out.println("");
        	System.out.println(" -------- Danh sach trong --------");
        }
	}
	public void xemdsXoa() {
		System.out.println(" ------------ Danh sach nhan vien da xoa ------------");
		System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
		System.out.println();
		int checkList = -1;
		for(NhanVien nv : dsNhanVien) {
			if(nv != null && nv.getDeleted() == 1) {
				nv.xuat(); System.out.println(""); checkList++;
			}
		}
		System.out.println("");
		if(checkList != -1) {
			System.out.print(" Xoa vinh vien(1) | Khoi phuc(2) | Thoat(0): ");
	        int n = sc.nextInt();
	        System.out.println("");
	        switch (n) {
	        	case 1:
	        		System.out.println(" ------------ Xoa vinh vien ------------");
	        		sc.nextLine();
	        		System.out.print(" - Nhap ma nhan vien can xoa: ");
	        		String maXoa = sc.nextLine();
	        		int delete_point = -1;
	        		for(int i = 0;i < this.tongNV;i++) {
	        			if(dsNhanVien[i] != null && dsNhanVien[i].getDeleted() == 1 && dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(maXoa)) {
	        				delete_point = i;
	        				break;
	        			}
	        		}
	        		if(delete_point != -1) {
	        			for(int i=delete_point;i<this.tongNV - 1;i++) {
	        				dsNhanVien[i] = dsNhanVien[i+1];
	        			}
	        			this.tongNV--;
	        			dsNhanVien = Arrays.copyOf(dsNhanVien, this.tongNV);
	        			System.out.println("");
	        			System.out.println(" -------- Hoan tat thao tac --------");
	        		} else { 
	        			System.out.println("");
	        			System.out.println(" -------- Khong tim thay ma nhan vien --------");
	        		} 
	        		break;
	        	case 2:
	        		System.out.println(" ------------ Khoi phuc ------------");
	        		sc.nextLine();
	        		System.out.print(" - Nhap ma nhan vien can khoi phuc: ");
	        		String maKP = sc.nextLine(); int m = 0;
	        		for(NhanVien nv : dsNhanVien) {
	        			if(nv != null && nv.getDeleted() == 1 && nv.getMaNhanVien().equalsIgnoreCase(maKP)) {
	        				nv.setDeleted(0); m++; this.soNVHH++;
	        				System.out.println("");
	        				System.out.println(" -------- Hoan tat thao tac --------");
	        				break;
	        			}
	        		}
	        		if(m != 1) {
	        			System.out.println("");
	        			System.out.println(" -------- Khong tim thay ma nhan vien --------");
	        		}
	        	case 0:
	        		break;
	        	default:
	        		System.out.println(" Lua chon khong hop le, xin thu lai !!!");
	        		xemdsXoa();
	        		break;
	        }
		} else {
			System.out.println(" -------- Danh sach trong --------");
		}
        
	}
	public void xoa() {
		System.out.println(" ------------ Xoa nhan vien ------------");
		System.out.print(" - Hay nhap ma nhan vien can xoa: ");
		String x = sc.next(); int m = 0;
		for(int i=0;i<this.tongNV;i++) {
			if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
				dsNhanVien[i].setDeleted(1); m++; this.soNVHH--;
				System.out.println("");
				System.out.println(" -------- Hoan tat thao tac --------");
			}
		}
		if(m != 1) {
			System.out.println("");
			System.out.println(" -------- Khong tim thay ma nhan vien --------");
		}
	}
	public void timkiem() {
		System.out.println(" ------------ Tim kiem nhan vien ------------");
		System.out.print(" Ma nhan vien(1) | Ho ten(2) | So dien thoai(3) | Thoat(0): ");
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
			case 0: 
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
		System.out.println("");
		// Nhap ma nhan vien sau do tuy chon cach sua.
		for (int i=0;i<this.tongNV;i++) {
			if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
				System.out.print(" Ma nhan vien(1) | Ho ten(2) | So dien thoai(3) | Tat ca(4) | Thoat(0): ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma nhan vien: ");
						String ma = sc.next();
						dsNhanVien[i].setMaNhanVien(ma);
						break;
					case 2:
						System.out.print(" - Sua ho nhan vien: ");
						String ho = sc.next();
						sc.nextLine();
						System.out.print(" - Sua ten nhan vien: ");
						String ten = sc.nextLine();
						dsNhanVien[i].setHo(ho);
						dsNhanVien[i].setTen(ten);
						break;
					case 3: 
						System.out.print(" - Sua sdt nhan vien: ");
						String sdt = sc.next();
						dsNhanVien[i].setSdt(sdt);
						break;
					case 4: 
						dsNhanVien[i].nhap();
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
			System.out.println(" ------ Khong tim thay nhan vien ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("");
			System.out.println(" ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so nhan vien: " + this.soNVHH);
	}
}
