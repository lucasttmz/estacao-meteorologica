#include "dht.h"

int pinoDHT11 = A2; 
int pinoSensorChuva = A0;
int valorChuva = 0;
dht DHT;

void setup(){
  Serial.begin(9600);
  delay(2000); 
}

void loop(){
  DHT.read11(pinoDHT11);
  valorChuva = analogRead(pinoSensorChuva);

  Serial.print(DHT.humidity);
  Serial.print(",");
  Serial.print(DHT.temperature, 0);
  Serial.print(",");
  Serial.print(valorChuva);
  Serial.println();
  delay(2000); 
}