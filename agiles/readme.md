<!--
Este documento está hecho para que el estudiante pueda indicar lo que considere
oportuno. Usa el formato [Markdown](https://www.markdownguide.org/cheat-sheet/)
-->
# Recuperación de ágiles

## UT3. Modificaciones realizadas

<!-- Indica aquí las modificaciones que hayas realizado, ejemplo: -->

### Ordenación de los botones

<!-- Puedes borrar este ejemplo, todo el apartado -->

He ordenado la creación de elementos en la pantalla principal. Modificando el
constructor de la clase Main.

El objetivo de este cambio es ordenar los botones de una manera similar a como
otras aplicaciones de calculadoras tienen los botones colocados. Además, el
orden de creación es acorde a dónde se encuentran los botones en la pantalla,
siguiendo un orden de izquierda a derecha y de arriba a abajo.

## UT4. Ejecución de herramientas

<!-- Indica aquí cómo has ejecutado las herramientas y cuál ha sido la salida,
ejemplo: -->

### Testing

<!-- Puedes borrar este ejemplo, todo el apartado -->

#### Prerrequisitos

Se debe tener NodeJS instalado y haber descargado e instalado las dependencias,
que se hace mediante el siguiente comando, suponiendo que se encuentra en la
carpeta raíz del repositorio:

```
npm i
```

#### Ejecución

Para ejecutar los tests, usa el siguiente comando:

```
npm run test
```

#### Salida

La ejecución debe dar el siguiente resultado:

```
> test
> jest

FAIL ./sum.test.js
  ✕ adds 1 + 2 to equal 3 (4 ms)

  ● adds 1 + 2 to equal 3

    expect(received).toBe(expected) // Object.is equality

    Expected: 3
    Received: 4

      2 |
      3 | test('adds 1 + 2 to equal 3', () => {
    > 4 |   expect(sum(1, 2)).toBe(3);
        |                     ^
      5 | });
      6 |

      at Object.toBe (sum.test.js:4:21)

Test Suites: 1 failed, 1 total
Tests:       1 failed, 1 total
Snapshots:   0 total
Time:        0.378 s
Ran all test suites.
Error: Process completed with exit code 1.
```
