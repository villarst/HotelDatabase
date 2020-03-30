#include "LED.h"

void setupLED()
{
  LED.begin();           
  LED.show();            
  LED.setBrightness(LED_BRIGHTNESS);
}

void displayLED()
{
  int i;

  for(i = 0; i < LED_NUM; i++)
    LED.setPixelColor(i, Neopixel[i]);

  LED.show();
}

void setLEDColor(int red, int green, int blue)
{
  int i;

  for(i = 0; i < LED_NUM; i++)
    Neopixel[i] = LED.Color(red, green, blue);

}

void clearLED()
{
  int i;

  for(i = 0; i < LED_NUM; i++)
    Neopixel[i] = LED.Color(OFF);

  displayLED();
}
