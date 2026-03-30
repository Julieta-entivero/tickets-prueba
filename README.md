# Selenium Test Management

Framework de automatizacion QA para [SauceDemo](https://www.saucedemo.com/) con Selenium WebDriver, Java y Page Object Model. Incluye documentacion completa: planes de prueba, casos de test y reportes de bugs.

## Tecnologias

![Java](https://img.shields.io/badge/Java_11-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium_4.18-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG_7.9-FF7300?style=flat&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![ExtentReports](https://img.shields.io/badge/ExtentReports_5.1-00897B?style=flat&logoColor=white)

## Estructura del proyecto

```
├── src/
│   ├── main/java/com/ticketsprueba/pages/
│   │   ├── BasePage.java                  # Clase base con utilidades Selenium
│   │   ├── LoginPage.java
│   │   ├── InventoryPage.java
│   │   ├── ItemDetailPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutStepOnePage.java
│   │   ├── CheckoutStepTwoPage.java
│   │   └── CheckoutCompletePage.java
│   └── test/java/com/ticketsprueba/
│       ├── base/BaseTest.java
│       └── tests/
│           ├── TC001_LoginTest.java       # 6 tests
│           ├── TC002_InventoryTest.java   # 6 tests
│           ├── TC003_CartTest.java        # 7 tests
│           ├── TC004_CheckoutTest.java    # 7 tests
│           └── TC005_LogoutTest.java      # 2 tests
├── docs/
│   ├── test-plans/                        # Plan de pruebas del sprint
│   ├── test-cases/                        # 4 documentos de casos de test
│   └── bug-reports/                       # 3 bugs documentados
├── pom.xml
├── testng.xml
└── README.md
```

## Cobertura de tests

| Suite | Tickets | Tests | Escenarios |
|-------|---------|-------|------------|
| Login | SHOP-101, SHOP-102 | 6 | Login valido, credenciales invalidas, campos vacios, usuario bloqueado |
| Inventory | SHOP-201, SHOP-202, SHOP-203 | 6 | Carga de productos, ordenamiento, detalle, navegacion |
| Cart | SHOP-301, SHOP-302 | 7 | Agregar/remover items, validar precios, navegacion |
| Checkout | SHOP-401, SHOP-402, SHOP-403 | 7 | Flujo completo, validaciones de formulario, cancelacion, verificacion de totales |
| Logout | SHOP-501 | 2 | Logout y validacion de URL |
| **Total** | **11 tickets** | **28** | |

## Documentacion QA

Este proyecto incluye documentacion profesional en la carpeta `docs/`:

- **Plan de pruebas**: Alcance, usuarios de prueba, riesgos y estrategia del sprint
- **Casos de test**: Documentacion detallada con precondiciones, pasos y resultados esperados
- **Reportes de bugs**: 3 bugs identificados con pasos de reproduccion y severidad

## Requisitos previos

- Java 11+
- Maven 3+
- Google Chrome

## Como ejecutar

```bash
# Ejecutar todos los tests
mvn test

# Modo headless
mvn test -Dheadless=true

# Ejecutar una suite especifica
mvn test -Dtest=TC001_LoginTest

# Ejecutar con TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```
