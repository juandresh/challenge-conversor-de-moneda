# 💱 Conversor de Monedas en Java

Este es un proyecto de consola en Java que permite realizar conversiones entre diferentes monedas utilizando la API pública [ExchangeRate-API](https://www.exchangerate-api.com/).

El programa permite al usuario seleccionar dos monedas entre Dólar, Peso Argentino, Real Brasileño y Peso Colombiano, ingresar un monto y obtener el valor convertido utilizando tasas de cambio actualizadas.

---

## 🛠️ Requisitos

- Java 11 o superior
- [Gson](https://github.com/google/gson) (para deserializar JSON)
- Conexión a Internet (para realizar la consulta a la API)

---

## ⚙️ Configuración del proyecto

### 1. Clona este repositorio

```bash
git clone https://github.com/juandresh/challenge-conversor-de-moneda.git
cd challenge-conversor-de-moneda
```

---

### 2. Obtén tu token de la API

1. Regístrate gratis en [https://www.exchangerate-api.com](https://www.exchangerate-api.com)
2. Obtendrás un token como este: `67hveu158324jkfbu345h34t3i`


---

### 3. Modifica el código para leer el token desde el archivo 
## MUY IMPORTANTE PARA QUE EL PROGRAMA FUNCIONE

En el método `consultar(String moneda)` del archivo `Main.java`, ingresa tu token entre las comillas en la siguiente linea de código:

```java
String token = "";
```

### 4. Ejecuta el programa

Desde tu IDE (como IntelliJ, Eclipse o VS Code), compila y ejecuta el archivo `Main.java`.

También puedes hacerlo por consola:

```bash
javac -cp gson-2.8.9.jar -d out src/Main.java
java -cp out:gson-2.8.9.jar Main
```

> Reemplaza `gson-2.8.9.jar` con la versión correspondiente si es distinta.

---


## 📦 Estructura del proyecto

```
.
├── src/
│   ├── Main.java
│   ├── monedas/
│   │   ├── Moneda.java
│   │   ├── MonedaEX.java
│   │   └── RespuestaAPI.java
├── gson-2.8.9.jar
├── .gitignore
└── README.md
```

---

## 🧠 Créditos

- API de tasas de cambio: [ExchangeRate-API](https://www.exchangerate-api.com/)
- Librería JSON: [Gson - Google](https://github.com/google/gson)

