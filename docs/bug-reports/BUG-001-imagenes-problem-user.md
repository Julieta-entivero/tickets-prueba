# BUG-001: Imagenes incorrectas con problem user
**Ticket relacionado:** SHOP-201
**Severidad:** Alta
**Prioridad:** Media
**Estado:** Abierto
**Reportado por:** Julieta Entivero
**Fecha:** 18/03/2026
**Ambiente:** Chrome 122 / Windows 11


## Descripcion
Al loguearse con el usuario 'problem_user', todas las imagenes de los productos muestran la misma imagen (la del primer producto). No se corresponden con el producto real.

## Pasos para reproducir
1. Ir a https://www.saucedemo.com/
2. Login con problem_user / secret_sauce
3. Observar las imagenes de los 6 productos

## Resultado esperado
Cada producto deberia mostrar su propia imagen.

## Resultado actual
Todos los productos muestran la imagen del "Sauce Labs Backpack". Las imagenes del resto de los productos no cargan correctamente.

## Notas
- Solo pasa con problem_user. Con standard_user las imagenes se muestran bien
- Parece ser un bug intencional del sitio de practica pero es un buen ejemplo de reporte
