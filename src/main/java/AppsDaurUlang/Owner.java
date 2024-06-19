package AppsDaurUlang;

import java.util.Arrays;

public class Owner {

    private String namaOwner;
    private String alamat;
//    private Owner owner;
    private double saldo; // Aku ubah jadi double biar gampang pakai saldo
    private BarangBekas[] owner;

    public Owner(String namaOwner, String alamat) {
        this.namaOwner = namaOwner;
        this.alamat = alamat;
//        this.owner = owner;
        this.saldo = 0.0;
    }

    public String getNamaP() {
        return namaOwner;
    }

    public void setNamaP(String namaP) {
        this.namaOwner = namaP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

//    public Owner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // untuk menambahkan barang bekas dari array beli
    public void add(BarangBekas barangOwner) {
        if (barangOwner != null) {
            if (owner == null) {
                owner = new BarangBekas[1];
                owner[0] = barangOwner;
            } else {
                BarangBekas[] newOwner = Arrays.copyOf(owner, owner.length + 1);
                newOwner[owner.length] = barangOwner;
                owner = newOwner;
            }
        }
    }

    //untuk menghapus barang bekas dari array beli 
    public void delete(BarangBekas barang) {
        if (barang != null && owner != null) {
            for (int i = 0; i < owner.length; i++) {
                if (owner[i].equals(barang)) {
                    BarangBekas[] newOwner = new BarangBekas[owner.length - 1];
                    for (int j = 0, k = 0; j < owner.length; j++) {
                        if (j != i) {
                            newOwner[k++] = owner[j];
                        }
                    }
                    owner = newOwner;
                    return;
                }
            }
        }
    }
}
