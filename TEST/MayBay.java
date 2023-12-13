package TEST;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MayBay {
	private String maMayBay;
	private String tenMayBay;
	private int soGhe;
	private int deleted = 0;
	// constructor
	public MayBay() {
		maMayBay = "";
		tenMayBay = "";
		soGhe = 0;
		deleted = 0;
	}
	public MayBay(String mamaybay,String tenmaybay,int soghe, int deleted) {
		this.maMayBay = mamaybay;
		this.tenMayBay = tenmaybay;
		this.soGhe = soghe;
		this.deleted = deleted;
	}
	public MayBay(MayBay a) {
		this.maMayBay = a.maMayBay;
		this.tenMayBay = a.tenMayBay;
		this.soGhe = a.soGhe;
		this.deleted = a.deleted;
    }
	// get/set
	public String getMaMayBay() {
		return maMayBay;
	}
	public void setMaMayBay(String maMayBay) {
		this.maMayBay = maMayBay;
	}
	public String getTenMayBay() {
		return tenMayBay;
	}
	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
	}
	public int getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted (int deleted) {
		this.deleted = deleted;
	}
	// methods
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" - Nhap ma may bay: ");
		this.maMayBay = sc.nextLine();
		System.out.print(" - Nhap ten may bay: ");
		this.tenMayBay = sc.nextLine();
		while(true){
			try{
				System.out.print(" - Nhap so ghe: ");
				
				this.soGhe = sc.nextInt();
			if(this.soGhe!=0){return;}
		}catch(InputMismatchException in){System.out.println("Nhap sai! Vui long nhap so!");sc.nextLine();}
		}
	}
	
	public void xuat() {
		System.out.printf("%-15s %-15s %-10s",maMayBay, tenMayBay, soGhe);
	}
}
