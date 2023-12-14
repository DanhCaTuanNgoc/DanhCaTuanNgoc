package Ve;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PhoThong extends Ve {
	private boolean nangVe;
	// constructor
	public PhoThong() {
		super();
		nangVe = false;
	}
	public PhoThong(boolean nangve, int mave, String machuyenbay,  Double giave) {
		super(mave, machuyenbay, giave);
		nangve = this.nangVe;
	}
	public PhoThong(PhoThong a) {
		super((Ve)a);
		nangVe = a.nangVe;
	}
	
	// get/set
	public boolean getHangVe() {
		return this.nangVe;
	}
	public void setHangVe(boolean hangve) {
		hangve = this.nangVe;
	}
	
	// methods	
	@Override public void nhap() {
		super.nhap();
		
	}
	
	@Override public void xuat() {
		super.xuat();
	}
}
