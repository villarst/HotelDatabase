#ifndef _LED_H_
#define _LED_H_

#include <Adafruit_NeoPixel.h>

#define LED_PIN         6
#define LED_NUM         8
#define LED_BRIGHTNESS  50

#define RED     255,     0,     0
#define ORANGE  255,    40,     0
#define YELLOW  255,   255,     0
#define GREEN     0,   255,     0
#define BLUE      0,     0,   255
#define PURPLE  255,     0,   255
#define WHITE   255,   255,   255
#define OFF       0,     0,     0

Adafruit_NeoPixel LED(LED_NUM, LED_PIN, NEO_GRB + NEO_KHZ800);

uint32_t Neopixel[LED_NUM];

void setupLED();
void displayLED();
void setLEDColor(int red, int green, int blue);
void clearLED();

#endif //_LED_H_
