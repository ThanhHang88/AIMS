package Test;
import Aims.DigitalVideoDisc;
import Aims.Store;
public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd1);      // trùng
        System.out.println("Quantity: " + store.getQtyInStore());
        store.removeDVD(dvd1);
        store.removeDVD(dvd1);   // không còn trong store
        System.out.println("Quantity: " + store.getQtyInStore());
    }
}