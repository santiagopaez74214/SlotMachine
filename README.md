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

## Retrospectiva

## Referencias

* Escuela Colombiana de Ingeniería Julio Garavito. **Desarrollo Orientado por Objetos — Proyecto Inicial Ciclo No. 1, 2026-2.**
* ICPC Foundation. **49th ICPC World Championship — Problem I: Slot Machine.**


