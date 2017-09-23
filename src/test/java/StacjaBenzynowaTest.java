import cars.RodzajPaliwa;
import cars.Samochod;
import cars.StacjaBenzynowa;
import cars.ZaDuzoPaliwaException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertFalse;

public class StacjaBenzynowaTest {

    Samochod samochod;
    static StacjaBenzynowa stacjaBenzynowa;

    @BeforeClass
    public static void setup() {
        stacjaBenzynowa = new StacjaBenzynowa();
    }

    @Test
    public void kiedyZatankowanoDoPelna() {
        // given
        samochod = new Samochod(50, 20, RodzajPaliwa.DIESEL);

        // when
        stacjaBenzynowa.wlejDoPelna(samochod);

        // then
        assertThat(samochod.getAktualnyPoziomPaliwa()).isEqualTo(samochod.getPojemnoscZbiornika());
    }

    @Test(expected = ZaDuzoPaliwaException.class)
    public void powinienZglosicZeZaDuzoPaliwa() throws ZaDuzoPaliwaException {
        samochod = new Samochod(100, 20, RodzajPaliwa.DIESEL);
        stacjaBenzynowa.wlejPaliwo(samochod, 101);
    }

    @Test
    public void powinienZatankowacAleNieDoPelna() throws ZaDuzoPaliwaException {
        // given
        samochod = new Samochod(100, 50, RodzajPaliwa.DIESEL);

        // when
        stacjaBenzynowa.wlejPaliwo(samochod, 49);

        // then
        assertThat(samochod.getAktualnyPoziomPaliwa())
                .isNotEqualTo(0)
                .isLessThan(samochod.getPojemnoscZbiornika());
    }

    @Test
    public void powinienNalewac() {
        assertThat(stacjaBenzynowa.sprawdzMozliwoscZatankowania(50)).isTrue();
    }

    @Test
    public void powinienNieNalewac() {
        assertThat(stacjaBenzynowa.sprawdzMozliwoscZatankowania(500)).isFalse();
    }

    @Test
    public void czyDobrzeWyliczonoCeneSprzedazy() throws ZaDuzoPaliwaException {
        // given

        // when
        samochod = new Samochod(100, 50, RodzajPaliwa.DIESEL);

        // then
        assertThat(stacjaBenzynowa.obliczCeneDoZaplaty(samochod, 1)).isEqualTo(new BigDecimal("4.5"));
    }
}
