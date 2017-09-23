package cars;

public class Fasada {


    public void umyjAuto() {
        Myjnia myjnia = new Myjnia();
        myjnia.umyjAuto();
        myjnia.wysuszAuto();

    }

    public void zatankujAuto() {
        StacjaBenzynowa stacjaBenzynowa = new StacjaBenzynowa();
        stacjaBenzynowa.wlejDoPelna(new Samochod());
    }

    public void polakierujAuto() {
        Lakiernia lakiernia = new Lakiernia();
        lakiernia.polakieruj();
    }

}
