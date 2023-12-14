package Ve;

import java.util.Scanner;

final class ThuongGia extends Ve {
		private String maPhongCho;
		private String dichVuVIP;
		// constructor
		public ThuongGia() {
			super();
			maPhongCho = "";
			dichVuVIP = "";
		}
		public ThuongGia(int mave, String machuyenbay, Double giave, String maphongcho, String dichvuvip) {
			super(mave, machuyenbay, giave);
			maphongcho = this.maPhongCho;
			dichvuvip = this.dichVuVIP;
		}
		public ThuongGia(ThuongGia a) {
			super((Ve)a);
			maPhongCho = a.maPhongCho;
			dichVuVIP = a.dichVuVIP;
		}
		
		// get/set
		public String getMaPhongCho() {
			return maPhongCho;
		}
		public void setMaPhongCho(String maPhongCho) {
			this.maPhongCho = maPhongCho;
		}
		public String getDichVuVIP() {
			return dichVuVIP;
		}
		public void setDichVuVIP(String dichVuVIP) {
			this.dichVuVIP = dichVuVIP;
		}
		
		// methods
		@Override public void nhap() {
			super.nhap();
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap ma phong cho: ");
			this.maPhongCho = sc.nextLine();
			System.out.print("Nhap noi dung dich vu VIP: ");
			this.dichVuVIP = sc.nextLine();
		}
		@Override public void xuat() {
			super.xuat();
			System.out.print(maPhongCho + "\t" + dichVuVIP);
		}
}
