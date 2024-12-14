// Datos de ejemplo para el ranking
let ranking = [
    { "jugador": "Juan", "intentos": 5 },
    { "jugador": "Ana", "intentos": 3 },
    { "jugador": "Carlos", "intentos": 7 },
    { "jugador": "Rodri", "intentos": 2 },
    { "jugador": "Balto", "intentos": 8 }
];

// Función para mostrar el ranking en la tabla
function mostrarRanking(ranking) {
    const rankingTable = document.getElementById("ranking"); // Obtener el tbody de la tabla
    rankingTable.innerHTML = '';  // Limpiar la tabla antes de agregar nuevas filas

    // Ordenar las solicitudes por intentos (de menor a mayor)
    ranking.sort((a, b) => a.intentos - b.intentos);

    // Tomar solo los primeros 5 jugadores con menos intentos
    const top5Ranking = ranking.slice(0, 5);

    // Agregar las filas al cuerpo de la tabla
    top5Ranking.forEach((entry, index) => {
        const row = document.createElement('tr');  // Crear una nueva fila

        // Crear las celdas para cada jugador e intento
        const tdJugador = document.createElement('td');
        tdJugador.textContent = entry.jugador;

        const tdIntentos = document.createElement('td');
        tdIntentos.textContent = entry.intentos;

        // Asignar clases a las celdas según el ranking
        if (index === 0) {
            tdJugador.innerHTML = '<span class="icono"> <i class="fas fa-trophy" style="font-size: 25px;" ></i> </span>' + entry.jugador;
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
window.onload = function () {
    mostrarRanking(ranking);  // Mostrar el ranking ordenado
};

$(document).ready(function () {
    let numeroAleatorio = Math.floor(Math.random() * 100) + 1;
    let intentos = 0;  // Contador de intentos
    let numerosIntentados = []; // Array para almacenar los números intentados

    // Evento al enviar el formulario
    $("#formularioNumero").submit(function (event) {
        event.preventDefault();  // Evitar el envío del formulario

        // Obtener el número ingresado por el usuario y asegurarnos de que sea un número
        let numeroIngresado = parseInt($("#numero").val());

        // Aumentar el contador de intentos
        intentos++;

        // Mostrar el número de intentos en el span
        $(".numeroDeIntentos").text(intentos);

        // Mostrar los números intentados en el div .intentos
        numerosIntentados.push(numeroIngresado);
        let intentosTexto = "Números intentados: " + numerosIntentados.join(", ");
        $(".intentos p.numerosProbados").text(intentosTexto);

        // Verificar si el número ingresado es correcto
        if (numeroIngresado === numeroAleatorio) {
            // Mostrar el formulario para ingresar el nombre
            $("#FormularioNombreJugador").show();

        } else if (numeroIngresado < numeroAleatorio) {
            alert("El número que buscas es mayor que " + numeroIngresado);
            $("#numero").val(''); // Limpiar el campo de entrada
        } else {
            alert("El número que buscas es menor que " + numeroIngresado);
            $("#numero").val(''); // Limpiar el campo de entrada
        }
    });

    // Al hacer clic en "Guardar en Ranking"
    $("#guardarRanking").click(function () {
        const nombre = $("#nombreJugador").val();
        if (nombre) {
            ranking.push({ "jugador": nombre, "intentos": intentos });
            mostrarRanking(ranking);
            // Limpiar el campo de nombre y ocultar el formulario
            $("#FormularioNombreJugador").hide();
            $("#nombreJugador").val(''); // Limpiar el campo de entrada del nombre

            // Reiniciar el juego (número aleatorio y contador de intentos)
            numeroAleatorio = Math.floor(Math.random() * 100) + 1;
            intentos = 0;
            $(".numeroDeIntentos").text(intentos);
            $("#numero").val(''); // Limpiar el campo de entrada
            $(".intentos p.numerosProbados").text('');
        } else {
            alert("Por favor, ingresa tu nombre.");
        }
    });
});
