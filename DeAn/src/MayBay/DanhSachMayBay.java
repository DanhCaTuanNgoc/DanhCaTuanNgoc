package MayBay;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachMayBay {
	private MayBay dsMayBay[];
	private int tongMayBay; 
	private int soMBHH;
	File d = new File("src/InputOutput/DanhSachMayBay.txt");
	
	//constructor
	public DanhSachMayBay(int n) {
		dsMayBay = new MayBay[n];
		this.tongMayBay=0;
		this.soMBHH = 0;
	}
	public DanhSachMayBay(MayBay dsMayBay[], int tongMayBay, int soMBHH) {
		this.dsMayBay = dsMayBay;
		this.tongMayBay = tongMayBay;
		this.soMBHH = soMBHH;
	}
	public DanhSachMayBay(DanhSachMayBay a) {
		this.dsMayBay = a.dsMayBay;
		this.tongMayBay = a.tongMayBay;
		this.soMBHH = a.soMBHH;
	}
	
	// get/set
	public MayBay[] getDsMayBay() {
		return dsMayBay;
	}
	public void setDsMayBay(MayBay[] dsMayBay) {
		this.dsMayBay = dsMayBay;
	}
	public int gettongMayBay() {
		return tongMayBay;
	}
	public void settongMayBay(int tongMayBay) {
		this.tongMayBay = tongMayBay;
	}
	public void setSMBHH(int s) {
		this.soMBHH = s;
	}
	public int getSoMBHH() {
		return soMBHH;
	}
	// methods 
	Scanner sc = new Scanner(System.in);
	public void them() {
		System.out.println(" ------------ Them may bay ------------");
		this.tongMayBay++; this.soMBHH++;
		System.out.println(" 	$ Nhap thong tin may bay $ ");
		dsMayBay = Arrays.copyOf(dsMayBay, this.tongMayBay);
		dsMayBay[this.tongMayBay - 1] = new MayBay();
		dsMayBay[this.tongMayBay - 1].nhap(); 
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
				dsMayBay[tongMayBay] = new MayBay(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				if(line[3].equalsIgnoreCase("0")) {
					this.soMBHH++;
				}
				tongMayBay++;
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
			for(MayBay nv : dsMayBay) {
				if(nv != null) {
					br.write(nv.getMaMayBay() + "/" + nv.getTenMayBay() + "/" + nv.getSoGhe() + "/" + nv.getDeleted() + "\n");
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
		System.out.println(" ------------ Danh sach may bay ------------");
		System.out.printf("%-15s %-15s %-10s","Ma may bay","Ten may bay","So ghe");
		System.out.println();
		int checkList = -1;
        for(MayBay nv : dsMayBay) {
        	if (nv != null && nv.getDeleted() != 1) {
            	nv.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
	}
	public void xemdsXoa() {
		System.out.println(" ------------ Danh sach may bay da xoa ------------");
		System.out.printf("%-15s %-15s %-10s","Ma may bay","Ten may bay","So ghe");
		System.out.println();
		int checkList = -1;
		for(MayBay nv : dsMayBay) {
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
	        		System.out.print(" - Nhap ma may bay can xoa: ");
	        		String maXoa = sc.nextLine();
	        		int delete_point = -1;
	        		for(int i = 0;i < this.tongMayBay;i++) {
	        			if(dsMayBay[i] != null && dsMayBay[i].getDeleted() == 1 && dsMayBay[i].getMaMayBay().equalsIgnoreCase(maXoa)) {
	        				delete_point = i;
	        				break;
	        			}
	        		}
	        		if(delete_point != -1) {
	        			for(int i=delete_point;i<this.tongMayBay - 1;i++) {
	        				dsMayBay[i] = dsMayBay[i+1];
	        			}
	        			this.tongMayBay--; this.soMBHH--;
	        			dsMayBay = Arrays.copyOf(dsMayBay, this.tongMayBay);
	        			System.out.println("\n -------- Hoan tat thao tac --------");
	        		} else { 
	        			System.out.println("\n -------- Khong tim thay ma may bay --------");
	        		} 
	        		break;
	        	case 2:
	        		System.out.println(" ------------ Khoi phuc ------------");
	        		sc.nextLine();
	        		System.out.print(" - Nhap ma may bay can khoi phuc: ");
	        		String maKP = sc.nextLine(); int m = 0;
	        		for(MayBay nv : dsMayBay) {
	        			if(nv != null && nv.getDeleted() == 1 && nv.getMaMayBay().equalsIgnoreCase(maKP)) {
	        				nv.setDeleted(0); m++; this.soMBHH++;
	        				System.out.println("\n -------- Hoan tat thao tac --------");
	        				break;
	        			}
	        		}
	        		if(m == 0) {
	        			System.out.println("\n -------- Khong tim thay ma may bay --------");
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
		System.out.println(" ------------ Xoa may bay ------------");
		System.out.print(" - Hay nhap ma may bay can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0; int delete_point = -1;
		if(x.equalsIgnoreCase("0")) {
			;
		} else {
			for(int i=0;i<this.tongMayBay;i++) {
				if(dsMayBay[i].getMaMayBay().equalsIgnoreCase(x) && dsMayBay[i].getDeleted() != 1) {
					m++; delete_point = i;
					System.out.print(" Cho vao danh sach xoa(1) | Xoa vinh vien(2): ");
					int n = sc.nextInt();
					switch(n) {
						case 1:
							dsMayBay[i].setDeleted(1); this.soMBHH--;
							System.out.println("");
							System.out.println(" -------- Hoan tat thao tac --------");
							break;
						case 2: 
							if(delete_point != -1) {
								for(int j=delete_point;j < this.tongMayBay - 1;j++) {
									dsMayBay[j] = dsMayBay[j+1]; 
								}
								this.tongMayBay --; this.soMBHH--;
								dsMayBay = Arrays.copyOf(dsMayBay, this.tongMayBay);
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
				System.out.println("\n -------- Khong tim thay ma may bay --------");
			}
		}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma may bay ( x de bo qa): ");
		String tk1= sc.nextLine();
		System.out.print(" + Ten may bay ( x de bo qa): ");
		String tk2= sc.nextLine(); 
		System.out.print(" + So ghe (x de bo qua): ");
		String tk3=sc.nextLine();
		 int m = 0;
		System.out.println();
		System.out.printf("%-15s %-15s %-10s","Ma may bay","Ten may bay","So ghe");
		System.out.println();
		for(int i=0;i<this.tongMayBay;i++) {
			if((dsMayBay[i].getMaMayBay().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsMayBay[i].getTenMayBay().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(String.valueOf(dsMayBay[i]).equals(tk3) || tk3.equalsIgnoreCase("x"))
			&& dsMayBay[i].getDeleted() != 1){
				dsMayBay[i].xuat(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		System.out.println(" ------------ Sua may bay ------------");
		System.out.print(" - Hay nhap ma may bay can sua: ");
		String x = sc.next(); int m = 1;
		System.out.println("");
		// Nhap ma may bay sau do tuy chon cach sua.
		for (int i=0;i<this.tongMayBay;i++) {
			if(dsMayBay[i].getMaMayBay().equalsIgnoreCase(x) && dsMayBay[i].getDeleted() != 1) {
				System.out.print(" Ma may bay(1) | Ten may bay(2) | So ghe(3) | Tat ca(4) | Thoat(0): ");
				int n = sc.nextInt(); m++;
				switch (n) {
					case 1:
						System.out.print(" - Sua ma may bay: ");
						String ma = sc.next();
						dsMayBay[i].setMaMayBay(ma);
						break;
					case 2:
						System.out.print(" - Sua ten may bay: ");
						sc.nextLine();
						String ten = sc.nextLine();
						dsMayBay[i].setTenMayBay(ten);
						break;
					case 3: 
						System.out.print(" - Sua so ghe: ");
						int soghe = sc.nextInt();
						dsMayBay[i].setSoGhe(soghe);
						break;
					case 4: 
						dsMayBay[i].nhap();
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
			System.out.println("\n ------ Khong tim thay may bay ------");
		} else if(m == -1) {
			;
		} else {
			System.out.println("\n ----- Hoan tat thao tac -----");
		}
	}
	public void thongke() {
		System.out.println(" ------------ Thong ke ------------");
		System.out.println(" - Tong so may bay: " + this.soMBHH);
	}
}
