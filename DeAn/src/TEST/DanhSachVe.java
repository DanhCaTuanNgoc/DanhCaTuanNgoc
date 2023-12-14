package TEST;

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class DanhSachVe {
	Ve[] x;
	private int n, a = 0;
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTOR
	public DanhSachVe() {
		
	}
	
	//NHẬP DANH SÁCH XUẤT DANH SÁCH
	public void NhapDanhSach() {
		System.out.print("Nhap so luong ve: ");
		n = sc.nextInt();
		x = new Ve[n];
		int select = 0;
		for(int i = 0; i < n; i++) {
			System.out.println("\t\t\t======BẢNG LỰA CHỌN======");
			System.out.println("1.Ve pho thong");
			System.out.println("2.Ve thuong gia");
			do {
				System.out.print("lua chon cua ban: ");
				select = sc.nextInt();
				if(select < 1 || select > 2) {
					System.err.println("Ban da nhap sai!!!");
				}
			}while(select < 1 || select > 2);
			if(select == 1) {
				x[i] = new VePhoThong();
				System.out.print("\n\t\t\t\t\tVe thu " + (i + 1) + " (VE PHO THONG)\n");
				x[i].Nhap();
				GhiFileJava("Ve.txt");
				sc.nextLine();
				if(i > 0) {
					ThayDoiMV(i);
				}
			}
			else if(select == 2) {
				System.out.print("\n\t\t\t\t\tVe thu " + (i + 1) + " (VE PHO THONG)\n");
				x[i] = new VeThuongGia();
				x[i].Nhap();
				GhiFileJava("Ve.txt");
				sc.nextLine();
				if(i > 0) {
					ThayDoiMV(i);
				}
			}
		}
	}
	public void XuatDanhSach() {
		System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
		System.out.println("========================================================================================================================================================================");		
		System.out.format("|| %4s | %8s | %12s | %32s |  %11s | %13s  ||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
		try {
			for(int i = 0; i < n; i++) {
				System.out.format("|| %4s |", (i + 1));
				x[i].Xuat();
			}
		}catch(NullPointerException npe) {
			
		}
		System.out.println("========================================================================================================================================================================");
	}
	//KẾT THÚC NHẬP, XUẤT DANH SÁCH
	
	//CÁC HÀM LIÊN KẾT VÀ KIỂM TRA TÍNH ĐÚNG SAI
	public void DanhSach_SL() {
		System.out.println("\t\t=======DANH SACH VE=======");
		System.out.println("======================================================================================================");
		System.out.format("|| %4s | %11s  | %12s | %10s ||\n", "STT", "MA VE", "MA CHUYEN BAY", "GIA(VND)");
		for(int i = 0; i < n; i++) {
			System.out.format("|| %4s | %11s | %12s | %10s ||\n", (i + 1), x[i].maVe, x[i].maChuyenBay, x[i].gia);
		}
		System.out.println("======================================================================================================");
		
	}
	
	public void ThayDoiMV(int i) {
		do {
			if(KiemTraMV(x[i].maVe, i)) {
				System.out.println();
				XuatDanhSach();
				System.err.println("\nVe thu "+ (i+1) + " co ma " + x[i].maVe + " bi trung . Enter de tiep tuc");
				sc.nextLine();
				System.err.print("Nhap lai ma ve: ");
				x[i].maVe = sc.nextLine();
				GhiFileJava("Ve.txt");
			}
		}while(KiemTraMV(x[i].maVe, i));
	}
	
	public boolean KiemTraMV(String maVe, int k) {
		DocFileJava("Ve.txt");
		for(int i = a - 1; i >= 0; i--) {
			if(x[i].maVe.indexOf(maVe) != -1 && i != k) {
				return true;
			}
		}
		return false;
	}
	//CÁC THAO TÁC XỬ LÝ TRÊN DANH SÁCH
	
	public void them(int sl) {
		x = Arrays.copyOf(x, n + sl);
		int select, j = n + sl;
		j -= sl;
		n += sl;
		for(int i = j; i < n; i++) {
			System.out.println("\n\t\t\t\t\t======BANG LUA CHON======");
			System.out.println("\t\t\t\t\t1.Ve Pho Thong");
			System.out.println("\t\t\t\t\t2.Ve Thuong Gia");
			System.out.println("\t\t\t\t\t3.Thoat");
			do {
                            System.out.println("Lua Chon: ");
                            select = sc.nextInt();
                            if(select < 1 || select > 2) {
                                System.err.println("Nhap sai, Hay nhap lai!!!");
                            }
                        }while(select < 1 || select > 2);
			if(select == 1) {
				x[i] = new VePhoThong();
				System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE PHO THONG)\n");
				x[i].Nhap();
				GhiFileJava("Ve.txt");
				sc.nextLine();
				ThayDoiMV(i);
			}
			else if(select == 2) {
				x[i] = new VeThuongGia();
				System.out.print("\n\t\t\t\t\tVE THU" + (i + 1) + " (VE THUONG GIA)\n");
				x[i].Nhap();
				GhiFileJava("Ve.txt");
				sc.nextLine();
				ThayDoiMV(i);
			}
			else if(select == 3)
				return;
		}
	}
	public void sua(String maVe) {
		int select = 0;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			if(x[i].maVe.indexOf(maVe) != -1) {
				do {
					System.out.println("\n\t\t\t\t\t=======BANG LUA CHON=======");
					System.out.println("\t\t\t\t\t1.An phim 1 de sua thuoc tinh ve pho thong");
					System.out.println("\t\t\t\t\t2.An phim 1 de sua thuoc tinh ve thuong gia");
					System.out.println("\t\t\t\t\t3.An phim 3 de thoat");
					System.out.print("\nLua chon cua ban: ");
					select = sc.nextInt();
					sc.nextLine();
					
					if(select < 1 || select > 3)
						System.err.println("Nhap sai moi nhap lai!!!");
				}while(select < 1 || select > 3);
				
				switch(select) {
					case 1:
						flag = true;
						System.out.println("\t\t\t\t\t\t\t\t\t\t=======SUA THONG TIN=======");
						System.out.println("==============================================================================================================================================================================================================================");
						System.out.format("|| %4s | %8s | %12s | %32s |  %11s | %13s  ||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
						System.out.format("|| %4s |", i + 1);
						x[i].Xuat();
						System.out.println("==============================================================================================================================================================================================================================");	
						System.out.println("\nSua thuoc tinh ve pho thong");
						x[i] = new VePhoThong();
						x[i].Nhap();
						GhiFileJava("Ve.txt");
						break;
					case 2: 
						flag = true;
						System.out.println("\t\t\t\t\t\t\t\t\t\t=======SUA THONG TIN=======");
						System.out.println("==============================================================================================================================================================================================================================");
						System.out.format("|| %4s | %8s | %12s | %32s |  %11s | %13s  ||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
						System.out.format("|| %4s |", i + 1);
						x[i].Xuat();
						System.out.println("==============================================================================================================================================================================================================================");	
						System.out.println("\nSua thuoc tinh ve thuong gia");
						x[i] = new VeThuongGia();
						x[i].Nhap();
						GhiFileJava("Ve.txt");
						break;
					case 3:
						flag = true;
						break;
				}
				ThayDoiMV(i);
			}
		}
		if(flag == false) {
			System.err.println("\nKhong tim thay san pham can sua!!!");
			return;
		}
	}
        public void xoa_pt(String hangVe) {
    boolean daXoa = false;
    int index = 0, j;

    while (index < n) {
        if (x[index] != null && x[index] instanceof VePhoThong) {
            VePhoThong vpt = (VePhoThong) x[index];
            if (vpt.getHangVe().equals(hangVe)) {
                j = index;
                while (j < n - 1) {
                    x[j] = x[j + 1];
                    j++;
                }
                x[n - 1] = null;
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
        GhiFileJava("Ve.txt");
    } else {
        System.err.println("\nKhong tim thay hang ve can xoa!!!");
    }   
}

    public void xoa_tg(String maPhongCho) {
    boolean daXoa = false;
    int index = 0, j;

    while (index < n) {
        if (x[index] != null && x[index] instanceof VeThuongGia) {
            VeThuongGia vtg = (VeThuongGia) x[index];
            if (vtg.getMaPhongCho().equals(maPhongCho)) {
                j = index;
                while (j < n - 1) {
                    x[j] = x[j + 1];
                    j++;
                }
                x[n - 1] = null;
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
        GhiFileJava("Ve.txt");
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
	public void timKiem_MV(String maVe) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t======DANH SACH VE======");
        System.out.println("==========================================================================================================================================================================================================================");		
        System.out.format("|| %4s | %8s | %12s | %32s | %15s | %11s||\n", "STT", "MA VE", "MA CHUYEN BAY", "HANG VE", "MA PHONG CHO", "DICH VU VIP", "GIA(VND)");
	for(int i = 0; i < n; i ++) {
            if(x[i] != null && x[i].getMaVe().equals(maVe)) {
                System.out.format("|| %4s |", i + 1);
                x[i].Xuat();
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
            if(x[i] != null && x[i] instanceof VePhoThong) {
                VePhoThong vpt = (VePhoThong) x[i];
                if(vpt.getHangVe().equals(hangVe)) {
                    System.out.format("|| %4s |", i + 1);
                    x[i].Xuat();
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
            if(x[i] != null && x[i] instanceof VeThuongGia) {
                VeThuongGia vtg = (VeThuongGia) x[i];
                if(vtg.getMaPhongCho().equals(maPhongCho)) {
                    System.out.format("|| %4s |", i + 1);
                    x[i].Xuat();
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
    for (Ve ve1 : x) {
        if (ve1 instanceof VePhoThong vpt && vpt.getHangVe().equals(hangVe)) {
            countPT++;
        }

        if (ve1 instanceof VeThuongGia vtg && vtg.getMaPhongCho().equals(maPhongCho)) {
            countTG++;
        }
    }
    // Tính tỷ lệ phần trăm
    double percentPT = (countPT / (double) x.length) * 100;
    double percentTG = (countTG / (double) x.length) * 100;

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
				System.out.println("\t\t  ======================================");
				System.out.println("\t\t  !           ----- Thao tac -----     !");
				System.out.println("\t\t  !        1. Them ve.                 !");
				System.out.println("\t\t  !        2. Xoa ve                   !");
				System.out.println("\t\t  !        3. Sua ve.                  !");
				System.out.println("\t\t  !        4. Tim kiem ve.             !");
				System.out.println("\t\t  !        5. Xuat danh sach.          !");
                System.out.println("\t\t  !        6. Thong ke.                !");
				System.out.println("\t\t  !        7. Thoat.                   !");
				System.out.println("\t\t  ======================================");
				System.out.print("Lua chon: ");
				luaChon = sc.nextInt();
				sc.nextLine();
				switch(luaChon) {
					case 1:
						System.out.print("Nhap so luong ve can them: ");
						int sl = sc.nextInt();
						them(sl);
						XuatDanhSach();
						break;
					case 2:
						xoa();
						break;
					case 3:
						System.out.print("Nhap ma ve can sua: ");
						String maVe = sc.nextLine();
						sua(maVe);
						XuatDanhSach();
						break;
					case 4:
						timKiem();
						break;
					case 5: 
						XuatDanhSach();
						break;
	                case 6 : 
	                    sc.nextLine() ;
	                        System.out.println("Nhap Hang Ve :");
	                        String hangVe = sc.nextLine() ;
	                        System.out.println("Nhap Ma Phong Cho :");
	                        String maPhongCho = sc.nextLine() ;
	                        thongKe(hangVe,maPhongCho);
	                        break;
					case 7:
						break loop;
					default:
						System.err.println("Nhap sai lua chon!!!");
						continue loop;
				}
			}
	}
	
	//ĐỌC FILE, GHI FILE
	public void GhiFileJava(String filename) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
			dos.writeInt(n);
			for(int i = 0; i < n; i++) {
				if(x[i] instanceof VePhoThong) {
					x[i] = (VePhoThong) x[i];
					x[i].GhiFile(filename);
				}
				if(x[i] instanceof VeThuongGia) {
					x[i] = (VeThuongGia) x[i];
					x[i].GhiFile(filename);
				}
			}
			dos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void DocFileJava(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int i = 0;
            n = dis.readInt();
            x = new Ve[n];
            try {
                while (true) {
                    int code = dis.readInt();
                    String maVe = dis.readUTF();
                    String maChuyenBay = dis.readUTF();
                    float gia = dis.readFloat();
                    if (code == 0) {
                        String hangVe = dis.readUTF();
                        x[i] = new VePhoThong(maVe, maChuyenBay, gia, hangVe);
                    } else if (code == 1) {
                        String maPhongCho = dis.readUTF();
                        String dichVuVIP = dis.readUTF();
                        x[i] = new VeThuongGia(maVe, maChuyenBay, gia, maPhongCho, dichVuVIP);
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
        
        
         public static void main(String [] args) {
        DanhSachVe dsVe = new DanhSachVe();
        dsVe.NhapDanhSach();
        dsVe.DocFileJava("Ve.txt");
	dsVe.XuatDanhSach();
        dsVe.ThaoTac();
    }
}
