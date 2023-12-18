package Ve;

import java.util.Scanner;

import ChuyenBay.DanhSachChuyenBay;
import Ve.DanhSachVe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import Interface.Pthuc;
import ChiTietHoaDon.DanhSachCTHoaDon;

public class DanhSachVe implements Pthuc {
	private Ve[] dsVe;
	private int SoVept,SoVetg;
	private int SoVeHH,tongVe;
	DanhSachChuyenBay ds =new DanhSachChuyenBay(100);
	DanhSachCTHoaDon cthd = new DanhSachCTHoaDon(100);
	Scanner sc = new Scanner(System.in);
	File d=new File("src/InputOutput/DanhSachVe.txt");
	//CONSTRUCTOR
	public DanhSachVe(int n) {
		dsVe = new Ve[n];
		this.tongVe=0;
		this.SoVeHH = 0;
		this.SoVept=0;
		this.SoVetg=0;
	}
	public DanhSachVe(Ve dsVe[], int tongVe, int SoveHH) {
		this.dsVe = dsVe;
		this.tongVe = tongVe;
		this.SoVeHH = SoveHH;
	}
	public DanhSachVe(DanhSachVe a) {
		this.dsVe = a.dsVe;
		this.tongVe = a.tongVe;
		this.SoVeHH = a.SoVeHH;
	}

	public void setDsVe(Ve[] dsVe) {
		this.dsVe = dsVe;
	}

	public int getSoVeHH() {
		return SoVeHH;
	}

	public void setSoVeHH(int soVeHH) {
		SoVeHH = soVeHH;
	}

	public int getTongVe() {
		return tongVe;
	}

	public void setTongVe(int tongVe) {
		this.tongVe = tongVe;
	}

	//doc file
    public void docfile(){
		tongVe=0;
        try{
        if (!d.exists()){
            d.createNewFile();
        }
            FileReader fr=new FileReader(d);
            BufferedReader br=new BufferedReader(fr);
            String lines=br.readLine();
            while (lines!=null) {
                String []line=lines.split("/");
                if(line[0].equals("ve pho thong")){
                    dsVe[tongVe]=new VePhoThong(line[1],line[2],Integer.parseInt(line[3]),line[4],Integer.parseInt(line[5]));
                    if(line[5].equals("0")){SoVeHH++; this.SoVept++;}
                }else if(line[0].equals("ve thuong gia")){
                    dsVe[tongVe]=new VeThuongGia(line[1],line[2],Integer.parseInt(line[3]),line[4],line[5],Integer.parseInt(line[6]));
                    if(line[6].equals("0")){SoVeHH++; this.SoVetg++;}
				}
                tongVe++;
                lines=br.readLine();
            }
            br.close();
        }catch(IOException ioe){System.out.println("error!");}

    }
    
    //luu file
    public void ghifile(){
        try{
        if (!d.exists()){
            d.createNewFile();
        }
			FileWriter er = new FileWriter(d);
			BufferedWriter cr = new BufferedWriter(er);
			cr.write("");
			cr.close();
            FileWriter fr=new FileWriter(d,true);
            BufferedWriter bw=new BufferedWriter(fr);
            for(Ve ve1:dsVe){
                if(ve1!=null){
                if(ve1 instanceof VePhoThong){
                    VePhoThong vpt=(VePhoThong) ve1;
                    bw.write("ve pho thong/"+vpt.getMaVe()+"/"+vpt.getMaChuyenBay()+"/"+vpt.getGia()+"/"+vpt.getHangVe()+"/"+vpt.getDeleted()+"\n");
                }
                else {
                    VeThuongGia vtg=(VeThuongGia) ve1;
                    bw.write("ve thuong gia/"+vtg.getMaVe()+"/"+vtg.getMaChuyenBay()+"/"+vtg.getGia()+"/"+vtg.getMaPhongCho()+"/"+vtg.getDichVuVIP()+"/"+vtg.getDeleted()+"\n");
                }
            }}
            bw.close();
        }catch(IOException ioe){System.out.println("error!");}
    }
	
	public void them(){
		System.out.println(" ------------ Them ve ------------");
		System.out.print(" Ve pho thong(1) | Ve thuong gia(2) : ");
		int n =sc.nextInt();
		this.SoVeHH++;this.tongVe++;
		if(n == 1){
			System.out.println(" 	$ Nhap thong tin ve pho thong $ ");
			dsVe = Arrays.copyOf(dsVe, this.tongVe);
			VePhoThong vpt=new VePhoThong();
			vpt.nhap();
			dsVe[this.tongVe - 1] = vpt;
		}else if(n == 2){
			System.out.println(" 	$ Nhap thong tin ve thuong gia $ ");
			dsVe = Arrays.copyOf(dsVe, this.tongVe);
			VeThuongGia vtg=new VeThuongGia();
			vtg.nhap();
			dsVe[this.tongVe - 1] = vtg;
		}else {System.out.println("\n Nhap sai! vui long nhap lai! ");them();}
		System.out.println("");
		ghifile();
		System.out.print(" Tiep tuc (1) | Dung lai (phim bat ky): ");
		n = sc.nextInt();
		System.out.println("");
		if(n == 1) { them(); } 
		else { 
			System.out.println(" -------- Hoan tat thao tac --------");
		}
	}
    public void xemdsPT(){
        System.out.println("\t ------------ Danh sach ve pho thong ------------");
		System.out.printf("| %-10s | %-15s | %-15s | %-10s","Ma ve","Ma chuyen bay","Gia","Hang ve");
		System.out.println();
		int checkList = -1;
        for(Ve ve : dsVe) {
        	if (ve instanceof VePhoThong && ve != null && ve.getDeleted() != 1) {
                VePhoThong vpt=(VePhoThong)ve;
            	vpt.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
    }
    public void xemdsTG(){
        System.out.println("\t\t ------------ Danh sach ve thuong gia------------");
		System.out.printf("| %-10s | %-15s | %-15s | %-14s | %-10s ","Ma ve","Ma chuyen bay","Gia","Ma phong cho","Dich vi vip");
		System.out.println();
		int checkList = -1;
        for(Ve ve : dsVe) {
        	if (ve instanceof VeThuongGia && ve != null && ve.getDeleted() != 1) {
                VeThuongGia vtg=(VeThuongGia)ve;
            	vtg.xuat(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
    }
    public void xemdsve(){
        System.out.println("\t ------------ Danh sach ve ------------");
		System.out.printf("| %-10s | %-15s | %-15s | %-10s","Ma ve","Ma chuyen bay","Gia","Loai ve");
		System.out.println();
		int checkList = -1;
        for(Ve ve : dsVe) {
        	if (ve != null && ve.getDeleted() != 1) {
            	System.out.printf("| %-10s | %-15s | %-15s ",ve.getMaVe(),ve.getMaChuyenBay(),ve.getGia());
				ve.loaive(); System.out.println(""); checkList++;
        	}
        }
        if(checkList == -1) {
        	System.out.println("\n	........Danh sach trong........");
        }
    }
    public void xemds(){
        System.out.print(" Xem tat ca(1) | Xem pho thong(2) | Xem thuong gia(3): ");
        int n=sc.nextInt();
        System.out.println("");
        switch (n) {
            case 1:
                xemdsve();
                System.out.println("");
				sc.nextLine();
				System.out.print(" Thoat (phim bat ky): ");
				sc.nextLine();
                break;
            case 2:
                xemdsPT();
                System.out.println("");
				sc.nextLine();
				System.out.print(" Thoat (phim bat ky): ");
				sc.nextLine();
				break;
            case 3:
                xemdsTG();
                System.out.println("");
				sc.nextLine();
				System.out.print(" Thoat (phim bat ky): ");
				sc.nextLine();
				break;
            default:
                xemds();
                break;
        }
    }
	public void xoa(){
		cthd.docfile();
		System.out.println(" ------------ Xoa ve ------------");
		System.out.print(" - Hay nhap ma ve can xoa | Thoat(0): ");
		String x = sc.next(); int m = 0; 
		if(cthd.Check_Available(x)) {
			System.out.print("\n ----- Khong the xoa ve da ban -----");
		} else {
			if(x.equalsIgnoreCase("0")) {
				;
			} else {
				for(int i=0;i<this.tongVe;i++) {
					if(dsVe[i].getMaVe().equalsIgnoreCase(x) && dsVe[i].getDeleted() != 1) {
						m++; dsVe[i].setDeleted(1);
						System.out.print("\n -------- Hoan tat thao tac --------");
						break;
					}
				}
					if(m == 0) {
					System.out.print("\n -------- Khong tim thay ma ve --------");
					}
				}
		}
	}
	public void timkiem(){
		System.out.println(" ------------ Tim kiem ------------");
		System.out.print(" + Ma ve ( x de bo qua): ");
		String tk1= sc.next();
		System.out.print(" + Ma chuyen bay ( x de bo qua): ");
		String tk2= sc.next();
		System.out.print(" + Gia tu : ");
		int tk3= sc.nextInt();
		System.out.print(" + Den : ");
		int tk4= sc.nextInt();
 		System.out.println();
		System.out.printf("| %-10s | %-15s | %-15s | %-10s ","Ma ve","Ma chuyen bay","Gia","Loai ve");
		System.out.println();
		int m=0;
		for(int i=0;i<this.tongVe;i++) {
			if((dsVe[i].getMaVe().equalsIgnoreCase(tk1)||tk1.equalsIgnoreCase("x"))
			&&(dsVe[i].getMaVe().equalsIgnoreCase(tk2)||tk2.equalsIgnoreCase("x"))
			&&(dsVe[i].getGia()>=tk3)
			&&(dsVe[i].getGia()<=tk4)
			&& dsVe[i].getDeleted() != 1){
				System.out.printf("| %-10s | %-15s | %-15s ",dsVe[i].getMaVe(),dsVe[i].getMaChuyenBay(),dsVe[i].getGia());
				dsVe[i].loaive(); m++;
				System.out.println("");
			}
		}
		if(m == 0) {
			System.out.println("\n 	.....Khong tim thay ket qua tim kiem.....");
		}
	}
	public void sua() {
		cthd.docfile();
		System.out.println(" ------------ Sua ve ------------");
		System.out.print(" - Hay nhap ma ve can sua: ");
		String x = sc.next(); int m = 1;
		if(cthd.Check_Available(x)) {
			System.out.print("\n ----- Khong the sua ve da ban -----");
		} else {
			System.out.println("");
			// Nhap ma chuyen bay sau do tuy chon cach sua.
			for (int i=0;i<this.tongVe;i++) {
				if(dsVe[i].getMaVe().equalsIgnoreCase(x) && dsVe[i].getDeleted() != 1) {
					System.out.println(" (1) Ma ve");
					System.out.println(" (2) Ma chuyen bay");
					System.out.println(" (3) Gia tien");
					System.out.println(" (4) Doi loai ve");
					System.out.println(" (0) Thoat");
					System.out.print(" - Lua chon gia tri can sua: ");
					int n = sc.nextInt(); m++;
					switch (n) {
						case 1:
							System.out.print(" - Sua ma ve: ");
							String ma = sc.next();
							while(Check_Available(ma)){
								System.out.println("\t !! Ma ve da ton tai !!");
								System.out.print(" - Sua ma ve: ");
								ma = sc.next();
							}
							dsVe[i].setMaVe(ma);
							break;
						case 2:
							System.out.println(" - Sua ma chuyen bay: ");
							String macb = sc.next();
							while(!ds.Check_Available(macb)){
								System.out.println("\t !! Ma ve da toi tai !!");
								System.out.println(" - Sua ma chuyen bay: ");
								macb=sc.next();
	        					}
							dsVe[i].setMaChuyenBay(macb);
							break;
						case 3: 
							System.out.print(" - Sua gia tien: ");
							int gt=sc.nextInt();
							dsVe[i].setGia(gt);
							break;
						case 4:
							while (true) {
								System.out.print(" - Doi sang: (1)Pho thong | (2)Thuong gia: ");
								x=sc.next();
								if(x.equals("1")){
									System.out.print(" - Nhap hang ve: ");
									String hve=sc.next();
									dsVe[i]=new VePhoThong(dsVe[i].getMaVe(),dsVe[i].getMaChuyenBay(),dsVe[i].getGia(),hve,0);
									return;
								}else if (x.equals("2")) {
									System.out.print(" - Nhap ma phong cho: ");
									String mpc=sc.next();
									System.out.print(" - Nhap dich vu vip: ");
									String dcv=sc.next();
									dsVe[i]=new VeThuongGia(dsVe[i].getMaVe(),dsVe[i].getMaChuyenBay(),dsVe[i].getGia(),mpc,dcv,0);
									return;
								} else {
									System.err.println(" Chon sai! Vui long chon lai!");
								}							
							}
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
				System.out.println("\n ------ Khong tim thay ve ------");
			} else if(m == -1) {
				;
			} else {
				System.out.println("\n ----- Hoan tat thao tac -----");
			}
		}
	}
	public void thongke(){
		System.out.println(" - So ve hien co : " + SoVeHH);
		System.out.println("\t + Ve thuong gia : " + this.SoVetg);
		System.out.println("\t + Ve pho thong : " + this.SoVept);
	}
	public boolean Check_Available(String mave) {
		docfile();
		for(int i=0;i<this.tongVe;i++) {
			if(dsVe[i] != null && dsVe[i].getMaVe().equalsIgnoreCase(mave)) {
				 return true;
			}
		}
		return false;
	}
	public void truyXuatCB() {
		ds.docfile();
		System.out.println(" -------- Truy xuat chuyen bay --------");
		System.out.print(" - Nhap ma ve can truy xuat chuyen bay | Thoat(0): ");
		String x = sc.nextLine();
		if(x.equals("0")) {
			; 
		} else {

			for(int i=0;i<this.tongVe;i++) {
				if(dsVe[i].getDeleted() == 0 && dsVe[i].getMaVe().equalsIgnoreCase(x)) {
					ds.truyXuat(dsVe[i].getMaChuyenBay()); 
					break;
				}
			}
		}
	}
	public int tinhgiamgia(String mve,int km){
		int i;
		for(i=0;i<this.tongVe;i++) {
			if(dsVe[i] != null && dsVe[i].getMaVe().equalsIgnoreCase(mve)) {
				break;
			}
		}
		return dsVe[i].getGia()-(km*dsVe[i].getGia())/100;
	}
	public int tongtien(){
		docfile();
		int tong=0;
		for(int i=0;i<tongVe;i++){
			if (dsVe[i].getDeleted() == 0) {
				if(dsVe[i] instanceof VePhoThong){
					VePhoThong vpt=(VePhoThong)dsVe[i];
					if(vpt.getHangVe().equalsIgnoreCase("economy")){tong=tong+500000;}
					else if(vpt.getHangVe().equalsIgnoreCase("Premium Economy")){tong=tong+1000000;}
					else if(vpt.getHangVe().equalsIgnoreCase("Business")){tong=tong+1500000;}
				}else {
					VeThuongGia vtg=(VeThuongGia)dsVe[i];
					if(vtg.getDichVuVIP().equalsIgnoreCase("A")){tong=tong+2000000;}
					else if(vtg.getDichVuVIP().equalsIgnoreCase("B")){tong=tong+2500000;}
					else if(vtg.getDichVuVIP().equalsIgnoreCase("C")){tong=tong+3000000;}
				}			
			}
		}
		return tong;
	}
}