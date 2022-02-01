---
author:
- "Christopher Schölzel"
id: 00e1f5d1-8fa5-49b4-8b2a-ffe73ed06117
keywords:
- language: java
- semester: 1
- major: computer science
- institution: Technische Hochschule Mittelhessen
- course: Objektorientierte Programmierung
- requires: Eclipse
- teaches: jar
- teaches: executable
- submission: executable
lang: de-DE
solution-size: 1
source: https://git.thm.de/cslz90/oop-cs
title: Jar-Datei
---

# Jar-Datei

1.  Vergewissern Sie sich, dass das Programm immer noch ohne Fehler
    ausführbar ist.

2.  Öffnen Sie den Wizard für Jar-Exporte (File $\rightarrow$ Export..
    $\rightarrow$ Jar-File)

3.  Stellen Sie sicher, dass die Datei `HelloWorld.java` unter den zu
    exportierenden Dateien aufgelistet ist.

4.  Entfernen Sie unnötige Dateien aus der Auswahl (z.B. `.classpath`
    und `.project`, die von Eclipse angelegt werden).

5.  Setzen Sie Häkchen bei `\glqq `{=latex}Export generated class files
    and resources`\grqq{}`{=latex} und `\glqq `{=latex}Export Java
    source files and resources`\grqq{}`{=latex}.

6.  Geben Sie einen Speicherort für die Datei an (die Dateiendung für
    Jar-Dateien ist `.jar`).

7.  Klicken Sie zweimal auf `\glqq `{=latex}Next`\grqq`{=latex}.

8.  Vergewissern Sie sich dass die Option `\glqq `{=latex}Generate the
    manifest file`\grqq{}`{=latex} ausgewählt ist und wählen Sie unter
    `\glqq `{=latex}Main class:`\grqq{}`{=latex} Ihre `HelloWorld`
    Klasse aus.

9.  Drücken Sie Finish.

10. Jar-Dateien sind Archive, die mit Kompressionsprogrammen wie z.B.
    7Zip (http://www.7-zip.de/) geöffnet werden können. Vergewissern Sie
    sich, dass das erstellte Archiv sowohl die Datei `HelloWorld.class`
    als auch die Datei `HelloWorld.java` enthält.

Hinweis: 

*Auf Geräten mit sehr kleinem Bildschirm (Netbook, iPad, etc) kann es passieren, dass die Menüleisten von Eclipse nicht vollständig dargestellt werden können. Eventuell haben Sie in so einem Fall noch die Chance weiterzukommen indem Sie Ihre Task-Leiste ausblenden (unter Windows: Rechtsklick auf die Taskleiste → Eigenschaften → Häckchen bei Taskleiste automatisch ausblenden setzen). Wenn alle Stricke reißen, müssen Sie die Jar-Datei mit den Konsolen-Tools selbst erstellen (`javac` und `jar`).*
