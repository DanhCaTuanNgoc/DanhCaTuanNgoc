import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner ;
import java.io.IOException;
public class DanhSachVe {
    private Ve [] dsVe ;
    private int soLuongVe ;
    File d=new File("DanhSachVe.txt");
    // CONSTRUCTOR DEFAULT
    public DanhSachVe(int maxVe) {
        dsVe = new Ve[maxVe] ;
        soLuongVe = 0 ;
    }
    // CONSTRUCTOR PROPERTY
    public DanhSachVe(Ve [] dsVe , int soLuongVe) {
        this.dsVe = dsVe ;
        this.soLuongVe = soLuongVe ;
    }
    // COPY CONSTRUCTOR
    public DanhSachVe(DanhSachVe DSV1) {
        dsVe = DSV1.dsVe ;
        soLuongVe = DSV1.soLuongVe ;
    }
    // GET AND SET
    public Ve [] getDSVe() {
        return dsVe ;
    }
    public void setDSVe(Ve [] dsVe) {
        this.dsVe = dsVe ;
    }
    public int getSoLuongVe() {
        return soLuongVe ;
    }
    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe ;
    }        
    //doc file
    public void DocFile(){
        int n=0;
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
                    dsVe[n]=new VePhoThong(line[1],line[2],line[3],line[4]);
                }else{
                    dsVe[n]=new VeThuongGia(line[1],line[2],line[3],line[4],line[5]);
                }
                n++;
                lines=br.readLine();
            }
            br.close();
        }catch(IOException ioe){System.out.println("error!");}

    }
    //luu file
    public void LuuFile(){
        try{
        if (!d.exists()){
            d.createNewFile();
        }
            FileWriter fr=new FileWriter(d,true);
            BufferedWriter bw=new BufferedWriter(fr);
            for(Ve ve1:dsVe){
                if(ve1!=null){
                if(ve1 instanceof VePhoThong){
                    VePhoThong vpt=(VePhoThong) ve1;
                    bw.write("ve pho thong/"+vpt.getMaVe()+"/"+vpt.getMaChuyenBay()+"/"+vpt.getGiaVe()+"/"+vpt.getHangVe()+"\n");
                }
                else {
                    VeThuongGia vtg=(VeThuongGia) ve1;
                    bw.write("ve thuong gia/"+vtg.getMaVe()+"/"+vtg.getMaChuyenBay()+"/"+vtg.getGiaVe()+"/"+vtg.getMaPhongCho()+"/"+vtg.getDichVuVIP()+"\n");
                }
            }}
            bw.close();
            System.out.println("hoan tat!");
        }catch(IOException ioe){System.out.println("error!");}
    }
    // METHOD
    Scanner input = new Scanner(System.in) ;
    int loaiVe ;
    // Nhap N so ve 
    public void nhapSoLuongVe(int n) {
        if(soLuongVe + n > dsVe.length) {
            System.err.println("Vuot qua so luong ve cho phep");
            return ;
        }
        for(int i = 0 ; i < n ; i ++) {
            System.out.println("Chon Loai Ve.");
            System.out.println("1-VE PHO THONG || 2-VE THUONG GIA");
            loaiVe = Integer.parseInt(input.nextLine()) ;
                Ve ve = null ;
                if(loaiVe == 1) {
                    ve = new VePhoThong() ;
                } else if(loaiVe == 2) {
                    ve = new VeThuongGia() ;
                } else {
                    System.out.println("Vui Long Chon Lai");
                    i -- ;
                    continue ;
                }
                ve.nhap();
                dsVe[soLuongVe] = ve ;
                soLuongVe ++ ;
                System.out.println("Da Nhap Xong So Luong Ve");
            }
    }
    // ADD VE
    public void themVe() {
        System.out.println("Chon Loai Ve.");
        System.out.println("1-VE PHO THONG || 2-VE THUONG GIA");
        loaiVe = Integer.parseInt(input.nextLine()) ;
        if(soLuongVe < dsVe.length) {
            Ve ve = null ;
            if(loaiVe == 1) {
                ve = new VePhoThong() ;
            } else if (loaiVe == 2) {
                ve = new VeThuongGia() ;
            } else {
                System.out.println("Vui Long Chon Lai");
            }
            
            ve.nhap();
            dsVe[soLuongVe] = ve ;
            soLuongVe ++ ;
            System.out.println("Da Tao Ve Hoan Tat");
        }
        
    }
    // ALERT
    // ALERT
    boolean daTimThay = false;
    public void suaVePT(String hangVe) {
        for (Ve ve1 : dsVe) {
            if (ve1 != null && ve1 instanceof VePhoThong) {
                VePhoThong vpt=(VePhoThong) ve1;
                if (vpt.getHangVe().equals(hangVe)) {
                    ve1.nhap();
                    daTimThay = true;
                    break;
                }
            }
        }
        if (!daTimThay) {
            System.out.println("Khong Tim Thay Ve Co Hang Ve : " + hangVe);
        }
    }
    public void suaVeTG(String dichVuVIP) {
        for(Ve ve1 : dsVe) {
            if(ve1 != null && ve1 instanceof VeThuongGia) {
                VeThuongGia vtg=(VeThuongGia) ve1;
                if(vtg.getDichVuVIP().equals(dichVuVIP)) {
                    ve1.nhap();
                    daTimThay = true ;
                    break ;
                }
            }
        }
        if (!daTimThay) {
            System.out.println("Khong Sua Duoc Ve Co Dich Vu VIP : " + dichVuVIP);
        }
    }

    
    // SUB 
    boolean daXoa = false ;
    int index = 0 ;
    public void xoaVePT(String hangVe) {
        while(index < soLuongVe) {
            if(dsVe[index] != null && dsVe[index] instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) dsVe[index] ;
                if(vpt.getHangVe().equals(hangVe)) {
                    int j = index ;
                    while(j < soLuongVe - 1) {
                        dsVe[j] = dsVe[j + 1] ;
                        j ++ ;
                    }
                    dsVe[soLuongVe - 1] = null ;
                    soLuongVe -- ;
                    daXoa = true ;
                } else {
                    index ++ ;
                }
            } else {
                index ++ ;
            }
        }
    }
    // SUB PT PRO
    public void xoaVePTVIP(String hangVe) { // Xoa ALL Ve Hang A OR C
        while(index < soLuongVe) {
            if(dsVe[index] != null && dsVe[index] instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) dsVe[index] ;
                if(vpt.getHangVe().equals("A") || vpt.getHangVe().equals("C") ) {
                    int j = index ;
                    while(j < soLuongVe - 1) {
                        dsVe[j] = dsVe[j + 1] ;
                        j ++ ;
                    }
                    dsVe[soLuongVe - 1] = null ;
                    soLuongVe -- ;
                    daXoa = true ;
                } else {
                    index ++ ;
                }
            } else {
                index ++ ;
            }
        }
    }
    public void xoaVeTG(String maPhongCho) {
        while(index < soLuongVe) {
            if(dsVe[index] != null && dsVe[index] instanceof VeThuongGia) {
                VeThuongGia vtg = (VeThuongGia) dsVe[index] ;
                if(vtg.getMaPhongCho().equals(maPhongCho)) {
                    int j = index ;
                    while(j < soLuongVe - 1) {
                        dsVe[j] = dsVe[j + 1] ;
                        j ++ ;
                    }
                    dsVe[soLuongVe - 1] = null ;
                    soLuongVe -- ;
                    daXoa = true ;
                } else {
                    index ++ ;
                }
            } else {
                index ++ ;
            }
        }
    } 
    // SUB TG PRO
    public void xoaVeTGVIP(String maPhongCho) {
        while(index < soLuongVe) {
            if(dsVe[index] !=null && dsVe[index] instanceof VeThuongGia ) {
                VeThuongGia vtg = (VeThuongGia) dsVe[index] ;
                int maPhong = Integer.parseInt(vtg.getMaPhongCho()) ; //First Lounge by Bamboo Airways ( NOI DIA )
                String dichVu = vtg.getDichVuVIP() ;
                if(maPhong >= 50 && dichVu.equals("HoBoi")) {
                    int j = index ;
                    while(j < soLuongVe - 1) {
                    dsVe[j] = dsVe[j + 1] ;
                    j ++ ;
                }
                dsVe[soLuongVe - 1] = null ;
                soLuongVe -- ;
                daXoa = true ;
            } else {
                index ++ ;
                }
            } else {
                index ++ ;
            }
        }
    }
    
    // SearchVE
    public void timKiemPT(String hangVe) {
        for(Ve ve1 : dsVe) {
            if(ve1 != null && ve1 instanceof VePhoThong) {
                VePhoThong vpt=(VePhoThong) ve1;
                if(vpt.getHangVe().equals(hangVe)) {
                    ve1.xuat();
                   
                } else {
                    System.out.println("Khong Tim Thay Ve PT Co Hang Ve = " + hangVe);
                }
            }
        }
    }
    public void timKiemTG(String dichVuVIP) {
        for(Ve ve1 : dsVe) {
            if(ve1 !=null && ve1 instanceof VeThuongGia) {
                VeThuongGia vtg=(VeThuongGia) ve1;
                if(vtg.getDichVuVIP().equals(dichVuVIP)) {
                    ve1.xuat() ;
                    
                } else {
                    System.out.println("Khong Tim Thay Ve Co Dich Vu VIP = " + dichVuVIP);
                }
            }
        }
    }
    // SHOW
    public void hienThiVe() {
        System.out.println("Danh Sach Ve :");
        for(Ve veList1 : dsVe) {
            if(veList1 != null) {
                veList1.xuat();
            }
        }
    }
    //THONG KE
    public void thongKePT() {
        int countPT = 0 ;
        for(Ve veList1 : dsVe) {
            if(veList1 instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) veList1 ;
                if(vpt.getHangVe().equals("C") || vpt.getHangVe().equals("D")) {
                    countPT ++ ;
                } 
            }
        }
        System.out.println("THONG KE VE PHO THONG CO HANG VE C OR D : ");
        System.out.println("+---------------------------------+");
        System.out.printf("| %-50d |\n", countPT);
        System.out.println("+---------------------------------+");
    }
    public void thongKeTG() {
        int countTG = 0 ;
        for(Ve veList1 : dsVe ) {
            if(veList1 instanceof VeThuongGia) {
                VeThuongGia vtg=(VeThuongGia) veList1;
                if(vtg.getMaPhongCho().equals("AB1") || vtg.getMaPhongCho().equals("BC1")) {
                    countTG ++ ;
                }
            }
        }
        System.out.println("THONG KE VE PHO THONG CO HANG VE C OR D : ");
        System.out.println("+---------------------------------+");
        System.out.printf("| %-50d |\n", countTG);
        System.out.println("+---------------------------------+");
    }
}