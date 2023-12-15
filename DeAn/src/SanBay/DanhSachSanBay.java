package SanBay;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachSanBay {
	private SanBay dsSanBay[];
	private int tongSan; 
	private int soSBHH; // số sân bay hiện hữu.
	File d = new File("src/InputOutput/DanhSachSanBay.txt");
	
	//constructor
	public DanhSachSanBay(int n) {
		dsSanBay = new SanBay[n];
		this.tongSan=0;
		this.soSBHH = 0;
	}
	public DanhSachSanBay(SanBay dsSanBay[], int tongSan, int soSBHH) {
		this.dsSanBay = dsSanBay;
		this.tongSan = tongSan;
		this.soSBHH = soSBHH;
	}
	public DanhSachSanBay(DanhSachSanBay a) {
		this.dsSanBay = a.dsSanBay;
		this.tongSan = a.tongSan;
		this.soSBHH = a.soSBHH;
	}
	
	// get/set
	public SanBay[] getDsSanBay() {
		return dsSanBay;
	}
	public void setDsSanBay(SanBay[] dsSanBay) {
		this.dsSanBay = dsSanBay;
	}
	public int gettongSan() {
		return tongSan;
	}
	public void settongSan(int tongSan) {
		this.tongSan = tongSan;
	}
	public void setSoSBHH(int s) {
		this.soSBHH = s;
	}
	public int getSoSBHH () {
		return soSBHH;
	}
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them san bay ------------");
		this.tongSan++; this.soSBHH++;
		System.out.println(" 	$ Nhap thong tin san bay $ ");
		dsSanBay = Arrays.copyOf(dsSanBay, this.tongSan);
		dsSanBay[this.tongSan - 1] = new SanBay();
		dsSanBay[this.tongSan - 1].nhap(); 
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
				dsSanBay[tongSan] = new SanBay(line[0], line[1], line[2], Integer.parseInt(line[3]));
				if(line[3].equalsIgnoreCase("0")) {
					this.soSBHH++;
				}
				tongSan++;
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
			for(SanBay nv : dsSanBay) {
				if(nv != null) {
					br.write(nv.getMaSanBay() + "/" + nv.getTenSanBay() + "/" + nv.getDiaChiSanBay() + "/" + nv.getDeleted() + "\n");
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
		System.out.println("\t ------------ Danh sach san bay ------------");
		System.out.printf("| %-10s | %-30s | %-15s","Ma san bay","Ten san bay","Dia chi san bay");
		System.out.println();
		int checkList = -1;
        for(SanBay nv : dsSanBay) {
        	if (nv != null && nv.getDeleted() != 1) {
            	nv.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
	}
	public void xoa() {
		System.out.println(" ------------ Xoa san bay ------------");
		System.out.print(" - Hay nhap ma san bay can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0; int delete_point = -1;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongSan;i++) {
				if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(x) && dsSanBay[i].getDeleted() != 1) {
					m++; 
					dsSanBay[i].setDeleted(1); this.soSBHH--;
					System.out.println("");
					System.out.println(" -------- Hoan tat thao tac --------");
					break;
				} 
			}
			if(m == 0) {
				System.out.println("\n -------- Khong tim thay ma san bay --------");
			}
		}	
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma san bay ( x de bo qa): ");
		String tk1= sc.next();
		System.out.print(" + Ten san bay ( x de bo qa): ");
		sc.nextLine();
		String tk2= sc.nextLine();
		System.out.print(" + Dia chi san bay ( x de bo qa): ");
		String tk3= sc.nextLine(); int m = 0;
		System.out.println();
		System.out.printf("| %-10s | %-30s | %-15s","Ma san bay","Ten san bay","Dia chi san bay");
		System.out.println();
		for(int i=0;i<this.tongSan;i++) {
			if((dsSanBay[i].getMaSanBay().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsSanBay[i].getTenSanBay().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsSanBay[i].getDiaChiSanBay().equalsIgnoreCase(tk3)||tk3.equalsIgnoreCase("x"))
			&& dsSanBay[i].getDeleted() != 1){
				dsSanBay[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua san bay ------------");
		System.out.print(" - Hay nhap ma san bay can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma san bay sau do tuy chon cach sua.
		for (int i=0;i<this.tongSan;i++) {
			if(dsSanBay[i].getMaSanBay().equalsIgnoreCase(x) && dsSanBay[i].getDeleted() != 1) {
				System.out.print(" Ma san bay(1) | Ten san bay(2) | Dia chi san bay(3) | Tat ca(4) | Thoat(0): ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma san bay: ");
						String ma = sc.next();
						dsSanBay[i].setMaSanBay(ma);
						break;
					case 2:
						System.out.print(" - Sua ten san bay: ");
						sc.nextLine();
						String ten = sc.nextLine();
						dsSanBay[i].setTenSanBay(ten);
						break;
					case 3: 
						System.out.print(" - Sua dia chi san bay: ");
						sc.nextLine();
						String dc = sc.nextLine();
						dsSanBay[i].setDiaChiSanBay(dc);
						break;
					case 4: 
						dsSanBay[i].nhap();
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
			System.out.println("\n ------ Khong tim thay san bay ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so san bay: " + this.soSBHH);
	}
	
	// Kiem tra du lieu
	public boolean Check_Available(String masanbay) {
		for(int i=0;i<this.tongSan;i++) {
			if(dsSanBay[i] != null && dsSanBay[i].getMaSanBay().equalsIgnoreCase(masanbay)) {
				 return true;
			}
		}
		return false;
	}
	
	// truy xuat du lieu
	public void truyXuat(String masanabay) {
		for(int i=0;i<this.tongSan;i++) {
			if(dsSanBay[i] != null && dsSanBay[i].getMaSanBay().equalsIgnoreCase(masanabay)) {
				dsSanBay[i].xuat();
				break;
			}
		}
	}
	
}