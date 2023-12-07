package Ve;
import java.util.Scanner;

abstract class Ve {
	private int maVe;
	private String maChuyenBay;
	private Double giaVe;
	//constructor
	public Ve() {
		maVe = 0;
		maChuyenBay = "";
		giaVe = 0.0;
	}
	public Ve(int mave, String machuyenbay, Double giave) {
		mave = this.maVe;
		machuyenbay = this.maChuyenBay;
		giave = this.giaVe;
	}
	public Ve(Ve a) {
		maVe = a.maVe;
		maChuyenBay = a.maChuyenBay;
		giaVe = a.giaVe;
	}
	//get/set
	public int getMaVe() {
		return maVe;
	}
	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}
	public String getMaChuyenBay() {
		return maChuyenBay;
	}
	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}
	public Double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(Double giaVe) {
		this.giaVe = giaVe;
	}
	// methods
	
	// abstract function
	public abstract String KyHieuGhe();
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma ve: ");
		this.maVe = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap ma chuyen bay: ");
		this.maChuyenBay = sc.nextLine();
		System.out.print("Nhap gia ve: ");
		this.giaVe = sc.nextDouble();	
	}
	public void xuat() {
		System.out.print(maVe + "\t" + maChuyenBay + "\t" + giaVe + "\t");
	}
}
