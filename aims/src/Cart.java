public class Cart {
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

}
