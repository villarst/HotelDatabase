#ifndef _RFID_H_
#define _RFID_H_

#include <MFRC522.h>
#include <SPI.h>

#define SS_PIN    10
#define RST_PIN   5

MFRC522 RFID(SS_PIN, RST_PIN);

int code[] = {214, 43, 205, 61}; //Enter your UID
String uidString;

void setupRFID();
bool newCard();
bool readCard();


#endif //_RFID_H_