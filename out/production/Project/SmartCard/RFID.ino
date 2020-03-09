#include "RFID.h"

void setupRFID(){
    SPI.begin();             // Init SPI bus
    RFID.PCD_Init();         // Init MFRC522
}

bool newCard()
{
    return RFID.PICC_IsNewCardPresent();
}

bool readCard()
{

  RFID.PICC_ReadCardSerial();
  MFRC522::PICC_Type piccType = RFID.PICC_GetType(RFID.uid.sak);

  Serial.print("\nScanned ID: ");

  uidString = String(RFID.uid.uidByte[0]) + " "
            + String(RFID.uid.uidByte[1]) + " " 
            + String(RFID.uid.uidByte[2]) + " " 
            + String(RFID.uid.uidByte[3]);

  Serial.println(uidString);
  //printUID();

  int i = 0;
  boolean match = true;
  while (i < RFID.uid.size)
  {
    if (!(RFID.uid.uidByte[i] == code[i]))
    {
      match = false;
    }

    i++;
  }

  RFID.PICC_HaltA();
  RFID.PCD_StopCrypto1();

  return match;
}