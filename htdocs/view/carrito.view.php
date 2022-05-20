<?php

include '../php/funcions.php';
session_start();

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Projecte3</title>

    <!-- Font Lletra -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="../css/carrito.css">

</head>

<body>

    <!-- Nav
    ################################################# -->
    <nav>
        <div class="menu-main">
            <div class="logo">
                <a href="../index.html"><img src="../img/logo.png" alt="Logo"></a>
                <p><span>Ski</span>link</p>
            </div>

            <div class="opcions-main">
                <ul>
                    <li><a href="temps.view.php">Temps</a></li>
                    <li><a href="alquilar.view.php">Alquilar</a></li>
                    <li><a href="perfil.view.php">Perfil</a></li>
                    <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                </ul>
            </div>
            <div class="menu-responsive">
                <a href=""><i class="fa-solid fa-bars"></i></a>
            </div>
        </div>
    </nav>

    <!-- Main
    ################################################# -->
    <main>
        <div class="linia"></div>
        <div id="taula_carrito">
            <table>
                <tr id="capçeleraprod">
                    <th>Producte</th>
                    <th>Quantitat</th>
                    <th>Preu/Unitat</th>
                    <th>Preu Total</th>
                </tr>
                <tr>
                    <div id="carrito">

                    </div>
                </tr>
            </table>
        </div>
        <input type="button" value="Eliminar" onclick="esborrarCarrito()">
    </main>
    
    <script src="../js/cargardades.js"></script>
    
<body>
</html>