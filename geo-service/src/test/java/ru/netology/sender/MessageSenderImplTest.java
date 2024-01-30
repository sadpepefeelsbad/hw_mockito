package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void testMessageSender_Russian() {

        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp("userIp"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String expected = "Добро пожаловать";

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "userIp");

        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMessageSender_English() {

        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp("userIp"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String expected = "Welcome";

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "userIp");

        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }
}