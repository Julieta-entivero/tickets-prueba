# TC-002: Casos de prueba del Inventario
**Tickets:** SHOP-201, SHOP-202, SHOP-203
**Modulo:** Catalogo de Productos
**QA:** Julieta Entivero
**Ultima actualizacion:** 17/03/2026

---

## TC-002-01: Se muestran todos los productos
- **Prioridad:** Alta
- **Ticket:** SHOP-201
- **Precondicion:** Usuario logueado con standard_user
- **Pasos:**
  1. Verificar la pagina de productos
- **Resultado esperado:** Se muestran 6 productos en el catalogo
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-02: Ordenar por precio de menor a mayor
- **Prioridad:** Media
- **Ticket:** SHOP-202
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Seleccionar "Price (low to high)" en el dropdown de ordenamiento
  2. Verificar el orden de los precios
- **Resultado esperado:** Los productos se muestran de menor a mayor precio
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-03: Ordenar por precio de mayor a menor
- **Prioridad:** Media
- **Ticket:** SHOP-202
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Seleccionar "Price (high to low)" en el dropdown
  2. Verificar el orden de los precios
- **Resultado esperado:** Los productos se muestran de mayor a menor precio
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-04: Ordenar por nombre A-Z
- **Prioridad:** Baja
- **Ticket:** SHOP-202
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Seleccionar "Name (A to Z)" en el dropdown
  2. Verificar el orden alfabetico
- **Resultado esperado:** Los productos se muestran en orden alfabetico A-Z
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-05: Ordenar por nombre Z-A
- **Prioridad:** Baja
- **Ticket:** SHOP-202
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Seleccionar "Name (Z to A)" en el dropdown
  2. Verificar el orden
- **Resultado esperado:** Los productos se muestran en orden Z-A
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-06: Ver detalle de un producto
- **Prioridad:** Media
- **Ticket:** SHOP-203
- **Precondicion:** Usuario logueado
- **Pasos:**
  1. Click en el nombre de "Sauce Labs Backpack"
  2. Verificar que se muestra la pagina de detalle
- **Resultado esperado:** Se muestra nombre, descripcion y precio del producto
- **Estado:** PASS
- **Automatizado:** Si

---

## TC-002-07: Volver al catalogo desde el detalle
- **Prioridad:** Baja
- **Ticket:** SHOP-203
- **Precondicion:** Estar en la pagina de detalle de un producto
- **Pasos:**
  1. Click en el boton "Back to products"
- **Resultado esperado:** Se vuelve al catalogo y se muestra el titulo "Products"
- **Estado:** PASS
- **Automatizado:** Si
