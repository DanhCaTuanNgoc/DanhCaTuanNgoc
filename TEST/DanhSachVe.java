/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

/**
 *
 * @author Luong Thanh Tuan
 */
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;   
public class DanhSachVe {
    private Ve [] dsVe;
    private int n;
    Scanner sc = new Scanner(System.in);
    // CONSTRUCTOR DEFAULT / PROPERTY / COPY
    public DanhSachVe() {
        dsVe = new Ve[0];
        n = 0;
    }
    public DanhSachVe(Ve [] dsVe, int n) {
        this.dsVe = dsVe;
        this.n = n;
    } 
    public DanhSachVe(DanhSachVe a) {
        dsVe = a.dsVe;
        n = a.n;
    }
    public Ve[] getDSVe() {
        return dsVe;
    }
    public void setDSVe(Ve[] dsVe) {
        this.dsVe = dsVe;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    // NHAP XUAT
    public void nhapDanhSach() {
        System.out.println("Nhap so luong ve: ");
        n = sc.nextInt();
        dsVe = new Ve[n];
        int loaiVe = 0;
        for(int i = 0; i < n; i ++) {
            System.out.println("\t\t\t======BANG LUA CHON======");
			System.out.println("1.Ve Pho Thong");
			System.out.println("2.Ve Thuong Gia");
                        do {
                            System.out.println("Lua chon: ");
                            loaiVe = sc.nextInt();
                            if(loaiVe < 1 || loaiVe > 2) {
                                System.err.println("Nhap sai, Hay nhap lai!!!");
                            }
                        }while(loaiVe < 1 || loaiVe > 2);
                        if(loaiVe == 1) {
                            dsVe[i] = new VePhoThong();
                            System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE PHO THONG)\n");
                            dsVe[i].nhap();
                            // UPDATTING...
                        } else if(loaiVe == 2) {
                            System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE THUONG GIA)\n");
                            dsVe[i].nhap();
                            // UPDATTING...
                        }
        }
        
    }
    public void xuatDanhSach() {
		System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
		System.out.println("==========================================================================================================================================================================================================================");		
		System.out.format("|| %4s | %8s | %12s | %32s | %15s | %11s | %13s | %15s ||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "SO LUONG", "GIA(VND)", "THANH TIEN(VND)");
		try {
			for(int i = 0; i < n; i++) {
				System.out.format("|| %4s |", (i + 1));
				dsVe[i].xuat();
			}
		}catch(NullPointerException npe) {
			
		}
		System.out.println("===========================================================================================================================================================================================================================");
	}
    // THEM, SUA, XOA, TIMKIEM, THONGKE
    public void them(int sl) {
        dsVe = Arrays.copyOf(dsVe,n + sl);
        int loaiVe = 0, j = n + sl;
        j -= sl; // START
        n +=sl; // UPDATE
        for(int i = j; i < n; i ++) {
            System.out.println("\t\t\t======BANG LUA CHON======");
			System.out.println("1.Ve Pho Thong");
			System.out.println("2.Ve Thuong Gia");
                        do {
                            System.out.println("Lua Chon: ");
                            loaiVe = sc.nextInt();
                            if(loaiVe < 1 || loaiVe > 2) {
                                System.err.println("Nhap sai, Hay nhap lai!!!");
                            }
                        }while(loaiVe < 1 || loaiVe > 2);
                        if(loaiVe == 1) {
                            dsVe[i] = new VePhoThong();
                            System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE PHO THONG)\n");
                            dsVe[i].nhap();
                            // UPDATTING...
                        } else if(loaiVe == 2) {
                            dsVe[i] = new VeThuongGia();
                            System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE THUONG GIA)\n");
                            dsVe[i].nhap();
                            // UPDATTING...
                        } else if(loaiVe == 3) {
                            return;
                        }
        }
    }
    public void xoa_pt(String hangVe) {
    boolean daXoa = false;
    int index = 0, j;

    while (index < n) {
        if (dsVe[index] != null && dsVe[index] instanceof VePhoThong) {
            VePhoThong vpt = (VePhoThong) dsVe[index];
            if (vpt.getHangVe().equals(hangVe)) {
                j = index;
                while (j < n - 1) {
                    dsVe[j] = dsVe[j + 1];
                    j++;
                }
                dsVe[n - 1] = null;
                n--;
                daXoa = true;
            } else {
                index++;
            }
        } else {
            index++;
        }
    }

    if (daXoa) {
        System.out.println("\nDa xoa thanh cong");
        // ghiFileJava("ve.txt");
    } else {
        System.err.println("\nKhong tim thay hang ve can xoa!!!");
    }   
}

    public void xoa_tg(String maPhongCho) {
    boolean daXoa = false;
    int index = 0, j;

    while (index < n) {
        if (dsVe[index] != null && dsVe[index] instanceof VeThuongGia) {
            VeThuongGia vtg = (VeThuongGia) dsVe[index];
            if (vtg.getMaPhongCho().equals(maPhongCho)) {
                j = index;
                while (j < n - 1) {
                    dsVe[j] = dsVe[j + 1];
                    j++;
                }
                dsVe[n - 1] = null;
                n--;
                daXoa = true;
            } else {
                index++;
            }
        } else {
            index++;
        }
    }

    if (daXoa) {
        System.out.println("\nDa xoa thanh cong");
        // ghiFileJava("ve.txt");
    } else {
        System.err.println("\nKhong tim thay ma phong cho can xoa!!!");
    }
}
    public void xoa() {
        int luaChon = 0;
        loop :
        while(true) {
            System.out.println("\n\t\t\t\t\t======LUA CHON XOA======");
            System.out.println("\t\t\t\t\t1.Xoa theo hang ve");
            System.out.println("\t\t\t\t\t2.Xoa theo ma phong cho");
            System.out.println("\t\t\t\t\t3.Thoat");
            System.out.print("\nLua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon) {
                case 1 :
                    System.out.print("Nhap hang ve can xoa: ");
                    String hangVe = sc.nextLine();
                    xoa_pt(hangVe);
                    break;
                case 2 :
                    System.out.print("Nhap ma phong cho can xoa: ");
                    String maPhongCho = sc.nextLine();
                    xoa_tg(maPhongCho);
                    break;
                case 3 : 
                    break loop;
                default :
                    System.err.println("Nhap sai nen thoat chuong trinh!!!");
                    break;
            }
        }
    }
    public void sua_pt(String hangVe) {
        boolean daSua = false;
        for(int i = 0; i < n; i ++) {
            if(dsVe[i] != null && dsVe[i] instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) dsVe[i];
                if(vpt.getHangVe().equals(hangVe)) {
                    System.out.println("\n\t\t\t======CHINH SUA THONG TIN VE PHO THONG======");
                     vpt.nhap();  
                    daSua = true;
                 // ghiFileJava("ve.txt");
                    break;
                }
            }
        }
    }
    public void sua_tg(String dichVuVIP) {
        boolean daSua = false;
        for(int i = 0; i < n; i ++) {
            if(dsVe[i] != null && dsVe[i] instanceof VeThuongGia) {
                VeThuongGia vtg = (VeThuongGia) dsVe[i];
                if(vtg.getDichVuVIP().equals(dichVuVIP)) {
                    System.out.println("\n\t\t\t======CHINH SUA THONG TIN VE PHO THONG======");
                     vtg.nhap();  
                    daSua = true;
                 // ghiFileJava("ve.txt");
                    break;
                }
            }
        }
    }
    public void sua() {
        int luaChon = 0;
        loop:
        while(true) {
            System.out.println("\n\t\t\t\t\t======LUA CHON SUA======");
            System.out.println("\t\t\t\t\t1.Sua theo hang ve");
            System.out.println("\t\t\t\t\t2.Sua theo dich vu VIP");
            System.out.println("\t\t\t\t\t3.Thoat");
            System.out.print("\nLua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon) {
                case 1 :
                    System.out.print("Nhap hang ve can sua");
                    String hangVe = sc.nextLine();
                    sua_pt(hangVe);
                    break;
                case 2 : 
                    System.out.println("Nhap dich vu VIP can sua");
                    String dichVuVIP = sc.nextLine();
                    sua_tg(dichVuVIP);
                    break;
                case 3 :
                    break loop;
                default :
                    System.err.println("Nhap sai nen thoat chuong trinh!!!");
                    break;
            }
        }
    }
    public void timKiem_MV(String maVe) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
        System.out.println("==========================================================================================================================================================================================================================");		
        System.out.format("|| %4s | %8s | %12s | %32s | %15s | %11s||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
	for(int i = 0; i < n; i ++) {
            if(dsVe[i] != null && dsVe[i].getMaVe().equals(maVe)) {
                System.out.format("|| %4s |", i + 1);
                dsVe[i].xuat();
                break;
            }
        }
        System.out.println("===========================================================================================================================================================================================================================");
    }
    public void timKiem_pt(String hangVe) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
        System.out.println("==========================================================================================================================================================================================================================");		
        System.out.format("|| %4s | %8s | %12s | %32s | %15s | %11s n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
	for(int i = 0; i < n; i ++) {
            if(dsVe[i] != null && dsVe[i] instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) dsVe[i];
                if(vpt.getHangVe().equals(hangVe)) {
                    System.out.format("|| %4s |", i + 1);
                    dsVe[i].xuat();
                    break;
                }
            }
        }
        System.out.println("===========================================================================================================================================================================================================================");
    }
    public void timKiem_tg (String maPhongCho) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
        System.out.println("==========================================================================================================================================================================================================================");		
        System.out.format("|| %4s | %8s | %12s | %32s | %15s | %11s ||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
	for(int i = 0; i < n; i ++) {
            if(dsVe[i] != null && dsVe[i] instanceof VeThuongGia) {
                VeThuongGia vtg = (VeThuongGia) dsVe[i];
                if(vtg.getMaPhongCho().equals(maPhongCho)) {
                    System.out.format("|| %4s |", i + 1);
                    dsVe[i].xuat();
                    break;
                }
            }
        }
        System.out.println("===========================================================================================================================================================================================================================");
    }
    public void timKiem() {
        int luaChon = 0;
        loop:
        while(true) {
            System.out.println("\n\t\t\t\t\t======LUA CHON TIM KIEM======");
            System.out.println("\t\t\t\t\t1.Tim kiem theo ma ve");
            System.out.println("\t\t\t\t\t2.Tim kiem theo hang ve");
            System.out.println("\t\t\t\t\t3.Tim kiem theo ma phong cho");
            System.out.println("\t\t\t\t\t4.Thoat");

            System.out.print("\nLua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon) {
                case 1 :
                    System.out.print("Nhap ma ve can tim");
                    String maVe = sc.nextLine();
                    timKiem_MV(maVe);
                    break;
                case 2 : 
                    System.out.println("Nhap hang ve can tim");
                    String hangVe = sc.nextLine();
                    timKiem_pt(hangVe);
                    break;
                case 3 :
                    System.out.println("Nhap ma phong cho can tim");
                    String maPhongCho = sc.nextLine();
                    timKiem_pt(maPhongCho);
                    break;
                case 4 :
                    break loop;
                default :
                    System.err.println("Nhap sai nen thoat chuong trinh!!!");
                    break;
            }
        }
    }
    public void thongKe(String hangVe, String maPhongCho) {
    int countPT = 0;
    int countTG = 0;

    // Đếm số lượng vé phổ thông và thương gia
    for (Ve ve1 : dsVe) {
        if (ve1 instanceof VePhoThong vpt && vpt.getHangVe().equals(hangVe)) {
            countPT++;
        }

        if (ve1 instanceof VeThuongGia vtg && vtg.getMaPhongCho().equals(maPhongCho)) {
            countTG++;
        }
    }
    // Tính tỷ lệ phần trăm
    double percentPT = (countPT / (double) dsVe.length) * 100;
    double percentTG = (countTG / (double) dsVe.length) * 100;

    // In ra bảng thống kê
    System.out.println("THONG KE VE PHO THONG CO HANG VE : " + hangVe + " VA THUONG GIA CO MA PHONG CHO : " + maPhongCho);
    System.out.println("+---------------------------------------------+");
    System.out.printf("| LOAI VE         | SO LUONG        | TI LE           |\n");
    System.out.println("+---------------------------------------------+");
    System.out.printf("| VE PHO THONG    | %-15d | %-15.2f%% |\n", countPT, percentPT);
    System.out.printf("| VE THUONG GIA   | %-15d | %-15.2f%% |\n", countTG, percentTG);
    System.out.println("+---------------------------------------------+");
}

    private String calculatePercentage(int count, int total) {
        double percentage = (double) count / total * 100;
        return String.format("%.2f%%", percentage);
    }
    public void ThaoTac() {
		int luaChon = 0;
		loop:
			while(true) {
				System.out.println("\t========================================");
				System.out.println("\t!		  ---- THAO TAC ----         !");
				System.out.println("\t!		1.Them ve.                   !");
				System.out.println("\t!		2.Xoa ve.                    !");
				System.out.println("\t!         3.Sua ve.                    !");
				System.out.println("\t! 	4.Tim kiem ve.               !");
				System.out.println("\t! 	5.Xuat danh sach.            !");
				System.out.println("\t! 	6.Thoat.		     !");
				System.out.println("\t========================================");
				System.out.print("Lua chon: ");
				luaChon = sc.nextInt();
				sc.nextLine();
				switch(luaChon) {
					case 1:
						System.out.print("Nhap so luong ve can them: ");
						int sl = sc.nextInt();
						them(sl);
						xuatDanhSach();
						break;
					case 2:
						xoa();
						break;
					case 3:
						sua();
						break;
					case 4:
						timKiem();
						break;
					case 5: 
						xuatDanhSach();
						break;
					case 6:
						break loop;
					default:
						System.err.println("Nhap sai lua chon!!!");
						continue loop;
				}
			}
	}
    // FILE
    //@Override
    public void GhiFileJava(String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(n);
            for (int i = 0; i < n; i++) {
                if (dsVe[i] instanceof VePhoThong) {
                    VePhoThong vpt = (VePhoThong) dsVe[i];
                    vpt.GhiFile(filename);  // Hãy chắc chắn rằng hàm GhiFile ở lớp VePhoThong đã được định nghĩa chính xác
                }
                if (dsVe[i] instanceof VeThuongGia) {
                    VeThuongGia vtg = (VeThuongGia) dsVe[i];
                    vtg.GhiFile(filename);  // Hãy chắc chắn rằng hàm GhiFile ở lớp VeThuongGia đã được định nghĩa chính xác
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc dữ liệu từ file
    public void DocFileJava(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int i = 0;
            n = dis.readInt();
            dsVe = new Ve[n];
            try {
                while (true) {
                    int code = dis.readInt();
                    String maVe = dis.readUTF();
                    String maChuyenBay = dis.readUTF();
                    float gia = dis.readFloat();
                    if (code == 0) {
                        String hangVe = dis.readUTF();
                        dsVe[i] = new VePhoThong(maVe, maChuyenBay, gia, hangVe);
                    } else if (code == 1) {
                        String maPhongCho = dis.readUTF();
                        String dichVuVIP = dis.readUTF();
                        dsVe[i] = new VeThuongGia(maVe, maChuyenBay, gia, maPhongCho, dichVuVIP);
                    }
                    i++;
                }
            } catch (EOFException e) {
            } finally {
                n = i;
                dis.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
      
}
