function aceptarCookies() {
  // Guardar en localStorage que el usuario aceptó las cookies
  localStorage.setItem('cookies-aceptadas', 'true');
  // Ocultar la ventana de cookies
  var ventanaCookies = document.querySelector('.ventana-cookies');
  ventanaCookies.style.display = 'none';
}

// Mostrar la ventana de cookies sólo si el usuario no las ha aceptado previamente
var cookiesAceptadas = localStorage.getItem('cookies-aceptadas');
if (!cookiesAceptadas) {
  var ventanaCookies = document.querySelector('.ventana-cookies');
  ventanaCookies.style.display = 'flex';
}
