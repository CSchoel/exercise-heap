/*
"Flappy Bird" game for Girl's Day 2015
Author: Christopher Schölzel
*/
float x = 50;            //x-Variable für den Vogel
float y = 200;           //y-Variable für den Vogel
float vy = -3;           //Fallgeschwindigkeit
float wingYoff = 0;      //Variable für die Flügelstellung
float hx;                //x-Variable für das Hindernis
float hy;                //y-Variable für das Hindernis
float hvx = -3;          //Hindernisgeschwindigkeit
float hw = 20;           //Hindernisbreite
float opening = 150;     //Größe der Öffnung im Hindernis/ Abstand zwischen den Rechtecken
boolean gameover = false;//Variable die angibt ob man verloren hat
boolean passed = false;  //Variable ob man das Hindernis überwunden hat
int lastflap = 0;        //Variable die angibt wann der letzte Flügelschlag erfolgt ist
int flaptime = 500;      //maximaler Zeitabstand Zwischen clicken und Flügelschlag
int counter = 0;         //Zählervariable für überwundene Hindernisse

void setup() {          //alles hierin wird nur ein mal beim öffnen des Fensters ausgeführt
  size(800,600);        //gibt die Größe des Fensters vor (Breite, Höhe)
  x = width/2.0;        //setzt x auf die mitte des Fensters
  hx = width+hw;        //setzt die x-Variable für das Hindernis direkt außerhalb des rechten Fensterrandes
  hy = opening+random(height-opening*2);  //setzt die y-variable für das Hinderniss auf einen zufälligen(random) Wert zwischen 0 und der höhe des Fensters - 2x der Öffnungsgröße
}

void draw() {                      //alles hierin wird immer wieder (im Normalfall ca 60x die sekunde) ausgeführt
  int mslf = millis()-lastflap;    //ermittelt wie lange der letzte Klick her ist
  if(mslf < flaptime) {            //wenn der letzte Klick weniger als die in flaptime vorgegebenen millisekunden her ist 
    wingYoff = -(1-cos(TWO_PI*mslf/flaptime))*30;  //wird ein Flügelschlag ausgelöst (y position für die spitze des Flügels berechnet)
  }
  background(200,200,255);         //Hintergrund wird auf ein helles grau gesetzt
  hx += hvx;                       //das Hindernis wird nach links verschoben
  
  if (hx < -hw) {                  //Falls das Hindernis das Fenster nach links komplett verlassen hat
    hx = width+hw;                 //wird die x-Variable für das Hindernis wieder außerhalb vom rechten Fensterrand gesetzt
    hy = opening+random(height-opening*2);// wird die Öffnungshöhe durch Zufall neu bestimmt
    passed = false;                //die Überwindungsvariable wird wieder zurückgesetzt
  }
  if(x > hx && x < hx+hw) {        //Falls der Vogel auf der selben x-Position ist wie das Hindernis  
    if(y < hy || y > hy + opening) {//Falls er sich nicht auf der Höhe der Öffnung befindet
      hvx = 0;                      //wird das Hindernis gestoppt
      gameover = true;              //und gameover auf true gesetzt
    } else if (!passed && !gameover) {//Sonst wenn das Hindernis weder als bereits überwunden galt noch gameover auf true gesetzt ist
      counter++;                    //wird die Anzahl überwundener Hindernisse um 1 erhöht
      passed = true;                //und das Hindernis als überwunden markiert
    }
  }
  fill(0,100,0);                              //füllt alles bis zur nächsten Farbangabe grün
  rect(hx,0,hw,hy);                           //zeichnet ein Rechteck vom oberen Fensterrand (x1, y1, x2, y2)
  rect(hx,hy+opening,hw,height-hy-opening);   //zeichnet ein zweites rechteck mit einem vorgegebenen Abstand zu dem ersten, bis zum unteren Fensterrand
  noStroke();                                 //alles ab hier hat keine sichtbare Umrandung
  fill(100,100,100);                          //ab hier grau eingefärbt
  triangle(x-20,y,x-40,y-10,x-40,y+10);       //zeichnet ein Dreieck (x1,y1,x2,y2,x3,y3) Schwanz
  fill(180,255,100);                          //ab hier alles hellgrün
  ellipse(x,y,50,20);                         //Zeichnet eine ovale form (x,y,Länge, Höhe) Körper
  ellipse(x+30,y,20,15);                      //zeichnet ein weiteres Oval um 30 nach rechts verschoben und kleiner als die erste, Kopf
  fill(100,100,100);                          //ab hier wieder grau
  triangle(x-15,y,x+15,y,x-25,y+30+wingYoff); //zeichnet ein weiteres Dreieck abhängig von der Wingoff variable ob der Flügel nach oben oder unten steht
  fill(255,255,0);                            //ab heir gelb
  triangle(x+40,y-3,x+40,y+3,x+50,y);         //kleines Dreieck, Schnabel
  fill(0);                                    //ab hier schwarz
  ellipse(x+33,y-1,4,4);                      //kleiner Kreis, Auge
  y += vy;                                    //erhöht y um vy -> der Vogel fällt
  vy += 0.1;                                  //erhöht die Fallgeschwindigkeit um 0.1
  if (y >= height) {                          //falls der Vogel den Boden berührt
    y = height;                               //bleibt er dort 
    hvx = 0;                                  //die Hindernisse hören auf sich zu bewegen
    gameover=true;                            //gameover wird auf true gesetzt
  }
  textSize(30);                               //in der Schriftgröße 30 wird
  text(counter,width-50,50);                  //der Wert von counter wird oben rechts ausgegeben
  if(gameover){                               //falls gameover = true ist
    textAlign(CENTER);                        //wird der Text am Mittelpunkt verankert
    textSize(40);                             //in Schriftgröße 40 wird
    text("Game Over", width/2, height/2);     //Game Over in der Mitte vom Bildschirm ausgegeben
    }
}
void mousePressed() {       //Während die Maus gedrückt wird
  if(!gameover) {           // wenn gameover nicht true ist
    vy = -5;                // fliegt der Vogel kurz nach oben
    lastflap = millis();    //die variable lastflap bekommt den Wert der seit Programmstart vergangenen Millisekunden
  } 
}
void keyPressed() {         //wenn eine Taste gedrückt ist
  if(key == ' ') {          //falls diese Taste das Leerzeichen ist
    gameover = false;       //wird gameover auf false gesetz
    hvx = -3;               //die Geschwindigkeit der Hindernisse wird neu gesetzt
    x = 50;                 //die x-Variable für den Vogel neu gesetzt
    y = 200;                //ebenso die y-Variable
    vy = -3;                //und die Fallgeschwindigkeit
    hx = width + hw;        //die x-Variable für das Hinderniss wird wieder außerhalb des rechten Fensterrand gesetzt
    counter = 0;            //der Zähler genullt
    passed = false;         //die Überwindungsvariable zurückgesetzt 
  }        //Bzw das Spiel neu gestartet
}