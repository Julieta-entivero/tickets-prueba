# TC-003: Casos de prueba del Carrito
**Tickets:** SHOP-301, SHOP-302
**Modulo:** Carrito de Compras
**QA:** Julieta Entivero
**Ultima actualizacion:** 19/03/2026

---

## TC-003-01: Agregar un producto al carrito
- **Prioridad:** Alta
- **Ticket:** SHOP-301
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Click en "Add to cart" de Sauce Labs Backpack
  2. Verificar el badge del carrito
- **Resultado esperado:** El badge del carrito muestra "1"
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-02: Agregar multiples productos
- **Prioridad:** Alta
- **Ticket:** SHOP-301
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Agregar 3 productos diferentes al carrito
  2. Verificar el badge
- **Resultado esperado:** El badge muestra "3"
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-03: Remover producto desde el catalogo
- **Prioridad:** Alta
- **Ticket:** SHOP-301
- **Precondicion:** Usuario logueado con 1 producto en carrito
- **Pasos:**
  1. Click en "Remove" del producto
  2. Verificar badge
- **Resultado esperado:** El badge desaparece o muestra "0"
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-04: Verificar producto en la pagina del carrito
- **Prioridad:** Alta
- **Ticket:** SHOP-302
- **Precondicion:** Usuario logueado con 1 producto agregado
- **Pasos:**
  1. Click en el icono del carrito
  2. Verificar que el producto aparece
- **Resultado esperado:** Se muestra el nombre del producto agregado
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-05: Remover producto desde la pagina del carrito
- **Prioridad:** Media
- **Ticket:** SHOP-302
- **Precondicion:** Estar en el carrito con 2 productos
- **Pasos:**
  1. Click en "Remove" del primer producto
  2. Verificar que queda 1 producto
- **Resultado esperado:** Solo queda 1 item en el carrito
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-06: Carrito vacio
- **Prioridad:** Media
- **Ticket:** SHOP-302
- **Precondicion:** Usuario logueado sin productos en carrito
- **Pasos:**
  1. Ir al carrito directamente
- **Resultado esperado:** No se muestran items
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-003-07: Volver al catalogo desde el carrito
- **Prioridad:** Baja
- **Ticket:** SHOP-302
- **Precondicion:** Estar en el carrito
- **Pasos:**
  1. Click en "Continue Shopping"
- **Resultado esperado:** Se vuelve al catalogo
- **Estado:** PASS
- **Automatizado:** Si
