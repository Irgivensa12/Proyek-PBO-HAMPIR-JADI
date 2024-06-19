package AppsDaurUlang;

import java.util.Scanner;

public class AppsMain {

    private static final String VALID_EMAIL = "user@example.com";
    private static final String VALID_PASSWORD = "password123";
    private static int barangCount = 0;

    public static void main(String[] args) {

        int transaksiMax = 100, barangMax = 100, ownerMax = 100;
        Transaksi transaksi[] = new Transaksi[transaksiMax];
        BarangBekas barang[] = new BarangBekas[barangMax];
        Owner owner[] = new Owner[ownerMax];

        Scanner in = new Scanner(System.in);
        System.out.println(">>>>>>>>>> SELAMAT DATANG DI MY DAUR ULANG <<<<<<<<<<");
        System.out.println();
        String emailUser = null;
        String pwUser = null;
        boolean loginSuccess = false;

        do {
            System.out.println("Silahkan login dengan akun Anda !");
            System.out.println();
            System.out.println("Contoh email dan password yang valid :\n"
                    + VALID_EMAIL + "\n" + VALID_PASSWORD);
            System.out.println();
            System.out.print("Masukan email Anda :");
            emailUser = in.next();
            System.out.print("Password : ");
            pwUser = in.next();

            if (emailUser.equals(VALID_EMAIL) && pwUser.equals(VALID_PASSWORD)) {
                System.out.println("Login Anda berhasil :)");
                loginSuccess = true; // Set loginSuccess menjadi true agar keluar dari loop
            } else {
                System.out.println("Email/password tidak cocok silahkan login ulang !");
            }
        } while (!loginSuccess);

        // Menginisialisasi beberapa barang untuk demonstrasi
        barang[barangCount++] = new Plastik(10, new Owner("Benedictus Ditus Atmarestanto", "Jl. Mekarsari No. 12, Jakarta"), 1000, 2000);
        barang[barangCount++] = new Besi(new Owner("Iis Sukmawati", "Jl. Sudirman No. 10, Bandung"), 2000, 3000, 50);
        barang[barangCount++] = new Kertas(new Owner("Maria Regina Nula Lewar", "Jl. Gatot Subroto No. 5, Surabaya"), 500, 100, 5000, false, true, false);
        barang[barangCount++] = new Elektronik(new Owner("Samuel Jeremiah Hastiawan Serang", "Jl. Diponegoro No. 3, Yogyakarta"), 1000, 5, 10000, true, false);

        System.out.println("Menu Utama\n"
                + "1. Daftar barang bekas\n"
                + "2. Cari barang bekas\n"
                + "3. Beli barang bekas\n"
                + "4. Riwayat Transaksi\n"
                + "5. Keluar");

        System.out.println("Silahkan pilih menu kami : ");
        int pilih = in.nextInt();

        switch (pilih) {
            case 1:
                System.out.println("Jenis barang bekas yang tersedia :\n "
                        + "1. Besi"
                        + "2. Plastik"
                        + "3. Kertas"
                        + "4. Elektronik");
                System.out.println();
                break;
            case 2:
                cariBarangBekas(in, barang);
                break;

            case 3:

        }
    }

    public static boolean isEmpty() {
        return barangCount == 0;
    }

    private static void daftarBarangBekas(BarangBekas[] barang) {
        if (isEmpty()) {
            System.out.println("Tidak ada barang bekas tersedia.");
        } else {
            System.out.println("Jenis barang bekas yang tersedia:");
            for (int i = 0; i < barangCount; i++) {
                if (barang[i] != null) {
                    barang[i].tampilInfo();
                    System.out.println("-----");
                }
            }
        }
    }

    private static void cariBarangBekas(Scanner in, BarangBekas[] barang) {
        System.out.println("Jenis barang bekas yang tersedia :\n "
                + "1. Besi"
                + "2. Plastik"
                + "3. Kertas"
                + "4. Elektronik");
        System.out.print("Apa yang ingn Anda cari (ketikkan angka yg mewakili jenis barang) :");
        int pilihan = in.nextInt();
        String jenis = "";
        switch (pilihan) {
            case 1:
                jenis = "Besi";
                break;
            case 2:
                jenis = "Plastik";
                break;
            case 3:
                jenis = "Kertas";
                break;
            case 4:
                jenis = "Elektronik";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }
        boolean found = false;
        for (BarangBekas item : barang) {
            if (item != null && item.getJenis().equalsIgnoreCase(jenis)) {
                item.tampilInfo(); // Memanggil metode tampilInfo() dari objek yang sesuai dengan jenis barang
                System.out.println("-----");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada barang bekas jenis " + jenis + " yang ditemukan.");
        }
    }

 private static void beliBarangBekas(Scanner in, BarangBekas[] barangList, Transaksi[] transaksi) {
    System.out.println("Pilih barang yang ingin Anda beli berdasarkan nomor urut: ");
    for (int i = 0; i < barangCount; i++) {
        System.out.println((i + 1) + ". " + barangList[i].getJenis());
    }
    int pilihan = in.nextInt();

    if (pilihan < 1 || pilihan > barangCount || barangList[pilihan - 1] == null) {
        System.out.println("Nomor urut barang tidak valid.");
        return;
    }

    BarangBekas barang = barangList[pilihan - 1];

    System.out.println("Anda memilih barang:");
    barang.tampilInfo();

    System.out.print("Masukkan jumlah yang ingin dibeli: ");
    int jumlah = in.nextInt();

    double totalHarga = barang.getHarga() * jumlah;

    System.out.println("Total harga: " + totalHarga);
    System.out.println("Melakukan transaksi...");

    // Mengurangi jumlah barang
    barang.kurangiJumlah(jumlah);

    // Menambah saldo pemilik
    Owner owner = barang.getOwner();
    owner.addSaldo(totalHarga);

    // Membuat objek Transaksi
    Transaksi newTransaksi = new Transaksi("Tanggal Transaksi", jumlah, barang.getBerat(), barang.getHarga(), null, barang);

    // Menyimpan transaksi ke dalam array transaksi
    for (int i = 0; i < transaksi.length; i++) {
        if (transaksi[i] == null) {
            transaksi[i] = newTransaksi;
            break;
        }
    }

    System.out.println("Transaksi berhasil! Saldo pemilik sekarang: " + owner.getSaldo());
}

//    private static void riwayatTransaksi(int transaksiCount) {
//        System.out.println("Riwayat Transaksi:");
//        for (int i = 0; i < transaksiCount; i++) {
//            System.out.println("Tanggal: " + transaksiList[i].getTanggal());
//            System.out.println("Jumlah Barang: " + transaksiList[i].getJumlahBarang());
//            System.out.println("Berat: " + transaksiList[i].getBerat());
//            System.out.println("Harga Jual: " + transaksiList[i].getHargaJual());
//            System.out.println("Pembeli: " + transaksiList[i].getId_Pembeli());
//            System.out.println("Pemilik: " + transaksiList[i].getId_Pemilik());
//            System.out.println("Total Harga: " + transaksiList[i].totalHarga());
//            System.out.println("------");
//        }
//    }
}
