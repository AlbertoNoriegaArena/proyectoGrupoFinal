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
    const rankingTable = document.getElementById("ranking"); // Obtener el tbody de la tabla
    rankingTable.innerHTML = '';  // Limpiar la tabla antes de agregar nuevas filas

    // Ordenar las solicitudes por intentos (de menor a mayor)
    ranking.sort((a, b) => a.intentos - b.intentos);

    // Agregar las filas al cuerpo de la tabla
    ranking.forEach((entry, index) => {
        const row = document.createElement('tr');  // Crear una nueva fila
        
        // Crear las celdas para cada jugador e intento
        const tdJugador = document.createElement('td');
        tdJugador.textContent = entry.jugador;
        
        const tdIntentos = document.createElement('td');
        tdIntentos.textContent = entry.intentos;

        // Asignar clases a las celdas según el ranking
        if (index === 0) {
            tdJugador.innerHTML = '<span class"icono"> <i class="fas fa-trophy" style="font-size: 25px;" ></i> </span>' + entry.jugador;
            tdJugador.classList.add('fila-primero');  // Dorado para el primero
            tdIntentos.classList.add('fila-primero');
        } else if (index === 1) {
            tdJugador.classList.add('fila-segundo');  // Plateado para el segundo
            tdIntentos.classList.add('fila-segundo');
        } else if (index === 2) {
            tdJugador.classList.add('fila-tercero');  // Bronce para el tercero
            tdIntentos.classList.add('fila-tercero');
        }

        // Añadir las celdas a la fila
        row.appendChild(tdJugador);
        row.appendChild(tdIntentos);

        // Añadir la fila al tbody
        rankingTable.appendChild(row);
    });
}

// Mostrar el ranking al cargar la página
window.onload = function() {
    mostrarRanking(ranking);  // Mostrar el ranking ordenado
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