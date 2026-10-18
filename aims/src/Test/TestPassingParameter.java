package Test;
import Aims.DigitalVideoDisc;
public class TestPassingParameter {

    // Bọc tham chiếu để có thể hoán đổi thật sự
    private static class DVDWrapper {
        DigitalVideoDisc dvd;
        DVDWrapper(DigitalVideoDisc dvd) { this.dvd = dvd; }
    }

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        // swap đúng
        DVDWrapper w1 = new DVDWrapper(new DigitalVideoDisc("Jungle"));
        DVDWrapper w2 = new DVDWrapper(new DigitalVideoDisc("Cinderella"));
        swapCorrect(w1, w2);
        System.out.println("After correct swap: w1 = " + w1.dvd.getTitle() + ", w2 = " + w2.dvd.getTitle());
    }

    // Sai: chỉ hoán đổi bản sao của tham chiếu
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Đúng: hoán đổi tham chiếu bên trong wrapper
    private static void swapCorrect(DVDWrapper w1, DVDWrapper w2) {
        DigitalVideoDisc tmp = w1.dvd;
        w1.dvd = w2.dvd;
        w2.dvd = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
