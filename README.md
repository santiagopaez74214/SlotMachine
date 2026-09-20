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

 **Mini-ciclos planificados**

Para organizar el desarrollo del proyecto se establecieron cuatro mini-ciclos:

* **Mini-ciclo 1: Creación e implementación de métodos**

El primer mini-ciclo estuvo orientado a implementar las funcionalidades principales requeridas para el segundo ciclo del proyecto:

* Intercambiar dos ruedas.
* Fijar o bloquear una rueda.
* Soltar o desbloquear una rueda.
* Rotar una rueda un número determinado de pasos.
* Configurar la máquina con una configuración específica.
* Y todas estas funcionalidades integrarlas con los métodos desarrollados durante el Ciclo 1.

Estas funcionalidades fueron implementadas principalmente en la clase SlotMachine, utilizando las operaciones disponibles en la clase Wheel.

* **Mini-ciclo 2: Pruebas de unidad propias**

El segundo mini-ciclo estuvo destinado a la construcción de SlotMachineC2Test.Se diseñaron pruebas desde dos perspectivas:

* **Qué debería hacer:** casos de éxito en los que la operación solicitada debe completarse correctamente.
* **Qué no debería hacer:** casos en los que la operación debe ser rechazada debido a restricciones, posiciones inválidas, ruedas bloqueadas o configuraciones incorrectas.

Las pruebas se diseñaron para ejecutarse en modo invisible, evitando depender de la interfaz gráfica y concentrándose en el comportamiento lógico de la máquina.

* **Mini-ciclo 3: Pruebas de unidad colaborativas**

El tercer mini-ciclo corresponde a las pruebas compartidas SlotMachineCC2Test. En este mini-ciclo se diseñaron y compartieron casos de prueba con otros integrantes del proyecto. El objetivo fue obtener una perspectiva externa sobre el comportamiento de las funcionalidades desarrolladas.

Para la creación colectiva se utilizaron casos relacionados con:

* Intercambio de ruedas bloqueadas y desbloqueadas.
* Rotación de ruedas mediante una cantidad determinada de pasos.
* Detección de un jackpot.
* Validación de configuraciones.

Los casos propios aportados al wiki fueron identificados mediante la convención de nombres establecida para el proyecto, utilizando las iniciales de los autores.

* **Mini-ciclo 4: Pruebas de aceptación y preparación de la demostración**

El cuarto mini-ciclo está orientado a comprobar el funcionamiento del sistema desde una perspectiva integral y preparar la presentación final. Las pruebas de aceptación se enfocan en secuencias completas de interacción, en lugar de verificar únicamente métodos individuales.

**2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?**
Terminado, porque pudimos cumplir con los requisitos y lo estipulado en el documento del ciclo 2 de desarrollo.

**3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)**
* Cañon : 7 horas
* Paez : 7 horas

**4. ¿Cuál consideran fue el mayor logro? ¿Por qué?**
Hacer las pruebas unitarias y de aceptación, porque se centran en poder determinar si lo desarrollado desde el ciclo 1 y lo del ciclo 2, funciona correctamente. 

**5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?**
Los resultados que arrojaban las pruebas, debido a que si teníamos errores podían deberse más a errores en la implementación que teníamos anteriormente, por lo que teníamos que devolvernos y corregir esos errores.

**6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?**
Poder desarrollar el trabajo a la par, así cada uno entendía que iba pasando. Nos comprometemos a seguir trabajando conjuntamente y mejorar cada vez con los plazos de las entregas.

**7. Considerando las prácticas XP incluidas en los laboratorios. ¿cuál fue la más útil? ¿por qué?**
Pair programming, por el mismo punto de la pregunta 6 y mejorar nuestras habilidades de trabajo en equipo.

**8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.**
* Oracle. (2014). *Java Platform, Standard Edition 8 API Specification*. https://docs.oracle.com/javase/8/docs/api/
* Google. (2026). *Gemini* (Versión del 23 de agosto) [Modelo de lenguaje grande]. https://gemini.google.com/
* Escuela Colombiana de Ingeniería Julio Garavito. **Desarrollo Orientado por Objetos — Proyecto Inicial Ciclo No. 1, 2026-2.**
* ICPC Foundation. **49th ICPC World Championship — Problem I: Slot Machine.**
* JUnit. (s. f.). Class Assert (JUnit API 4.12). JUnit.org. https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html (Assert (assertArrayEquals))

## Retrospectiva 3

**1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.**
## Mini-ciclos planificados

Para organizar el desarrollo del proyecto se establecieron cuatro mini-ciclos:

### Mini-ciclo 1: Desarrollo Astah - Pruebas de unidad y pruebas colaborativas

El primer mini-ciclo estuvo orientado a la construcción del desarrollo completo en Astah UML, las pruebas de unidad propias y la incorporación de pruebas compartidas con otros integrantes de la asignatura, para esto se hizo primero un análisis del problema de la maratón.

En cuanto, al desarrollo completo en la herramienta astah se contemplo todo lo necesario para poder desarrollar este ciclo, como métodos, clases nuevas a incorporar, diagramas de secuencia, etc. 

Para las pruebas propias se desarrollaron casos en la clase SlotMachineContestTest, verificando principalmente el comportamiento de la solución del problema de la maratón, la creación de máquinas y los movimientos utilizados por el algoritmo.

Adicionalmente, se prepararon al menos dos casos de prueba compartidos en la clase SlotMachineContestCTest, con el propósito de comprobar el comportamiento de la solución desde una perspectiva diferente y facilitar la validación colaborativa del proyecto.

Estas pruebas se realizaron teniendo en cuenta las restricciones establecidas para el uso de SlotMachine como herramienta de prueba del algoritmo, que luego empezaríamos a codificar, esto todo esto basado en la prática xp de Code the unit test first.

### Mini-ciclo 2: Diseño e implementación de la solución

Estuvo orientado al análisis del problema de la maratón y a la implementación de las funcionalidades principales requeridas para el tercer ciclo del proyecto.

En este mini-ciclo se desarrollaron principalmente las funcionalidades necesarias para:

* Crear una máquina con igual número de ruedas y símbolos.
* Resolver el problema de la maratón mediante el método solve.
* Utilizar la máquina tragamonedas como herramienta de prueba del algoritmo de solución.
* Integrar las funcionalidades desarrolladas en los ciclos anteriores con la nueva solución.

El método solve fue diseñado de manera que la clase SlotMachine se utilizara como herramienta para probar la solución, sin que la propia clase fuera la encargada de resolver el problema. De acuerdo con los requisitos de diseño, durante la ejecución de solve la máquina debe permanecer invisible.

### Mini-ciclo 3: Desarrollo de la simulación

El tercer mini-ciclo estuvo destinado a implementar el método simulate, cuyo propósito es permitir observar gráficamente la solución generada para el problema de la maratón.

En este mini-ciclo se integró el algoritmo desarrollado en el mini-ciclo anterior con la interfaz gráfica de la máquina tragamonedas. Para esto, se estableció que la máquina debe permanecer visible durante la ejecución de simulate, permitiendo observar los movimientos realizados por las ruedas hasta alcanzar la solución.

También se verificó la integración entre la creación de la máquina, los movimientos generados por el algoritmo y la representación gráfica de la simulación.

### Mini-ciclo 4: Pruebas de aceptación y preparación de la presentación

El cuarto mini-ciclo estuvo orientado a verificar el funcionamiento integral del sistema y preparar las pruebas de aceptación para la presentación final.

En este mini-ciclo se diseñaron dos pruebas de aceptación enfocadas en comprobar el funcionamiento de solve y simulate. La primera busca verificar que el algoritmo genere una solución válida para el problema de la maratón, mientras que la segunda busca comprobar el flujo completo de simulación mediante la interfaz gráfica.

Finalmente, se revisó el funcionamiento general del proyecto, la documentación, el diseño realizado en Astah y el cumplimiento de los requisitos establecidos para el ciclo.

**2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?**
Terminado, porque pudimos cumplir con los requisitos y lo estipulado en el documento del ciclo 3 de desarrollo.

**3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)**
* Cañon : 10 horas
* Paez : 10 horas

**4. ¿Cuál consideran fue el mayor logro? ¿Por qué?**
Lo que consideramos como el mayor logro para este ciclo del proyecto, es la creación de un algoritmo que resolviera el problema cumpliendo con los párametros propuestos en la guía del ciclo de desarrrollo.

**5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?**
El hecho de intentar ejecutar el que creíamos que era el algoritmo que solucionaba el problema, sin embargo, en muchos casos simplemente se quedaba infinitamente intentando girar las ruedas o concluía en un estado que no era un jackpot, siendo un poco frustante. Para resolver esto nos dimos cuenta que el método distinct symbols que teníamos no era adecuado, por lo que sin este no podíamos generar correctamente el algoritmo que resolviera el problema, al cambiarlo fue más fácil darnos cuenta de lo que nos faltaba.

**6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?**
Poder desarrollar el trabajo a la par, así cada uno entendía que iba pasando. Nos comprometemos a seguir trabajando conjuntamente y mejorar cada vez con los plazos de las entregas.

**7. Considerando las prácticas XP incluidas en los laboratorios. ¿cuál fue la más útil? ¿por qué?**
Para este ciclo a diferencia de los demás la práctica más relevante fue, Code the unit test first, porque nos era más claro si ibamos bien en nuestro camino de desarrollo de los métodos a implementar, pero también porque no forzamos las pruebas como cuando se escribe el código primero, por lo que podemos decir que se tiene un código más limpio y coherente con los requerimientos.

**8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.**
* Oracle. (2014). *Java Platform, Standard Edition 8 API Specification*. https://docs.oracle.com/javase/8/docs/api/
* Anthropic. (2026). Claude. https://www.anthropic.com/claude
* Escuela Colombiana de Ingeniería Julio Garavito. **Desarrollo Orientado por Objetos — Proyecto Inicial Ciclo No. 1, 2026-2.**
* ICPC Foundation. **49th ICPC World Championship — Problem I: Slot Machine.**

Además pedimos ayuda a Claude para poder hacer un cambio en la clase de Canvas debido a la limitación en colores de la misma clase, y por la sugerencia de usar la líberia de java.awt.Color para esta labor, a continuación el prompt elegido para esto:

**Prompt clase canvas:**
Necesitamos modificar la clase Canvas de nuestro proyecto en Java para ampliar la cantidad de colores disponibles.
Actualmente la clase Canvas utiliza java.awt.Color, pero el método setForegroundColor(String colorString) solamente reconoce siete colores mediante una cadena de if/else: red, black, blue, yellow, green, magenta y white.
Nuestro proyecto necesita trabajar con 50 colores diferentes, por lo que queremos ampliar esta funcionalidad utilizando la clase java.awt.Color de la biblioteca estándar de Java. Manteniendo la estructura general de la clase Canvas, el uso de String para identificar los colores, permitir 50 colores diferentes.
* Código actual
Añadimos el código de canvas que teníamos originalmente.
