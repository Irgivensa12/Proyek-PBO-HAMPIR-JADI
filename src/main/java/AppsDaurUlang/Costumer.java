package AppsDaurUlang;

import java.util.Arrays;

public class Costumer { // Iis

    private Costumer costumer;
    private String nama;
    private BarangBekas[] beli;

    public Costumer(Costumer costumer, String nama, BarangBekas[] beli) {
        this.costumer = costumer;
        this.nama = nama;
        this.beli = beli;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BarangBekas[] getBeli() {
        return beli;
    }

    public void setBeli(BarangBekas[] beli) {
        this.beli = beli;
    }

    // untuk menambahkan barang bekas dari array beli
    public void add(BarangBekas barang) {
        if (barang != null) {
            beli = Arrays.copyOf(beli, beli.length + 1);
            beli[beli.length - 1] = barang;
        }
    }
    
    //untuk menghapus barang bekas dari array beli 
    public void delete(BarangBekas barang) {
        if (barang != null) {
            for (int i = 0; i < beli.length; i++) {
                if (beli[i].equals(barang)) {
                    BarangBekas[] newBeli = new BarangBekas[beli.length - 1];
                    for (int j = 0, k = 0; j < beli.length; j++) {
                        if (j != i) {
                            newBeli[k++] = beli[j];
                        }
                    }
                    beli = newBeli;
                    return;
                }
            }
        }
    }
}
