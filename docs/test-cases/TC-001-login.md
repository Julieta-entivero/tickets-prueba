# TC-001: Casos de prueba de Login
**Ticket:** SHOP-101, SHOP-102
**Modulo:** Autenticacion
**QA:** Julieta Entivero
**Ultima actualizacion:** 15/03/2026

---

## TC-001-01: Login exitoso con credenciales validas
- **Prioridad:** Alta
- **Tipo:** Funcional - Positivo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Ingresar "standard_user" en el campo usuario
  2. Ingresar "secret_sauce" en el campo password
  3. Click en "Login"
- **Resultado esperado:** Se redirige a la pagina de productos. Se muestra el titulo "Products"
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginConUsuarioValido()

---

## TC-001-02: Login con usuario incorrecto
- **Prioridad:** Alta
- **Tipo:** Funcional - Negativo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Ingresar "usuario_falso" en el campo usuario
  2. Ingresar "secret_sauce" en el campo password
  3. Click en "Login"
- **Resultado esperado:** Se muestra mensaje de error que contiene "do not match"
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginConUsuarioIncorrecto()

---

## TC-001-03: Login con password incorrecta
- **Prioridad:** Alta
- **Tipo:** Funcional - Negativo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Ingresar "standard_user" en el campo usuario
  2. Ingresar "password_mal" en el campo password
  3. Click en "Login"
- **Resultado esperado:** Se muestra mensaje de error
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginConPasswordIncorrecta()

---

## TC-001-04: Login sin usuario
- **Prioridad:** Media
- **Tipo:** Funcional - Negativo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Dejar el campo usuario vacio
  2. Ingresar "secret_sauce" en el campo password
  3. Click en "Login"
- **Resultado esperado:** Mensaje de error "Username is required"
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginSinUsuario()

---

## TC-001-05: Login sin password
- **Prioridad:** Media
- **Tipo:** Funcional - Negativo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Ingresar "standard_user" en el campo usuario
  2. Dejar el campo password vacio
  3. Click en "Login"
- **Resultado esperado:** Mensaje de error "Password is required"
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginSinPassword()

---

## TC-001-06: Login con usuario bloqueado (SHOP-102)
- **Prioridad:** Alta
- **Tipo:** Funcional - Negativo
- **Precondicion:** Estar en la pagina de login
- **Pasos:**
  1. Ingresar "locked_out_user" en el campo usuario
  2. Ingresar "secret_sauce" en el campo password
  3. Click en "Login"
- **Resultado esperado:** Mensaje de error que contiene "locked out"
- **Estado:** PASS
- **Automatizado:** Si - TC001_loginUsuarioBloqueado()
