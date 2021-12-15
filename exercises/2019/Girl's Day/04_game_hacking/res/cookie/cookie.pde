color cookieBraun = #A06D1B;                  //setzt die Farbe der Variable mit einem IDCode
color schokoladenBraun = color(62,39,3);      //setzt die Farbe der Variable mit RGB-Werten

float cookieX = 0;                            //x-Coordinate des Kekses
float cookieY = 0;                            //y-Coordinate des Kekses
float cookieSpeedX = 0;                       //Bewegung des Kekses in X-Richtung
float cookieSpeedY = 0;                       //Bewegung des Kekses in y-Richtung
float schwerkraft = 0.1;                      // Faktor für die Schwerkraft
float speedFaktor = 0.1;                      //Faktor mit dem die Geschwindigkeit multipliziert wird

boolean cookieFliegt = false;                 //Variable die angibt ob aktuell ein fangbarer Keks im Spiel ist
float korbX = 0;                              //x-Coordinate für den Korb
float korbY = 0;                              //y-Coordinate für den Korb
float korbSpeed = 2;                          //Startgeschwindigkeit des Korbs
float korbBreite = 100;                       //siehe Variablenname
float monsterCookieBreite = 150;              //Breite des anklickbaren Kekses
float monsterCookieX;                         //x-Coordinate des anklickbaren Kekses
float monsterCookieY;                         //y-Coordinate des anklickbaren Kekses


int cookieBreite = 50;                       //Durchmesser der enstehenden Kekse 
int schokoBreite = 10;                       //Durchmesser der Schokostückchen
int cookies = 0;                             //Zählervariable für die gefangenen Kekse
  
void zeichneCookie(float x, float y) {       //Methode die neue Kekse an vorgegebenen Coordinaten erstellt wenn sie aufgerufen wird
  fill(cookieBraun);                         //ab hier bis eine andere Farbe angegeben wird wird alles mit dieser Farbe ausgefüllt
  ellipse(x,y,cookieBreite,cookieBreite);    //Kreis als Keksbasis (x-Coordinate Mittelpunkt,y-Coordinate Mittelpunkt,Breite,Höhe
  fill(schokoladenBraun);                    //ab hier alles in dieser Farbe ausgefüllt
  ellipse(x + 10,y + 15, schokoBreite, schokoBreite);   //Kreise für Schokostückchen mit unterschiedlichen 
  ellipse(x - 10,y - 20, schokoBreite, schokoBreite);   //Positionen in Bezug auf den Mittelpunkt des 
  ellipse(x - 3 ,y +  1, schokoBreite, schokoBreite);   //Kekskreises
  ellipse(x + 5, y - 10, schokoBreite, schokoBreite);
  ellipse(x - 18,y     , schokoBreite, schokoBreite);
  ellipse(x + 20,y -  5, schokoBreite, schokoBreite);
  ellipse(x - 10,y + 18, schokoBreite, schokoBreite);
}                                          //Ende der Methode

void zeichneKorb(float x) {                //Methode die den Korb erstellt wenn sie aufgerufen wird
  arc(x, korbY, korbBreite, korbBreite * 0.5, 0, PI, PIE);  //Kreisabschnitt = Halbkreis weil PI, (x-koordinate,y-koordinate, Breite, Höhe, Startpunkt auf dem Kreis, Art der Schließung)
  line(korbX - korbBreite * 0.5, korbY, korbX - korbBreite * 0.5, korbY - korbBreite * 0.25);  //linker Strich (x1,y1,x2,y2)
  line(korbX + korbBreite * 0.5, korbY, korbX + korbBreite * 0.5, korbY - korbBreite * 0.25);  //rechter Strich
}                                         //Ende der Methode                                          

void setup() {                           //Alles hierin wird ein einziges Mal beim öffnen des Fenster ausgeführt
  size(800, 600);                        //größe des Fensters (Breite, Höhe)
  korbY = height - 50;                   // Y-Koordinate für den Mittelpunkt des Korbs 50 Pixel(?) vom unteren Fensterrand gesetzt
  monsterCookieX = width / 2.0;          //x-Koordinate für den Mittelpunkt des Ursprungskeks auf die Hälfte der Fensterbreite gesetzt
  monsterCookieY = monsterCookieBreite + 50;  //y-Koordinate für den Mittelpunkt des Ursprungskeks in Abhängigkeit seines Durchmessers + 50 gesetzt 
}

void draw() {                            //Alles hierin wird so lange wie das Fenster offen ist ausgeführt (standardmäßig 60x die Sekunde)
  background(255);                       //setzt den Hintergrund auf weiß
  for(int i = 0; i < cookies ; i++) {    //Schleife die für jeden gefangenen Keks
    float x = (i * cookieBreite) % width + cookieBreite / 2;    //immer um einen Keks nach rechts verschoben
    int y = floor(i * cookieBreite / width);                    //von unten Reihenweise
    zeichneCookie(x, height - (y+0.5) * cookieBreite);          //einen Keks zeichnet
  }                                     //Ende der Schleife
  fill(255,200);                        //(Farbe, Transparenz)
  rect(-1,-1,width+2,height+2);         //Zeichnet weißes, leicht transparentes Rechteck über den Hintergrund damit die gefangenen Kekse heller erscheinen
  
  pushMatrix();                        //wechselt in ein anderes Koordinatensystem //<>//
  translate(monsterCookieX, monsterCookieY);      //bestimmt die Verschiebung des Koordinatensystems in Bezug auf das aktuelle, in diesem Fall ist (0,0) des neuen Systems der Mittelpunkt des Monstercookie
  scale(monsterCookieBreite / cookieBreite);      //Bestimmt die Skalierung der neuen Koordinatensystems, in diesem Fall um den Faktor vergrößert wie der Ursprungskeks größer sein soll als die erzeugten Kekse
  zeichneCookie(0, 0);                //Zeichnet den Monstercookie Skaliert 
  popMatrix();                        //geht wieder auf das Normale Koordinatensystem
  
  if (cookieFliegt) {                  //falls aktuell ein fangbarer Keks im Speil ist
    cookieSpeedY += schwerkraft;       //Schwerkraft soll auf den Keks wirken
    cookieX = cookieX + cookieSpeedX;  //der Keks wird um seine X-Geschwindigkeit nach links/rechts verschoben
    cookieY = cookieY + cookieSpeedY;  //der keks wird um seine y-Geschwindigkeit + schwerkraft nach unten verschoben
    zeichneCookie(cookieX,cookieY);    // der Keks wird an seiner neuen Position gezeichnet
  }
  
  korbX = korbX + korbSpeed;          //der korb bewegt sich entlang der x-Achse
  zeichneKorb(korbX);                 //und wird neu gezeichnet
  
  if (korbX < 0 || korbX > width) {   //falls der Korb nach links oder rechst am Fensterrand ankommt 
    korbSpeed = -1 * korbSpeed;       //geht er mit der selben Geschwindigkeit in die entgegengesetzte Richtung weiter
  }
  if (cookieY > height + cookieBreite) {  //Falls der aktuelle Keks den unteren Fensterrand verlässt
    cookieFliegt = false;                 //wird die variable für keks im Spiel umgestellt
  }
  
  float abstandZuMonsterCookie = dist(mouseX, mouseY, monsterCookieX, monsterCookieY);  //Variable die den Abstand zwischen der Maus und dem Mittelpunkt des großen Keks enthält
  boolean mausAufMonsterCookie = abstandZuMonsterCookie < monsterCookieBreite / 2;      //Variable die besagt ob die Maus auf dem Keks ist (gibt true zurück wenn der Abstand von der Maus zum Mittelpunkt kleiner ist als der Radius)
  if(!cookieFliegt && mousePressed && mausAufMonsterCookie)  {                          //Falls kein Keks im Spiel ist und die Maus geklickt wird und auf dem großen Keks ist
    cookieX = mouseX;                                                                   //wird die X-Koordinate für den neuen Keks auf die x-Koordinate der Maus gesetzt     
    cookieY = mouseY;                                                                   //selbiges für die y-Koordinate 
    cookieSpeedX = (mouseX - monsterCookieX)*speedFaktor;                               //die Geschwindigkeit und Flugrichtung für den Keks wird in X-Richtung
    cookieSpeedY = (mouseY - monsterCookieY)*speedFaktor;                               //und y-Richtung bestimmt auf Basis der Mausposition in Abhängigkeit vom Mittelpunkt des großen Keks
    cookieFliegt = true;                                                                //die Variable für Keks im Spiel wird auf wahr gesetzt
  }
  
  if (cookieFliegt && cookieY >= korbY && abs(cookieX - korbX) < korbBreite*0.5) {      //Falls ein Keks im Spiel ist und im Korb landet
    cookieFliegt = false;              //wird die Variable für Keks im Spiel umgestellt
    cookies = cookies + 1;             //und der Zähler für die gefangenen Kekse wird um 1 erhöht
  }
  
  textAlign(CENTER);                  //Die Koordinaten des Texts bestimmen wo der Mittelpunkt ist 
  textSize(40);                       //Textgröße wird auf 40 gesetzt
  text("Click den Cookie!", width/2, 40);  //("text der ausgegeben werden soll", x-koordinate, y-koordinate)
  textSize(20);                       //Textgröße  auf 20
  String text = "Cookies gefangen: "+cookies;  //Textvariable bekommt Inhalt
  text += "  Cookies pro Sekunde: "+nf(cookies*1000.0/millis(),0,3); //weitere Text in die Variable hinzugefügt
  text(text, width/2, 80);            //textausgabe
}