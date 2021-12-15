float x,y;                  //x und y Koordinaten der Schlange
float speed = 1;            //Geschwindigkeit der Schlange
float drehSpeed = 0.3;      //Drehgeschwindigkeit der Schlange
float direction = 0;         //Richtungsvariable
color bgColor = color(0,0,0);//Hintergrundfarbe
color snakeColor = color(random(225), random(225), random(225));  //für die verschiedenen Schlangenfarben
color pointColor = color(random(10,225), random(10,225), random(10,225));  //für die verschiedenen Punktfarben
float px, py;                //x und y Koordinaten der Punkte
float pxLast,pyLast;         //Koordinaten des letzten Puntes

void setup() {
  size(800, 600);            //Größe des Fensters
  background(bgColor);
  x = width/2;               //x-Koordinate der Schlange wird mittig platziert
  y = height/2;              //y-Koordinate der Schlange wird mittig platziert
  px = random(225);          //x-Koordinate des Punkts initalisiert
  py = random(225);          //y-Koordinate des Punkts initalisiert
  pxLast=0;                  
  pyLast=0;
}
void draw() {
  int frontX = round(x + cos(direction) * 7);    //weitere Variable für die x-Koordinate des Schlangenkopfes
  int frontY = round(y + sin(direction) * 7);    //weitere Variable für die y-Koordinate des schlangenkopfes
    if(dist(x,y,px,py)<14) {                     //Wenn die Distanz zwischen dem Schlangenkopf (x,y) und dem Punkt(px,py) kleiner 14 ist,
    pxLast=px;                                   //dann setze den letzten Punkt auf den aktuellen Punkt und
    pyLast=py;
    snakeColor = pointColor;                     //ändere die Schlangenfarbe in die Punktfarbe und
    px = random(width);                          //positioniere den Punkt neu und
    py = random(height);
    pointColor = color(random(10,225),random(10,225), random(10,225)); //setze eine neue Punktfarbe
  }
  if (get(frontX,frontY) != bgColor && dist(x,y,pxLast,pyLast)>14) {          //Wenn die nächste Position des Kopfes der Schlange nicht dieselbe Farbe 
                                                                              //des Hintergrundes ist und die Distanz zum letzten Punkt größer 14 ist, 
    noLoop();                                                                 //dann wird es gestoppt 
  }                                      
    x += cos(direction) * speed;                //Schlange bewegt sich in x-Richtung
    y += sin(direction) * speed;                //Schlange bewegt sich in y-Richtung
    noStroke();                                 //macht keine Linien
    fill(snakeColor);
    ellipse(x,y,10,10);                         //zeichnet ein Kreis als Schlangenkopf

    fill(pointColor);                           //Punkt wird gezeichnet
    ellipse(px, py, 10,10);

}
void keyPressed() {
  if (keyCode == LEFT) {                        //Wenn die linke Pfeiltaste gedrückt wird
    direction -= drehSpeed;                      //dreht sich die Schlange nach links
  } else if (keyCode == RIGHT) {                //sonst wenn die rechte Pfeiltaste gedrückt wird
    direction += drehSpeed;                      //dreht sich die Schlange nach rechts
  }
}