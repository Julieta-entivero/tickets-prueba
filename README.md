# Tickets Prueba - QA Automation

Proyecto de validacion de tickets automatizados sobre [SauceDemo](https://www.saucedemo.com/).
Framework con Selenium + TestNG + POM (Page Object Model).

## Estructura

```
src/
├── main/java/com/ticketsprueba/pages/   --> Page Objects
│   ├── BasePage.java
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── ItemDetailPage.java
│   ├── CartPage.java
│   ├── CheckoutStepOnePage.java
│   ├── CheckoutStepTwoPage.java
│   └── CheckoutCompletePage.java
└── test/java/com/ticketsprueba/
    ├── base/BaseTest.java
    └── tests/
        ├── TC001_LoginTest.java          --> SHOP-101, SHOP-102
        ├── TC002_InventoryTest.java       --> SHOP-201, SHOP-202, SHOP-203
        ├── TC003_CartTest.java            --> SHOP-301, SHOP-302
        ├── TC004_CheckoutTest.java        --> SHOP-401, SHOP-402, SHOP-403
        └── TC005_LogoutTest.java          --> SHOP-501
docs/
├── test-plans/        --> Plan de testing del sprint
├── test-cases/        --> Casos de prueba documentados
└── bug-reports/       --> Bugs encontrados
```

## Tickets validados

| Ticket | Modulo | Tests | Estado |

| SHOP-101 | Login | 5 | Validado |

| SHOP-102 | Login bloqueado | 1 | Validado |

| SHOP-201 | Catalogo | 2 | Validado |

| SHOP-202 | Ordenamiento | 4 | Validado |

| SHOP-203 | Detalle producto | 2 | Validado |

| SHOP-301 | Carrito - agregar | 3 | Validado |

| SHOP-302 | Carrito - pagina | 4 | Validado |

| SHOP-401 | Checkout E2E | 2 | Validado |

| SHOP-402 | Checkout validaciones | 3 | Validado |

| SHOP-403 | Checkout cancelar | 2 | Validado |

| SHOP-501 | Logout | 2 | Validado |


Total: 11 tickets - 30 test cases automatizados

## Como correr

```bash
mvn test                        # todos los tests
mvn test -Dheadless=true       # sin abrir navegador
mvn test -Dtest=TC001_LoginTest # solo login
```

## Bugs encontrados
- BUG-001: Imagenes incorrectas con problem_user
- BUG-002: Ordenamiento no funciona con problem_user
- BUG-003: Boton Add to cart agrega producto incorrecto
