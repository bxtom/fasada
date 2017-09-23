package clients;

import cars.Fasada;

public class Klient {
    public static void main(String[] args) {
        Fasada fasada = new Fasada();
        fasada.zatankujAuto();
        fasada.polakierujAuto();
        fasada.umyjAuto();
    }



}
