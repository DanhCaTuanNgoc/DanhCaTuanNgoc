package TEST;
import java.util.Scanner;
import java.io.*;

public abstract class Ve implements Serializable {
        // Danh sach chuyen bay
	protected String maVe, maChuyenBay;
	protected float gia;
	public transient Scanner sc = new Scanner(System.in);
	//CONSTRUCTOR
	public Ve() {
		maVe = "";
		maChuyenBay = "";
		gia = 0;	
	}
	public Ve(String maVe, String maChuyenBay, float gia) {
		this.maVe = maVe;
                this.maChuyenBay = maChuyenBay;
                this.gia = gia;
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
	//CAC HAM KHAC
	public abstract void Nhap();
	public abstract void Xuat();
	//GHI FILE, ĐỌC FILE
	public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		dos.writeUTF(maVe);
		dos.writeUTF(maChuyenBay);
		dos.writeFloat(gia);
		dos.close();
	}
}