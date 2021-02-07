package com.appside.api.dataProvider;

import com.appsode.api.model.RegistrationClick;
import com.appsode.api.model.RegistrationLid;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class DataProviderRegistrationApi {

    private static RegistrationClick click = new RegistrationClick().setPid("lalw70")
                                    .setPipeline(20)
                                    .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                    .setIp("172.122.31.13")
                                    .setCity("City")
                                    .setCountry("UA");

    static Stream<Arguments> successRegistrationNewClick() {
        return Stream.of(
                Arguments.of(new RegistrationClick()
                        .setPid("lalw70")
                        .setPipeline(20)
                        .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                        .setIp("172.122.31.13")
                        .setCity("City")
                        .setCountry("UA")
                ),
                Arguments.of(new RegistrationClick()
                        .setPid("lalw70")
                        .setPipeline(20)
                        .setRef("")
                        .setIp("172.122.31.13.ff.fd")
                        .setCity("City")
                        .setCountry("UA")
                ),
                Arguments.of(new RegistrationClick()
                        .setPid("lalw70")
                        .setPipeline(20)
                        .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                        .setIp("")
                        .setCity("")
                        .setCountry("")
                ),
                Arguments.of(new RegistrationClick()
                        .setPid("lalw70")
                        .setPipeline(20)
                        .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                        .setIp("172.122.31.13")
                )
        );
    }


    static Stream<Arguments> failedRegistrationNewClick() {
        return Stream.of(
                Arguments.of(new RegistrationClick()
                                .setPid("ghjyf")
                                .setPipeline(20)
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("pid must be longer than or equal to 6 characters"))
                ),
                Arguments.of(new RegistrationClick()
                                .setPipeline(20)
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("pid is not valid"))
                ),
                Arguments.of(new RegistrationClick()
                                .setPid("ghfylk")
                                .setPipeline(20)
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("pid  is not valid"))
                ),
                Arguments.of(new RegistrationClick()
                                .setPid("ghjyfok")
                                .setPipeline(20)
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("pid must be shorter than or equal to 6 characters"))
                ),
                Arguments.of(new RegistrationClick()
                                .setPid("lalw70")
                                .setPipeline(156548562)
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("?????"))  //должна быть валидация поля pipeline, т.к. для API register/lid
                        // это поле обязательно
                ),
                Arguments.of(new RegistrationClick()
                                .setPid("lalw70")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("?????"))  //делаю допущение что поле pipeline не может быть null,
                        // т.к. для API register/lid это поле обязательно
                ),
                Arguments.of(new RegistrationClick()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setCity("City")
                                .setCountry("RU"),
                        new ArrayList<>(Arrays.asList("?????"))  // делаю допущение что одно из полей ref или ip должны быть обязательны
                        // т.к. данное API используется для регистрации хоста сети (не ясно чьего хоста) и эти поля обязательны для регистрации лида
                )
        );
    }

        static Stream<Arguments> successRegistrationNewLid() {
            return Stream.of(
                    Arguments.of(click,
                                new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA")
                    ),
                    Arguments.of(click,
                            new RegistrationLid()
                                    .setPid("lalw70")
                                    .setPipeline(20)
                                    .setFirstname("test56789012345678901234567890123456789012345678901234567890")
                                    .setLastname("test56789012345678901234567890123456789012345678901234567890")
                                    .setPhone("1234567890123456789012345")
                                    .setEmail("test567890123456789012345678901234567890123456789012@test.ts")
                                    .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                    .setIp("255.255.255.255")
                                    .setCity("test5678t901234567890123456789")
                                    .setCountry("UA")
                    ),
                    Arguments.of(click,
                            new RegistrationLid()
                                    .setPid("lalw70")
                                    .setPipeline(20)
                                    .setFirstname("1")
                                    .setLastname("2")
                                    .setPhone("1234567")
                                    .setEmail("%@ts.tsr")
                                    .setRef("5")
                                    .setIp("0.0.0.0")
                                    .setCity("7")
                                    .setCountry("RU")
                    )
            );
    }

    static Stream<Arguments> failedRegistrationNewLid() {
        return Stream.of(
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("pid must be longer than or equal to 6 characters"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("dr2459")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("in pipeline: pid is not valid"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("pid must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("pipeline is not valid"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("firstname must be longer than or equal to 60 characters"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("firstname must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("lastname must be longer than or equal to 60 characters"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("lastname must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("123456")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("phone must be longer than or equal to 7 characters"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("phone must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("email must be an email"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("email must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("test@t.t")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("email must be an email"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("?????"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("ref must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("ip must be an ip address"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("256.256.256.256")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("ip must be an ip address"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setCity("City")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("ip must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("city must be longer than or equal to 30 characters"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCountry("UA"),
                        new ArrayList<>(Arrays.asList("city must be a string"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("U"),
                        new ArrayList<>(Arrays.asList("in pipeline: country is not valid"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("YY"),
                        new ArrayList<>(Arrays.asList("in pipeline: country is not valid"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City")
                                .setCountry("RUS"),
                        new ArrayList<>(Arrays.asList("in pipeline: country is not valid"))
                ),
                Arguments.of(click,
                        new RegistrationLid()
                                .setPid("lalw70")
                                .setPipeline(20)
                                .setFirstname("Alex")
                                .setLastname("Svoj")
                                .setPhone("73339932")
                                .setEmail("lid@gmail.com")
                                .setRef("https://maxfizer.com/hello?utm=23324&return=2342342&sub1=maxfizer")
                                .setIp("172.122.31.13")
                                .setCity("City"),
                        new ArrayList<>(Arrays.asList("country must be a string"))
                )
        );
    }
}
