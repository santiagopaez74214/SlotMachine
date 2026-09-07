# Slot Machine

Proyecto desarrollado para el curso **Desarrollo Orientado por Objetos (DOPO-POOB)** de la **Escuela Colombiana de Ingeniería Julio Garavito**.

El proyecto consiste en el desarrollo de un **simulador de una máquina tragamonedas**, inspirado en el problema **Slot Machine** de la 49.ª edición del ICPC World Championship.

## Descripción

La aplicación permite simular una máquina tragamonedas compuesta por diferentes ruedas y símbolos.

El objetivo principal de este primer ciclo es construir el simulador aplicando conceptos de **programación orientada a objetos**, reutilización de componentes y extensibilidad.

El proyecto **no busca resolver directamente el problema de programación competitiva**, sino construir una aplicación que permita representar y manipular la máquina tragamonedas.

## Funcionalidades

El simulador permite:

* Crear una máquina tragamonedas.
* Adicionar ruedas.
* Eliminar ruedas.
* Adicionar símbolos.
* Eliminar símbolos.
* Girar las ruedas de la máquina.
* Consultar los símbolos disponibles.
* Comprobar si la configuración actual es ganadora.
* Mostrar u ocultar la máquina.
* Terminar el simulador.

Estas funcionalidades corresponden a los requisitos establecidos para el primer ciclo del proyecto.

## Estado ganador

Una configuración es considerada ganadora cuando **todas las ruedas muestran el mismo símbolo al mismo tiempo**.

Esta condición está basada en el problema original *Slot Machine* del ICPC.

Cuando la máquina alcanza un estado ganador, su representación visual debe cambiar para indicarlo.

## Requisitos visuales

El simulador cuenta con una representación gráfica de sus elementos.

Entre los requisitos visuales se encuentran:

* Todos los elementos deben tener una representación visual adecuada.
* Los símbolos deben utilizar colores diferentes.
* La máquina debe presentar una apariencia diferente cuando se encuentra en un estado ganador.
* Los mensajes de acciones que no puedan realizarse se muestran mediante `JOptionPane` cuando el simulador está visible.

## Tecnologías

El proyecto fue desarrollado utilizando:

* **Java**
* **BlueJ**
* **Programación Orientada a Objetos**
* **Astah** para los diagramas UML
* Componentes del paquete `shapes`

El proyecto debe construirse reutilizando los componentes proporcionados por el paquete `shapes`, el cual puede ser extendido cuando sea necesario.

## Estructura del proyecto

La estructura general del proyecto se organiza de acuerdo con las clases necesarias para representar la máquina tragamonedas y sus componentes.

```text
slotMachine/
│
├── src/
│   ├── SlotMachine.java
│   ├── Wheel.java
│   ├── Symbol.java
│   └── ...
│
├── shapes/
│   └── ...
│
└── README.md
```

## Diseño

El proyecto incluye el diseño de las clases y las interacciones entre ellas mediante diagramas UML realizados en **Astah**.

Se contemplan:

* Diagrama de clases.
* Atributos y métodos públicos y privados.
* Diagramas de secuencia de los métodos construidos para la clase principal.

Los diagramas de secuencia se detienen en los componentes pertenecientes a `shapes`, de acuerdo con los requisitos de la entrega.

## Equipo de desarrollo

**Autores:**

* David Santiago Páez Palacio
* Joseph Samuel Achury Cañon

## Mini-ciclos

El desarrollo del proyecto se realizó mediante mini-ciclos con el propósito de organizar progresivamente la implementación de las funcionalidades.

Los mini-ciclos definidos, su estado actual y la justificación de cada uno se encuentran documentados en la retrospectiva del proyecto.

## Retrospectiva 1

**1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.**

Se dividió en los siguientes tres mini-ciclos:

* **Mini-ciclo 1:**
  * **Objetivo:** Construir la representación visual principal de la máquina.
  * **Tareas:**
    * Inicializar y posicionar correctamente la base, el fondo y la palanca de la SlotMachine utilizando la clase Rectangle.
    * Asegurar el correcto funcionamiento de los métodos makeVisible() y makeInvisible() a través de la gestión del Canvas.
    * Aplicar una correcta encapsulación para proteger el estado interno de las figuras geométricas.

* **Mini-ciclo 2:**
  * **Objetivo:** Implementar la lógica para agregar, posicionar y eliminar las partes móviles de la máquina (ruedas y símbolos), garantizando que cumplan las reglas del diseño.
  * **Tareas principales:**
    * Desarrollar la lógica de inserción y borrado seguro en addWheel y delWheel dentro de la clase SlotMachine, ajustando los índices para que no desborden los límites.
    * Completar addSymbol y delSymbol en la clase Wheel, validando que los símbolos dentro de una misma rueda posean colores diferentes.
    * Implementar el método placeSymbol(wheel, symbol) para gestionar la ubicación manual.

* **Mini-ciclo 3:**
  * **Objetivo:** Darle vida al simulador conectando las acciones de la máquina con las consultas de estado y las notificaciones al usuario.
  * **Tareas principales:**
    * Probar y ajustar la rotación de las ruedas con los métodos spin(int wheel) (giro individual) y spin() (giro grupal).
    * Asegurar que los métodos de consulta symbols(), distinctSymbols() y configuration() devuelvan el estado correcto de los arreglos.
    * Implementar la validación isJackpot() para detectar el estado ganador.
    * Añadir lógica visual para que la máquina modifique su apariencia si se llega a un estado ganador.
    * Configurar alertas visuales con JOptionPane ante acciones fallidas, mostrando el mensaje únicamente cuando el simulador esté en modo visible.


**2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?**
Terminado, porque pudimos cumplir con los requisitos.

**3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)**
* Cañon : 8 horas
* Paez : 8 horas

**4. ¿Cuál consideran fue el mayor logro? ¿Por qué?**
Poder terminar el trabajo, porque nuestro conocimiento no es el más avanzado, pero con investigación, lo logramos hacer. 

**5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?**
El diagrama de secuencias, no entendiamos muy bien como se hacían muchas cosas, para resolverlo, preguntamos a compañeros de otras clases y le preguntamos a IAs.

**6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?**
Poder desarrollar el trabajo a la par, asi cada uno entendia que iba pasando. Nos comprometemos a no procrastinar.

**7. Considerando las prácticas XP incluidas en los laboratorios. ¿cuál fue la más útil? ¿por qué?**
Pair programming, por el mismo punto de la pregunta 6.

**8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.**
* Oracle. (2014). *Java Platform, Standard Edition 8 API Specification*. https://docs.oracle.com/javase/8/docs/api/
* Google. (2026). *Gemini* (Versión del 23 de agosto) [Modelo de lenguaje grande]. https://gemini.google.com/
* Escuela Colombiana de Ingeniería Julio Garavito. **Desarrollo Orientado por Objetos — Proyecto Inicial Ciclo No. 1, 2026-2.**
* ICPC Foundation. **49th ICPC World Championship — Problem I: Slot Machine.**


## Retrospectiva 2

**1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.**

Se dividió en los siguientes tres mini-ciclos:

* **Mini-ciclo 1:**
  * **Objetivo:** Implementar la gestión estructural y el control de estado de las ruedas de la máquina.
  * **Tareas:**
    * Desarrollar el método swap(int wheel1, int wheel2) para permitir el intercambio de posición entre dos ruedas validando los límites de la lista..
    * Implementar los métodos lock(int wheel) y unlock(int wheel) para fijar y soltar el estado de operación de una rueda específica.
    * Actualizar la lógica en la clase Wheel incorporando el atributo de bloqueo para impedir giros cuando la rueda esté fija..

* **Mini-ciclo 2:**
  * **Objetivo:** Incorporar los mecanismos avanzados de rotación fraccionada y el cumplimiento de usabilidad visual.
  * **Tareas principales:**
    * Desarrollar el método spin(int wheel, int steps) soportando rotaciones por una cantidad exacta de pasos en dirección positiva o negativa..
    * Integrar la lógica de usabilidad para que, si el simulador se encuentra visible en la pantalla, el movimiento por pasos se ejecute y visualice de forma progresiva.

* **Mini-ciclo 3:**
  * **Objetivo:** Darle vida al simulador conectando las acciones de la máquina con las consultas de estado y las notificaciones al usuario.
  * **Tareas principales:**
    * Programar la sobrecarga spin(String[] setSymbols) para actualizar de manera simultánea el estado y los símbolos visibles de todas las ruedas a partir de un arreglo de colores.
    * Validar la correspondencia exacta entre el tamaño del arreglo de entrada y el número total de ruedas activas antes de aplicar los cambios de estado.


**2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?**
Terminado, porque pudimos cumplir con los requisitos.

**3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)**
* Cañon : 7 horas
* Paez : 7 horas

**4. ¿Cuál consideran fue el mayor logro? ¿Por qué?**
Hacer las pruebas, porque era lo vital en este ciclo. 

**5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?**
Los resultados que arrojaban las pruebas, intentamos.

**6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?**
Poder desarrollar el trabajo a la par, asi cada uno entendia que iba pasando. Nos comprometemos a no procrastinar.

**7. Considerando las prácticas XP incluidas en los laboratorios. ¿cuál fue la más útil? ¿por qué?**
Pair programming, por el mismo punto de la pregunta 6.

**8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.**
* Oracle. (2014). *Java Platform, Standard Edition 8 API Specification*. https://docs.oracle.com/javase/8/docs/api/
* Google. (2026). *Gemini* (Versión del 23 de agosto) [Modelo de lenguaje grande]. https://gemini.google.com/
* Escuela Colombiana de Ingeniería Julio Garavito. **Desarrollo Orientado por Objetos — Proyecto Inicial Ciclo No. 1, 2026-2.**
* ICPC Foundation. **49th ICPC World Championship — Problem I: Slot Machine.**

