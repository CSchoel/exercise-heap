# Schleifeninvarianten
## Musterlösung
### Aufgabe 1
Der Algorithmus liefert des Rest einer Division: Modulo

### Aufgabe 2
Vor erstem Schleifendurchlauf:

```
q = 0, r = a
  => q * b + r
      = 0 * b + a
      = a
```
Es gelte die Schleifeninvariante vor dem i-ten Schleifendurchlauf (i-1):

q<sub>i-1</sub> \* b + r<sub>i-1</sub> = a

Beim i-ten Schleifendurchlauf gilt:<br /> q<sub>i</sub> = q<sub>i-1</sub> + 1 und r<sub>i</sub> = r<sub>i-1</sub> - b

=> q<sub>i</sub> \* b + r<sub>i</sub> = (q<sub>i-1</sub> + 1) \* b + r<sub>i-1</sub> - b <br />= q<sub>i-1</sub> \* b + r<sub>i-1</sub> <br \>= a
