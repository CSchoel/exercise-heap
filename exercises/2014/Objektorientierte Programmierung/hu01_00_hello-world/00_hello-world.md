---
author:
- "Christopher Schölzel"
id: cd077451-7d1b-42d7-aa5c-1a048e4b1ebe
keywords:
- language: java
- semester: 1
- major: computer science
- institution: Technische Hochschule Mittelhessen
- course: Objektorientierte Programmierung
- requires: Eclipse
- teaches: print
- teaches: eclipse
- teaches: javadoc
lang: de-DE
solution-size: 10
source: https://git.thm.de/cslz90/oop-cs
title: Hello World
---

# Hello World

1.  Öffnen Sie Eclipse und legen Sie ein neues Java-Projekt namens
    `OOP-U01` an.

2.  Erstellen Sie in diesem Projekt ein neues Paket namens `oopU1`;

3.  Erstellen Sie in diesem Paket eine neue Klasse namens `HelloWorld`.

4.  Ersetzen Sie den Inhalt der Datei `HelloWorld.java` durch den
    folgenden:

        package oopU1;
        /**
         * Mein erstes Hello-World-Programm
         * @author hier kommt ihr Name hin
         */
        public class HelloWorld {
          public static void main(String[] args) {
            System.out.println("Hello, World!");
          }
        }

5.  Stellen Sie sicher, dass Sie Ihr Programm ausführen können.
    (Entweder durch Klick auf den Start-Button, oder durch Rechtsklick
    auf die Datei $\rightarrow$ Run as.. $\rightarrow$ Java Application)

6.  Tragen sie in den strukturierten Javadoc-Kommentar (`/**...*/`)
    ihren eigenen Namen hinter das `@author` ein.

7.  Ändern Sie die Ausgabe - zum Beispiel in `\glqq `{=latex}Hello,
    OOP!`\grqq`{=latex}.

