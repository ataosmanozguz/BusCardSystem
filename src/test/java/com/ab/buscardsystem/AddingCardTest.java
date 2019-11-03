package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddingCardTest {

    @InjectMocks
    AddingCard addingCard;
    @Mock
    FactoryInput factoryInput;
    @Mock
    Card card;

    @Test
    @DisplayName("Correct Tip Input With Öğrenci")
    void takeTipWithCorrectInputOgrenci1() {
        //Given
        when(factoryInput.inputStringTip()).thenReturn("Öğrenci");

        //When
        addingCard.takeTip();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With öğrenci")
    void takeTipWithCorrectInputOgrenci2() {
        //Given
        when(factoryInput.inputStringTip()).thenReturn("öğrenci");

        //When
        addingCard.takeTip();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With Tam")
    void takeTipWithCorrectInputTam1() {
        //Given
        when(factoryInput.inputStringTip()).thenReturn("Tam");

        //When
        addingCard.takeTip();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With tam")
    void takeTipWithCorrectInputTam2() {
        //Given
        when(factoryInput.inputStringTip()).thenReturn("tam");

        //When
        addingCard.takeTip();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Tip Input")
    void takeTipWithIncorrectInput() {
        //Given
        when(factoryInput.inputStringTip()).thenReturn("Doktor");

       //When
        addingCard.takeTip();

        //Then
       assertEquals(0, addingCard.getIsCorrect());

    }

    @Test
    @DisplayName("Correct Name Input With Barış")
    void takeNameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        //When
        addingCard.takeName();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Name Input With 14 Harften Uzun")
    void takeNameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingCard.takeName();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Surname Input With Osman")
    void takeSurnameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Surname Input With 14 Harften Uzun")
    void takeSurnameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct CardId Input")
    void takeIdWithCorrectInput(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(1);
        //When
        addingCard.takeId();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 7")
    void takeIdWithIncorrectInputWith7(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(7);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 18")
    void takeIdWithIncorrectInputWith18(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(18);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input -23")
    void takeIdWithIncorrectInputWithNegativeInteger(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-23);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input Plus 10.000")
    void takeIdWithIncorrectInputWithPlus10000(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }


    @Test
    @DisplayName("Verify setCardInfo Method Calls")
    void setCardInfoMethodCallsVerify(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        when(factoryInput.inputStringTip()).thenReturn("Öğrenci");
        when(factoryInput.inputIntegerId()).thenReturn(1);
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        doNothing().when(card).setId(1);
        doNothing().when(card).setBalance(0);
        doNothing().when(card).setName("Barış");
        doNothing().when(card).setSurname("Osman");
        doNothing().when(card).setTip("Öğrenci");
        //When
        addingCard.setCardInfo(card);
        //Then
        verify(card).setId(1);
        verify(card).setBalance(0);
        verify(card).setName("Barış");
        verify(card).setSurname("Osman");
        verify(card).setTip("Öğrenci");
        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringTip();
        verify(factoryInput).inputIntegerId();
        verify(factoryInput).inputStringSurname();
    }

}