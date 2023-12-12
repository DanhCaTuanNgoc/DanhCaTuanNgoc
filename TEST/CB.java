/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

/**
 *
 * @author Luong Thanh Tuan
 */
public final class CB {
    DanhSachMayBay dsMB = new DanhSachMayBay();
    DanhSachSanBay dsSB = new DanhSachSanBay();
    private String maChuyenBay, maMayBay;
    private String maSanBay;
    private String ngayDi, ngayDen;
    private String sanBayDi, sanBayDen ;
    private String gioDi, gioDen ;
    private int tongSoVe, soVeConLai;
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public CB() {
        maChuyenBay = "";
	maMayBay = "";
        maSanBay = "";
	ngayDi = "";
	ngayDen = "";
	tongSoVe = 0;
	soVeConLai = 0;
        sanBayDi = "" ;
        sanBayDen = "" ;
        gioDi = "" ;
        gioDen = "" ; 
    }
    public CB(CB a) {
        a.maChuyenBay = this.maChuyenBay;
	a.maMayBay = this.maMayBay;
	a.ngayDi = this.ngayDi;
	a.ngayDen = this.ngayDen;
	a.tongSoVe = this.tongSoVe;
	a.soVeConLai = this.soVeConLai;
    }
    
    
    
    
}
