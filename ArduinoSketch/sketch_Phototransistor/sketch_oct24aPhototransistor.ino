  // Led light is set to default off and to light up as the transistor value drops under 20.
  // The value is measured and compared every 5 seconds.
  
  //#include <Arduino>
 
  const float LEDPin = 10;
  const int SensorPin = A0;
  const float  threshold= 20.0;

  int Sensor = 0;

void setup() {
Serial.begin(9600);
pinMode(LEDPin, OUTPUT);
}
void loop() {
digitalWrite(LEDPin, LOW);
Sensor = analogRead(SensorPin);

Serial.println(Sensor);

if(Sensor<threshold)
  digitalWrite(LEDPin, HIGH);

delay(5000);
}
