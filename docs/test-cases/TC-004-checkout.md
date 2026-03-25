# TC-004: Casos de prueba del Checkout
**Tickets:** SHOP-401, SHOP-402, SHOP-403
**Modulo:** Proceso de Compra
**QA:** Julieta Entivero

## TC-004-01: Checkout completo con un producto
- **Prioridad:** Alta
- **Ticket:** SHOP-401
- **Precondicion:** Usuario logueado con 1 producto en carrito
- **Pasos:**
  1. Ir al carrito, click en Checkout
  2. Completar nombre, apellido y codigo postal
  3. Click en Continue
  4. Verificar que se muestra el total con $
  5. Click en Finish
- **Resultado esperado:** Se muestra "Thank you for your order!"
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-02: Checkout completo con multiples productos
- **Prioridad:** Alta
- **Ticket:** SHOP-401
- **Precondicion:** Usuario logueado con 2+ productos en carrito
- **Pasos:**
  1. Agregar 2 productos, ir al carrito
  2. Completar checkout
  3. Finish
- **Resultado esperado:** Compra exitosa
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-03: Checkout sin nombre
- **Prioridad:** Alta
- **Ticket:** SHOP-402
- **Precondicion:** Estar en step one del checkout
- **Pasos:**
  1. Dejar nombre vacio, completar apellido y zip
  2. Click en Continue
- **Resultado esperado:** Error "First Name is required"
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-04: Checkout sin apellido
- **Prioridad:** Alta
- **Ticket:** SHOP-402
- **Pasos:**
  1. Completar nombre, dejar apellido vacio, completar zip
  2. Click en Continue
- **Resultado esperado:** Error "Last Name is required"
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-05: Checkout sin codigo postal
- **Prioridad:** Alta
- **Ticket:** SHOP-402
- **Pasos:**
  1. Completar nombre y apellido, dejar zip vacio
  2. Click en Continue
- **Resultado esperado:** Error "Postal Code is required"
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-06: Cancelar checkout
- **Prioridad:** Media
- **Ticket:** SHOP-403
- **Precondicion:** Estar en step one del checkout
- **Pasos:**
  1. Click en Cancel
- **Resultado esperado:** Vuelve al carrito con los productos intactos
- **Estado:** PASS
- **Automatizado:** Si


## TC-004-07: Volver al home despues de comprar
- **Prioridad:** Baja
- **Ticket:** SHOP-403
- **Precondicion:** Compra completada
- **Pasos:**
  1. Click en "Back Home"
- **Resultado esperado:** Vuelve al catalogo de productos
- **Estado:** PASS
- **Automatizado:** Si
