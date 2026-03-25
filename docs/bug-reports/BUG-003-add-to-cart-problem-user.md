# BUG-003: Boton Add to cart agrega producto incorrecto
**Ticket relacionado:** SHOP-301
**Severidad:** Alta
**Prioridad:** Alta
**Estado:** Abierto
**Reportado por:** Julieta Entivero


## Descripcion
Con 'problem_user', al hacer click en "Add to cart" de un producto, el carrito agrega un producto diferente al que se selecciono.

## Pasos para reproducir
1. Login con problem_user / secret_sauce
2. Click en "Add to cart" de "Sauce Labs Onesie"
3. Ir al carrito
4. Verificar que item se agrego

## Resultado esperado
El carrito deberia contener "Sauce Labs Onesie".

## Resultado actual
El carrito contiene un producto diferente al seleccionado.

## Impacto
Critico para la funcionalidad de compra. El usuario no puede comprar el producto que quiere.

## Workaround
Usar standard_user para compras normales. El bug solo se reproduce con problem_user.
