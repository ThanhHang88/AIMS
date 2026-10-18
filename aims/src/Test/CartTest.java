package Test;
import Aims.DigitalVideoDisc;
import Aims.Cart;



public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        //Create new dvd objects and add them to the Aims.Store.Cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Lab03-2: test overloading
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Cars");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Up");
        cart.addDigitalVideoDisc(dvd4, dvd5);                          // 2 tham số
        cart.addDigitalVideoDisc(new DigitalVideoDisc[] { dvd6 });    //mảng

        //Lab03-06: print dvds of cart
        cart.listOrders();

        //Search by id
        cart.searchById(dvd2.getId());
        cart.searchById(9999);

        //Search by Title
        cart.searchByTitle("The Lion King");
        cart.searchByTitle("Never");
    }
}
