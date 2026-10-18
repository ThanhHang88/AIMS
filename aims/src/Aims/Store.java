package Aims;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("The disc is null.");
            return;
        }
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                System.out.println("The disc is already in the store.");
                return;
            }
        }
        if (qtyInStore >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full.");
            return;
        }
        itemsInStore[qtyInStore++] = dvd;
        System.out.println("The disc has been added to the store.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyInStore] = null;
                System.out.println("The disc has been removed from the store.");
                return;
            }
        }
        System.out.println("The disc is not in the store.");
    }

    public int getQtyInStore() { return qtyInStore; }

    public static class Cart {
        public static final int MAX_NUMBERS_ORDERED = 20;
        private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        private int qtyOrdered = 0;

        public void addDigitalVideoDisc(DigitalVideoDisc disc){
            if (qtyOrdered < MAX_NUMBERS_ORDERED){
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered ++;
                System.out.println("The disc has been added successful");
            }
            else {
                System.out.println("The cart is almost full");
            }
        }

        public  void addDigitalVideoDisc (DigitalVideoDisc[] dvsList){
            for (DigitalVideoDisc dvd : dvsList){
                addDigitalVideoDisc(dvd);
            }
        }

        public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }


        public void removeDigitalVideoDisc(DigitalVideoDisc disc){
            if(qtyOrdered != 0){
                for(int i = 0; i< qtyOrdered; i++){
                    if(itemsOrdered[i] == disc){
                        for(int j = i; j<qtyOrdered; j++){
                            itemsOrdered[j] = itemsOrdered[j + 1];
                        }
                        itemsOrdered[qtyOrdered-1] = null;
                        qtyOrdered --;
                        System.out.println("The disc has been removed successful");
                    }
                    else {
                        System.out.println("The cart is empty");
                    }
                }
            }
        }
        public float totalCost(){
            float totalCost = 0;
            for (int i=0; i<qtyOrdered; i++){
                totalCost = itemsOrdered[i].getCost();
            }
            return totalCost;
        }
        //print the list of ordered items of a cart
        public void listOrders(){
            System.out.println("*******************CART***************");
            System.out.println("Ordered Items: ");
            for(int i=0; i<qtyOrdered; i++){
                System.out.println((i+1) + "." + itemsOrdered[i].toString());
            }
            System.out.println("Total Cost: " + totalCost());
            System.out.println("**************************************");
        }

        //Search dvd by ID
        public void searchById (int idSearch){
            boolean isMatch = false;
            for (int i=0; i<qtyOrdered; i++){
                if(itemsOrdered[i].getId() == idSearch){
                    System.out.println("Found: " +  itemsOrdered[i].toString());
                    isMatch = true;
                    break;
                }
            }
            if(isMatch == false){
                System.out.println("No match is found");
            }
        }
        //Search by title
        public void searchByTitle (String titleSearch){
            boolean isMatch = false;
            for (int i=0; i<qtyOrdered; i++){
                if(itemsOrdered[i].getTitle() == titleSearch){
                    System.out.println("Found: " +  itemsOrdered[i].toString());
                    isMatch = true;
                    break;
                }
            }
            if(isMatch == false){
                System.out.println("No match is found");
            }
        }


    }
}
