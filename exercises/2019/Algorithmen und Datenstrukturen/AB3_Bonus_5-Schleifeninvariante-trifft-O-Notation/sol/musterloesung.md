### Musterlösung:

## Aufgabe 1
I.A.: j = 1

prod<sub>1</sub> = 1 · a[1] = a[1]

I.S.: prod<sub>j</sub> = ∏<sup>j</sup><sub>k = 1</sub> a[k] = I.V.

prod<sub>j + 1</sub> = prod<sub>j</sub> · a[j + 1]

= ( ∏<sup>j</sup><sub>k = 1</sub> a[k] ) · a[j + 1]

= ∏<sup>j+1</sup><sub>k = 1</sub> a[k]

<sub>q.e.d.</sub> :blossom:

## Aufgabe 2
### Aufgabe 2.1:
O(n²)

### Aufgabe 2.2:
```
algorithm partialProd ( a[1..n]: int[]):
  p[1..n] (:= Array der Länge n)
  p[1] = a[1]
  int i := 2
  while (i <= n)
    p[i] := p[i - 1] · a[i]
    i := i + 1
  return p
```