boolean stonecolor = true;
class ConnectFour {                      //Spielklasse, enthält Variablen und Methodem
  int [][] gird;                         //Variablendeklaration 

  ConnectFour () {                       //Konstruktor, Methode zur Erzeugung eines Objekts
    gird = new int [6][7];               // Variable wird als Array mit 6 Reihen und 7 Spalten angelegt
  }
  void display () {                      //erzeugt ein sichtbares Spielfeld
    for (int j= 0; j<gird.length; j++) { //in jeder Reihe
      for (int i = 0; i<gird[j].length; i++) {//wird in jeder Spalte
        fill (255);                           //ein weißes
        rect (i*size, j*size, size, size);    //Rechteck mit Höhe/Breite durch eine Variable bestimmt
        if (gird [j][i] != 0) {                 
          fill (gird [j][i] == -1 ? 255 : 0, 0, gird [j][i] == 1 ? 255 : 0);
          ellipse (i*size, j*size, size, size);    //weiße/auf den weißen Rechtecken nicht sichbare Kreise werden erzeugt
        }
       //   ellipse (10,10,30,30);                   
      }
    }
  }
  int win (int yPos, int xPos) {          //Methode die prüft ob in dem Spielzug gewonnen wurde
    int count = 0;                        // Zählervariable
    int farbe = gird [yPos][xPos];        // Variable für die Farbe
    
    //Senkrecht gewinnen
    for (int i = yPos; i<yPos+4 && i<gird.length; i++) {
      if (gird [i][xPos] == farbe) count++;
      else break;
    }
    
    if (count == 4) return farbe;
    
    //Waagerecht gewinnen
    count = 0;
    for (int i= xPos; i<xPos+4 && i<gird[0].length; i++) {
    if (gird [yPos][i] == farbe) count++;
    else break;
    }
    
    for (int i = xPos; i>xPos-4 && i>=0; i--) {
     if (gird [yPos][i] == farbe) count++;
     else break;
    }
    count-=1;
    
    if (count >= 4) return farbe;
  
    //Diagonal gewinnen
    count = 0;
    for (int i= 0; i<4 && i+xPos<gird[0].length && i+yPos<gird.length; i++) {
    if (gird [yPos+i][xPos+i] == farbe) count++;
    else break;
    }
    
    for (int i=0; i<4 && xPos-i>=0 && yPos-i>=0; i++) {
    if (gird [yPos-i][xPos-i] == farbe) count++;
    else break;
    }
    count-=1;
    if (count >= 4) return farbe;
    
    count = 0;
    for (int i=0; i<4 && xPos+i<gird[0].length && yPos-i>=0; i++) {
    if (gird [yPos-i][xPos+i] == farbe) count++;
    else break;
    }
    for (int i=0; i<4 && xPos-i>=0 && yPos+i<gird.length; i++) {
    if (gird [yPos+i][xPos-i] == farbe) count++;
    else break;
    }
    count-=1;
    if (count >=4) return farbe;
    
    
    return 0;
  
   

}
  
  int SelectSpace (int x) {                          // sucht in der geklickten Spalte
    for (int y = gird.length -1; y>= 0; y--)
      if (gird [y][x] == 0) return y;                //nach der untersten freien Stelle
    return -1;
  }
  void counter () {                                  //zählt wie viele Züge
    for (int j = 0; j<gird.length; j++) {
      for (int i = 0; i<gird[0].length; i++) {
        if (gird [j][i] == 0) counter0++;
        if (gird [j][i] == -1) counterred++;          //Rot und
        if (gird [j][i] == 1) counterblue++;          //Blau gespielt haben
      }
    }
  }
}
ConnectFour connectfour = new ConnectFour ();        //erzeugt ein neus Spielfeld-Object
int size = 100;                                      //variable für die Größe von Kreisen und Rechtecken
int player= 1;                                       //Variable die angibt welcher Spieler dran ist
int counter0=0, counterred=0, counterblue=0;         //Zähler Variablen
int win2 = 0;                                        //Variable für den Gewinn

void setup () {              
  size (700, 700);                                  //Größe des Fensters (Breite,Höhe)
  ellipseMode(CORNER);                              //Koordinaten vom Kries bestimmen die obere Linke "Ecke" nicht und nicht wie bei Processing üblich den Mittelpunkt
}

void draw () {                                      //Methode in der alles steht was wiederholt ausgeführt wird
  background (255);                                 //Hintergrund wird auf weiß gesetzt
  connectfour.display ();                           //das Spielfeld wird gezeichnet
  fill (0);
  textSize(32);
  text ("0: " +counter0, 50, 650);
  text ("red: " +counterred, 200, 650);
  text ("blue: " +counterblue, 350, 650);
   if (win2 == 1) {
      noLoop();
      text ("Blau hat gewonnen!" ,height/2, width/2);
    }
    if (win2 == -1) {
      noLoop(); 
      text ("Rot hat gewonnen!", height/2, width/2);
    }  
   
   if (stonecolor)
    {
      fill(0,0,255);                              //Blaue Kreise wenn stonecolor = true ist
      ellipse(630,630,50,50);
    }
    
    else 
    {
      fill(255,0,0);                             //sonst rote Kreise
      ellipse (630,630,50,50);
    } 
}
void mousePressed () {                           //wenn die Maus geklickt wird
  int x = int (mouseX/size), y = connectfour.SelectSpace(x); //wird berechnet in welcher Spalte man ist und ruft die Methode auf welche die unterste Zeile ist
  if (y>=0) {                                                //wenn man sich innerhalb des Spielfelds befindet
    connectfour.gird [y][x] = player;                        //wird das Feld für den Spieler markiert 
    win2 = connectfour.win (y,x);                            //es wird geprüft ob der Spielzug zum Gewinn führt
        player = player == -1 ? 1 : -1;                      //es wird geprüft welcher Spieler gerade dran war und setzt es auf den nächsten Spieler
    counter0= 0; 
    counterred = 0;                                                   
    counterblue = 0; 
    connectfour.counter ();                                  //Spielzug-Zähler wird aufgerufen
    
    stonecolor = !stonecolor;                                //die Variable stonecolor wechselt von true auf false oder von false auf true
  }                                                          //damit im nächsten Zug die andere Farbe gespielt wird
}