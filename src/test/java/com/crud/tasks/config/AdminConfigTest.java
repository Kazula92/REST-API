package com.crud.tasks.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AdminConfigTest {

    private AdminConfig adminConfig;

    @Test
    void showBeNullTest() {
        //Given
        adminConfig = new AdminConfig();

        //When
        String adminMail = adminConfig.getAdminMail();

        //Then
        assertNull(adminMail);
    }
}
