# Test Plan - Sprint 1
**Proyecto:** SauceDemo E-Commerce
**Version:** 1.0
**QA:** Julieta Entivero

## Objetivo
Validar las funcionalidades principales del sitio: login, catalogo de productos, carrito de compras y flujo de checkout.

## Alcance

### En scope
- Login y logout
- Visualizacion del catalogo
- Ordenamiento de productos
- Agregar y remover productos del carrito
- Flujo completo de checkout
- Validaciones de campos obligatorios

### Fuera de scope
- Performance testing
- Testing de APIs
- Compatibilidad cross-browser (solo Chrome en esta fase)

## Ambiente de prueba
- URL: https://www.saucedemo.com/
- Browser: Chrome (ultima version estable)
- SO: Windows 11

## Usuarios de prueba

| Usuario | Password | Comportamiento esperado |

| standard_user | secret_sauce | Login exitoso |
| locked_out_user | secret_sauce | Error: usuario bloqueado |
| problem_user | secret_sauce | Login con bugs visuales |

## Matriz de tickets y test cases

| Ticket | Modulo | Test Case | Prioridad |

| SHOP-101 | Login | TC-001: Login valido e invalido | Alta |
| SHOP-102 | Login | TC-001: Usuario bloqueado | Alta |
| SHOP-201 | Catalogo | TC-002: Carga de productos | Alta |
| SHOP-202 | Catalogo | TC-002: Ordenamiento | Media |
| SHOP-203 | Catalogo | TC-002: Detalle de producto | Media |
| SHOP-301 | Carrito | TC-003: Agregar/remover items | Alta |
| SHOP-302 | Carrito | TC-003: Pagina del carrito | Alta |
| SHOP-401 | Checkout | TC-004: Flujo completo | Alta |
| SHOP-402 | Checkout | TC-004: Validaciones | Alta |
| SHOP-403 | Checkout | TC-004: Cancelar/volver | Media |
| SHOP-501 | Logout | TC-005: Cierre de sesion | Media |

## Criterios de aceptacion
- Todos los test cases de prioridad Alta deben pasar
- No debe haber bugs bloqueantes abiertos
- Cobertura minima del 80% de los requisitos funcionales

## Riesgos
- El sitio SauceDemo puede tener downtime ya que es un sitio de practica
- El usuario problem_user tiene bugs intencionales que pueden afectar algunos tests
