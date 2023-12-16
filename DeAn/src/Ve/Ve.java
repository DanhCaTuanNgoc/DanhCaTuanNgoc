package Ve;
import java.util.Scanner;

public abstract class Ve{
        // Danh sach chuyen bay
	protected String maVe, maChuyenBay;
	protected int gia,Deleted;
	public transient Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public Ve() {
		maVe = "";
		maChuyenBay = "";
		gia = 0;
        Deleted=0;	
	}
	public Ve(String maVe, String maChuyenBay, int gia,int deleted) {
		this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.gia = gia;
        this.Deleted=deleted;
	}
	public Ve(Ve a) {
		maVe = a.maVe;
		maChuyenBay = a.maChuyenBay;
		gia = a.gia;
	}

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public int getDeleted() {
        return Deleted;
    }
    public void setDeleted(int deleted) {
        Deleted = deleted;
    }
    public abstract void loaive();
	//CAC HAM KHAC
	public void nhap(){}
	public void xuat(){
        System.out.format("| %-8s | %-8s | %-8.2s", maVe, maChuyenBay, gia);
    }
}