package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    void testLocale_Russian() {

        LocalizationService localizationService = new LocalizationServiceImpl();

        final Country country = Country.RUSSIA;
        final String expected = "Добро пожаловать";

        final String result = localizationService.locale(country);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testLocale_English() {

        LocalizationService localizationService = new LocalizationServiceImpl();

        final Country country = Country.USA;
        final String expected = "Welcome";

        final String result = localizationService.locale(country);

        Assertions.assertEquals(expected, result);
    }
}