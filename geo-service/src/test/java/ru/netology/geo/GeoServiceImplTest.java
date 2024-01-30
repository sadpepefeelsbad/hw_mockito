package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {

    @Test
    void testByIp_RUSSIA() {

        GeoService geoService = new GeoServiceImpl();

        final String ip = "172.0.0.1";
        final Location expected = new Location("Moscow", Country.RUSSIA, null, 0);

        final Location result = geoService.byIp(ip);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void testByIp_USA() {

        GeoService geoService = new GeoServiceImpl();

        final String ip = "96.0.0.1";
        final Location expected = new Location("New York", Country.USA, null, 0);

        final Location result = geoService.byIp(ip);

        Assertions.assertEquals(expected, result);

    }
}