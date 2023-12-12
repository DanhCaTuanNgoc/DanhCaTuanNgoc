package NhanVien;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		String n = sc.next();
		System.out.println("");
		if(n.equals("1")) { them(); } 
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
				dsNhanVien[tongNV] = new NhanVien(line[0], line[1], line[3], line[2], Integer.parseInt(line[4]));
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
        	System.out.println("\n	........Danh sach trong........");
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
	        			System.out.println("\n -------- Hoan tat thao tac --------");
	        		} else { 
	        			System.out.println("\n -------- Khong tim thay ma nhan vien --------");
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
	        				System.out.println("\n -------- Hoan tat thao tac --------");
	        				break;
	        			}
	        		}
	        		if(m == 0) {
	        			System.out.println("\n -------- Khong tim thay ma nhan vien --------");
	        		}
	        	case 0:
	        		break;
	        	default:
	        		System.out.println(" Lua chon khong hop le, xin thu lai !!!");
	        		xemdsXoa();
	        		break;
	        }
		} else {
			System.out.println("	........Danh sach trong........");
		}
        
	}
	public void xoa() {
		System.out.println(" ------------ Xoa nhan vien ------------");
		System.out.print(" - Hay nhap ma nhan vien can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0; int delete_point = -1;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongNV;i++) {
				if(dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(x) && dsNhanVien[i].getDeleted() != 1) {
					m++; delete_point = i;
					System.out.print(" Cho vao danh sach xoa(1) | Xoa vinh vien(2): ");
					int n = sc.nextInt();
					switch(n) {
						case 1:
							dsNhanVien[i].setDeleted(1); this.soNVHH--;
							System.out.println("");
							System.out.println(" -------- Hoan tat thao tac --------");
							break;
						case 2: 
							if(delete_point != -1) {
								for(int j=delete_point;j < this.tongNV - 1;j++) {
									dsNhanVien[j] = dsNhanVien[j+1]; 
								}
								this.tongNV --; this.soNVHH --;
								dsNhanVien = Arrays.copyOf(dsNhanVien, this.tongNV);
			        			System.out.println("\n -------- Hoan tat thao tac --------");
							}
							break;
						default :
							System.out.println(" Lua chon khong hop le, xin thu lai!!!");
							xoa();
							break;
					}
					break;
				} 
			}
			if(m == 0) {
				System.out.println("\n -------- Khong tim thay ma nhan vien --------");
			}
		}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma nhan vien ( x de bo qa): ");
		String tk1= sc.next();
		System.out.print(" + So dien thoi ( x de bo qa): ");
		String tk2= sc.next();
		System.out.print(" + Ho ( x de bo qa): ");
		String tk3= sc.next();
		System.out.print(" + Ten ( x de bo qa): ");
		sc.nextLine();
		String tk4= sc.nextLine(); int m = 0;
		System.out.println();
		System.out.printf("%-15s %-7s %-15s %-10s","Ma nhan vien","Ho","Ten","SoDienThoai");
		System.out.println();
		for(int i=0;i<this.tongNV;i++) {
			if((dsNhanVien[i].getMaNhanVien().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsNhanVien[i].getSdt().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsNhanVien[i].getHo().equalsIgnoreCase(tk3)||tk3.equalsIgnoreCase("x"))
			&&(dsNhanVien[i].getTen().equalsIgnoreCase(tk4)||tk4.equalsIgnoreCase("x"))
			&& dsNhanVien[i].getDeleted() != 1){
				dsNhanVien[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
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
			System.out.println("\n ------ Khong tim thay nhan vien ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so nhan vien hien co: " + this.soNVHH);
	}
}
