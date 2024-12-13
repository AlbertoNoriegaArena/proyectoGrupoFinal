// Datos de ejemplo para el ranking
let ranking = [
    { "jugador": "Juan", "intentos": 5 },
    { "jugador": "Ana", "intentos": 3 },
    { "jugador": "Carlos", "intentos": 7 },
    { "jugador": "Rodri", "intentos": 1 },
    { "jugador": "Balto", "intentos": 8 }
];

// Función para mostrar el ranking en la tabla
function mostrarRanking(ranking) {
    const rankingTable = document.getElementById("ranking");
    rankingTable.innerHTML = '';  // Limpiar la tabla antes de agregar las nuevas filas

    // Ordenar las solicitudes por intentos (de menor a mayor)
    ranking.sort((a, b) => a.intentos - b.intentos);

    // Agregar el ranking a la tabla
    ranking.forEach((entry, index) => {
        const row = document.createElement('tr');  // Crear una nueva fila
        row.innerHTML = `
            <td>${entry.jugador}</td>
            <td>${entry.intentos}</td>
        `;
        console.log(`Jugador: ${entry.jugador}, Intentos: ${entry.intentos}, Índice: ${index}`);
        
        // Aplicar clases para los tres primeros jugadores con los colores y tamaños de fondo
        if (index === 0) {
            row.classList.add('ranking-primero');  // Fondo dorado para el primero
        } else if (index === 1) {
            row.classList.add('ranking-segundo');  // Fondo plateado para el segundo
        } else if (index === 2) {
            row.classList.add('ranking-tercero');  // Fondo bronce para el tercero
        }

        rankingTable.appendChild(row);  // Añadir la fila a la tabla
    });
}

// Mostrar el ranking al cargar la página
window.onload = function() {
    mostrarRanking(ranking);  // Mostrar el ranking directamente
};

// Evento para el formulario (cuando el jugador adivine el número)
const formulario = document.getElementById("formularioNumero");
formulario.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita que el formulario se envíe y recargue la página

    // Obtener el valor del número ingresado
    const numeroIngresado = parseInt(document.getElementById("numero").value);

    // Definir un número aleatorio entre 1 y 100
    const numeroAleatorio = Math.floor(Math.random() * 100) + 1;

    // Variable para contar los intentos
    let intentos = 0;
    intentos++;

    // Mostrar el número de intentos en la pantalla
    document.querySelector(".numeroDeIntentos").textContent = intentos;

    // Comprobar si el número ingresado es correcto
    if (numeroIngresado === numeroAleatorio) {
        alert(`¡Felicidades! Has adivinado el número ${numeroAleatorio} en ${intentos} intentos.`);

        // Agregar al ranking
        const jugador = prompt("Introduce tu nombre:");
        ranking.push({ jugador: jugador, intentos: intentos });

        // Mostrar el ranking actualizado
        mostrarRanking(ranking);

        // Resetear el contador de intentos
        intentos = 0;
        document.querySelector(".numeroDeIntentos").textContent = intentos;
    } else if (numeroIngresado < numeroAleatorio) {
        alert("El número ingresado es menor. Intenta nuevamente.");
    } else {
        alert("El número ingresado es mayor. Intenta nuevamente.");
    }
});