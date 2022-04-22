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

    <link rel="stylesheet" href="../css/home.css">

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
                    <li><a href="#">Temps</a></li>
                    <li><a href="#">Alquilar</a></li>
                    <li><a href="#">Cursos</a></li>
                    <li><a href="#">Perfil</a></li>
                    <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main
    ################################################# -->
    <main>
        <div class="linia"></div>
        <section>
            <div class="top">
                <div class="temps">
                    <div class="titol">
                        <h1>Temps </h1>
                    </div>
                    <p>A</p>
                    <p>A</p>
                </div>
                <div class="material">
                    <div class="titol">
                        <h1>Cursos Populars</h1>
                    </div>
                    <div class="productes">
                        <div class="carta-prod">
                            <img src="../img/img-mig.jpg" alt="Imatge Producte">
                            <h1>Prova 1</h1>
                            <p class="preu">$19.99</p>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>
                            <p><button>Alquilar</button></p>
                        </div>
                        <div class="carta-prod">
                            <img src="../img/img-mig.jpg" alt="Imatge Producte">
                            <h1>Prova 1</h1>
                            <p class="preu">$19.99</p>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>
                            <p><button>Alquilar</button></p>
                        </div>
                        <div class="carta-prod">
                            <img src="../img/img-mig.jpg" alt="Imatge Producte">
                            <h1>Prova 1</h1>
                            <p class="preu">$19.99</p>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>
                            <p><button>Alquilar</button></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <footer>
    </footer>
</body>

</html>