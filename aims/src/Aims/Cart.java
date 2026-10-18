package Aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;

    public Cart() {
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered < 20) {
            this.itemsOrdered[this.qtyOrdered] = disc;
            ++this.qtyOrdered;
            System.out.println("The disc has been added successful");
        } else {
            System.out.println("The cart is almost full");
        }

    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvsList) {
        DigitalVideoDisc[] var2 = dvsList;
        int var3 = dvsList.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            DigitalVideoDisc dvd = var2[var4];
            this.addDigitalVideoDisc(dvd);
        }

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered != 0) {
            for(int i = 0; i < this.qtyOrdered; ++i) {
                if (this.itemsOrdered[i] != disc) {
                    System.out.println("The cart is empty");
                } else {
                    for(int j = i; j < this.qtyOrdered; ++j) {
                        this.itemsOrdered[j] = this.itemsOrdered[j + 1];
                    }

                    this.itemsOrdered[this.qtyOrdered - 1] = null;
                    --this.qtyOrdered;
                    System.out.println("The disc has been removed successful");
                }
            }
        }

    }

    public float totalCost() {
        float totalCost = 0.0F;

        for(int i = 0; i < this.qtyOrdered; ++i) {
            totalCost = this.itemsOrdered[i].getCost();
        }

        return totalCost;
    }

    public void listOrders() {
        System.out.println("*******************CART***************");
        System.out.println("Ordered Items: ");

        for(int i = 0; i < this.qtyOrdered; ++i) {
            System.out.println(i + 1 + "." + this.itemsOrdered[i].toString());
        }

        System.out.println("Total Cost: " + this.totalCost());
        System.out.println("**************************************");
    }

    public void searchById(int idSearch) {
        boolean isMatch = false;

        for(int i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i].getId() == idSearch) {
                DigitalVideoDisc var10001 = this.itemsOrdered[i];
                System.out.println("Found: " + var10001.toString());
                isMatch = true;
                break;
            }
        }

        if (!isMatch) {
            System.out.println("No match is found");
        }

    }

    public void searchByTitle(String titleSearch) {
        boolean isMatch = false;

        for(int i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i].getTitle() == titleSearch) {
                DigitalVideoDisc var10001 = this.itemsOrdered[i];
                System.out.println("Found: " + var10001.toString());
                isMatch = true;
                break;
            }
        }

        if (!isMatch) {
            System.out.println("No match is found");
        }

    }
}

