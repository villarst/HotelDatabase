#include "RFID.h"
#include "LED.h"

void setup() {

  Serial.begin(9600);

  setupRFID();
  setupLED();

}

void loop() {

  bool value;

  if (newCard())
  {
    value = readCard();

    if (value == true)
    {
      Serial.println("Verified Card: Access Granted");
      setLEDColor(GREEN);
      displayLED();
    } 
    else
    {
      Serial.println("Unknown Card: Access Denied");
      setLEDColor(RED);
      displayLED();
    }

  }

  delay(100);

}