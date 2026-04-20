![Selenium Tests](https://github.com/Julieta-entivero/selenium-test-management/actions/workflows/tests.yml/badge.svg)

# Selenium Test Management

Framework de automatizacion QA para [SauceDemo](https://www.saucedemo.com/) con Selenium WebDriver, Java y Page Object Model. Incluye documentacion completa: planes de prueba, casos de test y reportes de bugs.

## Tecnologias

![Java](https://img.shields.io/badge/Java_11-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium_4.18-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG_7.9-FF7300?style=flat&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)

## Estructura del proyecto

```
├── src/
│   ├── main/java/com/ticketsprueba/
│   │   ├── pages/
│   │   │   ├── BasePage.java                  # Clase base con explicit waits
│   │   │   ├── LoginPage.java
│   │   │   ├── InventoryPage.java
│   │   │   ├── ItemDetailPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── CheckoutStepOnePage.java
│   │   │   ├── CheckoutStepTwoPage.java
│   │   │   └── CheckoutCompletePage.java
│   │   └── utils/
│   │       └── ConfigReader.java              # Lectura centralizada de configuracion
│   └── test/java/com/ticketsprueba/
│       ├── base/BaseTest.java                 # Setup con ThreadLocal para ejecucion paralela
│       ├── listeners/
│       │   └── ScreenshotListener.java        # Captura screenshots en tests fallidos
│       └── tests/
│           ├── TC001_LoginTest.java           # 6 tests
│           ├── TC002_InventoryTest.java       # 8 tests
│           ├── TC003_CartTest.java            # 7 tests
│           ├── TC004_CheckoutTest.java        # 7 tests
│           └── TC005_LogoutTest.java          # 2 tests
├── docs/
│   ├── test-plans/                            # Plan de pruebas del sprint
│   ├── test-cases/                            # 4 documentos de casos de test
│   └── bug-reports/                           # 3 bugs documentados
├── pom.xml
├── testng.xml
└── README.md
```

## Cobertura de tests

| Suite | Tickets | Tests | Escenarios |
|-------|---------|-------|------------|
| Login | SHOP-101, SHOP-102 | 6 | Login valido, credenciales invalidas, campos vacios, usuario bloqueado |
| Inventory | SHOP-201, SHOP-202, SHOP-203 | 8 | Carga de productos, ordenamiento, detalle, navegacion |
| Cart | SHOP-301, SHOP-302 | 7 | Agregar/remover items, validar precios, navegacion |
| Checkout | SHOP-401, SHOP-402, SHOP-403 | 7 | Flujo completo, validaciones de formulario, cancelacion |
| Logout | SHOP-501 | 2 | Logout y validacion de URL |
| **Total** | **11 tickets** | **30** | |

## Documentacion QA

Este proyecto incluye documentacion profesional en la carpeta `docs/`:

- **Plan de pruebas**: Alcance, usuarios de prueba, riesgos y estrategia del sprint
- **Casos de test**: Documentacion detallada con precondiciones, pasos y resultados esperados
- **Reportes de bugs**: 3 bugs identificados con pasos de reproduccion y severidad

## Configuracion

Las credenciales, URL y timeouts se configuran en `src/test/resources/config.properties`:

```properties
base.url=https://www.saucedemo.com/
explicit.wait.seconds=10
standard.user=standard_user
standard.password=secret_sauce
```

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
```

## Arquitectura

- **BasePage**: Clase base con explicit waits y metodos reutilizables
- **ConfigReader**: Lectura centralizada de configuracion desde `config.properties`
- **ScreenshotListener**: TestNG listener que captura screenshots automaticamente en fallas
- **ThreadLocal WebDriver**: Soporte seguro para ejecucion paralela de tests
- **CI/CD**: GitHub Actions ejecuta los tests en headless y sube screenshots/reportes como artefactos
