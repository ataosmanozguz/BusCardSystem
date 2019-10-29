package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WholeSystemTest {

    @InjectMocks
    WholeSystem wholeSystem;

    @Mock
    BusConsole busConsole;

    @Test
    @DisplayName("Yaraklara geldik")
    public void startTest(){

        doNothing().when(busConsole).enterCardId(32);
        wholeSystem.start();

        verify(busConsole).enterCardId(32);

    }

}