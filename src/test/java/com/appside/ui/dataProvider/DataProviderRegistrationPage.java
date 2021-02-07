package com.appside.ui.dataProvider;

import com.appside.ui.model.User;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProviderRegistrationPage {

    static Stream<Arguments> userCanRegistration() {
        return Stream.of(
                Arguments.of(new User()
                        .setFirstName("test")
                        .setLastName("test")
                        .setEmail("%@test.tes")
                        .setPhoneNumber("1234567")
                        ),
                Arguments.of(new User()
                        .setFirstName("test")
                        .setLastName("test")
                        .setEmail("%@test.tes")
                        .setPhoneNumber("1234567")
                ),
                Arguments.of(new User()
                        .setFirstName("t")
                        .setLastName("t")
                        .setEmail("t@ts.tr")
                        .setPhoneNumber("12345678")
                ),
                Arguments.of(new User()
                        .setFirstName("t")
                        .setLastName("t")
                        .setEmail("\"tt..fd\"@ts.tr")
                        .setPhoneNumber("12345678")
                ),
                Arguments.of(new User()
                        .setFirstName("test56789012345678901234567890123456789012345678901234567890")
                        .setLastName("test56789012345678901234567890123456789012345678901234567890")
                        .setEmail("test56789012345678901234567890123456789012345678901@test.ts")
                        .setPhoneNumber("1234567890123456789012345")
                )
        );
    }

    static Stream<Arguments> userCanNotRegistration() {
        return Stream.of(
                Arguments.of(new User()
                        .setFirstName("test")
                        .setLastName("test")
                        .setEmail("test")
                        .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                ),
                Arguments.of(new User()
                        .setFirstName("test")
                        .setLastName("test")
                        .setEmail("test@")
                        .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                ),
                Arguments.of(new User()
                        .setFirstName("test")
                        .setLastName("test")
                        .setEmail("test@t")
                        .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@to")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@to.")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@to.t")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("@to.t")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail(".@to.t")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@.tio.ts")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("rt..fde@to.t")
                                .setPhoneNumber("1234567"),
                        "Email введён неправильно"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("rtfde@to.td")
                                .setPhoneNumber("123456"),
                        "Номер телефона должен иметь более 7 символов"
                        ),
                        Arguments.of(new User()
                                        .setFirstName("test567890123456789012345678901234567890123456789012345678901")
                                        .setLastName("test")
                                        .setEmail("test@test.tes")
                                        .setPhoneNumber("1234567"),
                                "Введённое имя должно быть не больше 60 символов"
                                ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test567890123456789012345678901234567890123456789012345678901")
                                .setEmail("test@test.tes")
                                .setPhoneNumber("1234567"),
                        "Введённая фамилия должно быть не больше 60 символов"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test5678901234567890123456789012345678901234567890121@test.ts")
                                .setPhoneNumber(""),
                        "Email должен быть не больше 60 символов"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@test.tes")
                                .setPhoneNumber("12345678901234567890123456"),
                        "Номер телефона должен быть короче или равен 25 символам"
                        ),
                Arguments.of(new User()
                                .setFirstName("test")
                                .setLastName("test")
                                .setEmail("test@test.tes")
                                .setPhoneNumber("вапеавуп"),
                        "Номер телефона должен содержать только цифры"
                        )
                );
    }

}
