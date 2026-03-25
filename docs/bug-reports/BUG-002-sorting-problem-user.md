# BUG-002: Ordenamiento no funciona con problem user
**Ticket relacionado:** SHOP-202
**Severidad:** Media
**Prioridad:** Media
**Estado:** Abierto
**Reportado por:** Julieta Entivero
**Fecha:** 19/03/2026
**Ambiente:** Chrome 122 / Windows 11

## Descripcion
Con el usuario 'problem_user', al cambiar el criterio de ordenamiento en el dropdown, los productos no se reordenan. Siempre quedan en el mismo orden sin importar la opcion seleccionada.

## Pasos para reproducir
1. Login con problem_user / secret_sauce
2. Seleccionar "Price (low to high)" en el dropdown
3. Observar que los precios NO estan ordenados de menor a mayor

## Resultado esperado
Los productos se reordenan segun el criterio seleccionado.

## Resultado actual
Los productos permanecen en el orden original independientemente del filtro seleccionado.

## Impacto
El usuario no puede encontrar productos por precio, lo cual afecta la experiencia de compra.
