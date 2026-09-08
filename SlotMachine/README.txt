Proyecto Slot Machine - Simulador DOPO

LINK repositorio GitHub https://github.com/santiagopaez74214/SlotMachine

Autores: David Páez y Joseph
Fecha: Agosto 2026
Materia: Desarrollo Orientado por Objetos [DOPO-POОВ]

Descripción del Proyecto
Este proyecto consiste en el desarrollo de una aplicación en Java (usando BlueJ) que simula una máquina tragamonedas. La situación está inspirada en el Problem I de la maratón de programación internacional 2025 Slot Machine. El propósito de este primer ciclo es construir el simulador visual y lógico con un fuerte énfasis en la extensibilidad, reutilizando el proyecto shapes.

Se dividió en los siguientes tres mini-ciclos:

Mini-ciclo 1:
Objetivo: Construir la representación visual principal de la máquina
Tareas:
  - Inicializar y posicionar correctamente la base, el fondo y la palanca de la SlotMachine utilizando la clase Rectangle.
  - Asegurar el correcto funcionamiento de los métodos makeVisible() y makeInvisible() a través de la gestión del Canvas.
  - Aplicar una correcta encapsulación para proteger el estado interno de las figuras geométricas.



Mini-ciclo 2:
Objetivo: Implementar la lógica para agregar, posicionar y eliminar las partes móviles de la máquina (ruedas y símbolos), garantizando que cumplan las reglas del diseño.
Tareas principales:
  - Desarrollar la lógica de inserción y borrado seguro en addWheel y delWheel dentro de la clase SlotMachine, ajustando los índices para que no desborden los límites.
  - Completar addSymbol y delSymbol en la clase Wheel, validando que los símbolos dentro de una misma rueda posean colores diferentes.
  - Implementar el método placeSymbol(wheel, symbol) para gestionar la ubicación manual.



Mini-ciclo 3:
Objetivo: Darle vida al simulador conectando las acciones de la máquina con las consultas de estado y las notificaciones al usuario.
Tareas principales:
  - Probar y ajustar la rotación de las ruedas con los métodos spin(int wheel) (giro individual) y spin() (giro grupal).
  - Asegurar que los métodos de consulta symbols(), distinctSymbols() y configuration() devuelvan el estado correcto de los arreglos.
  - Implementar la validación isJackpot() para detectar el estado ganador.
  - Añadir lógica visual para que la máquina modifique su apariencia si se llega a un estado ganador.
  - Configurar alertas visuales con JOptionPane ante acciones fallidas, mostrando el mensaje únicamente cuando el simulador esté en modo visible.

Estructura del Código


El proyecto fue construido extendiendo los componentes del paquete shapes, incluyendo:
* SlotMachine: Controla la lógica global, métodos de estado e interfaz requerida.
* Wheel: Gestiona cada rueda de forma independiente y las rotaciones.
* Symbol: Representa cada icono manejando su propio color y forma base (Triangle).
* Componentes nativos de dibujo: Canvas, Rectangle, Triangle.

1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.
	Ya está explicado arriba
2. ¿Cuál es el estado actual del proyecto en términos de mini-ciclos? ¿por qué?
	Terminado, porque pudimos cumplir con los requisitos
3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)
	Cañon : 8 horas
	Paez : 8 horas
4. ¿Cuál consideran fue el mayor logro? ¿Por qué?
	Poder terminar el trabajo, porque nuestro conocimiento no es el más avanzado, pero con investigación, lo logramos hacer 
5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?
	El diagrama de secuencias, no entendiamos muy bien como se hacían muchas cosas, para resolverlo, preguntamos a compañeros de otras clases y le preguntamos a IAs
6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
	Poder desarrollar el trabajo a la par, asi cada uno entendia que iba pasando. Nos comprometemos a no procrastinar
7. Considerando las prácticas XP incluidas en los laboratorios. ¿cuál fue la más útil? ¿por qué?
	Pair programming, por el mismo punto de la pregunta 6
8. ¿Qué referencias usaron? ¿Cuál fue la más útil? Incluyan citas con estándares adecuados.
	Oracle. (2014). Java Platform, Standard Edition 8 API Specification. https://docs.oracle.com/javase/8/docs/api/
	Google. (2026). Gemini (Versión del 23 de agosto) [Modelo de lenguaje grande]. https://gemini.google.com/