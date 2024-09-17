# Sprint 1 - Módulo de Pagos A

Este repositorio contiene el código del **backend** del módulo de pagos A, desarrollado con **Spring Boot** y **GraphQL**.

---

## 📋 Descripción del Proyecto

El proyecto tiene como objetivo manejar transacciones y pagos en un sistema de reservas de vuelos. A lo largo del **Sprint 1**, se han implementado las siguientes características clave:

- Creación de pagos y transacciones
- Actualización de estado de las transacciones
- Consulta de detalles de pagos
- Simulación de pagos y cargos adicionales

Este backend se conecta con una base de datos **PostgreSQL** y está diseñado para ser consumido por un frontend React.

---

## 🚀 Tecnologías Utilizadas

- **Spring Boot** - Framework backend
- **GraphQL** - Consulta y manipulación de datos
- **PostgreSQL** - Base de datos relacional
- **Maven** - Gestión de dependencias
  
---

## 🛠️ Instrucciones para Correr el Proyecto

### 1. Clonar el Repositorio

Primero, clona este repositorio en tu máquina local:

git clone https://github.com/KevEstr/Sprint1-Arqui

### 2. Configurar la Base de Datos

Asegúrate de tener PostgreSQL instalado y configurado. Puedes ajustar las credenciales de conexión en el archivo application.properties en el directorio src/main/resources/.

### 3. Compilar y Correr el Proyecto

mvn spring-boot:run

### 4. Acceder a la Aplicación

El backend estará corriendo en http://localhost:8080.

Puedes acceder al Playground de GraphQL en la siguiente URL: http://localhost:8081/graphiql

### 5. 📂 Estructura del Proyecto

```bash

src/
├── main/
│   ├── java/
│   │   └── com/udea/modulo_pagos/
│   │       ├── controller/        # Controladores REST
│   │       ├── entities/          # Entidades JPA
│   │       ├── graphql/           # Resolutores GraphQL
│   │       ├── repositories/      # Repositorios de datos
│   │       ├── service/           # Lógica de negocio
│   │       ├── utils/             # Utilidades
│   │       └── ModuloPagosApplication.java # Clase principal
│   ├── resources/
│   │   ├── graphql/
│   │   │   └── schema.graphqls     # Definición del esquema GraphQL
│   │   └── application.properties  # Configuración de la base de datos

