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
                    <li><a href="alquilar.view.php">Alquilar</a></li>
                    <li><a href="carrito.view.php">Carrito</a></li>
                    <li><a href="perfil.view.php">Perfil</a></li>
                    <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                </ul>
            </div>
            <div class="menu-responsive">
                <a href="" class="btnoverlay" onclick="display()"><i class="fa-solid fa-bars"></i></a>
            </div>
            <div id="overlay">
                <div class="overlaymenu">
                    <ul>
                        <li><a href="alquilar.view.php">Alquilar</a></li>
                        <li><a href="carrito.view.php">Carrito</a></li>
                        <li><a href="perfil.view.php">Perfil</a></li>
                        <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <!-- Main
    ################################################# -->
    <main>
        <div class="msg">
            <div class="dreta">
                <h1>Et donem la benviguda <span><?php echo $_SESSION['nom'] ?></span>!!</h1>
                <p>Dona un cop d'ull als nostres cursos i kits destacats entre els nostres clients</p> 
            </div>
            <div class="esquerra">
                <img src="" alt="">
            </div>
        </div>
        <div class="linia"></div>

        <section>
            <div class="des">
                <div class="des-main">
                    <div class="titol">
                        <h1>Kits Populars</h1>
                    </div>
                    <div class="cursos-kits">
                    <?php $result= obtenirKitsPOP();
                    while($row = $result->fetch_assoc()){
                    ?>
                        <div class="cursos">
                            <div class="carta-prod">
                                <img src="../img/img-mig.jpg" alt="Imatge Producte">
                                <h1>Kit <?php echo $row['ID'] ?></h1>
                                <p class="preu"><?php echo $row['preu'] ?>.-€</p>
                                <button type="button" class="btnmostrar">Més Informació</button>
                                <div class="content">
                                    <p>El Kit esta fromat per:</p>
                                    <ul>
                                        <li class="material">Botes</li>
                                            <ul class="caract-prod">
                                                <li>Marca: <?php echo $row['marca'] ?></li>
                                                <li>Model: <?php echo $row['model'] ?></li>
                                                <li>Alçada: <?php echo $row['talla'] ?></li>
                                            </ul>
                                        <li class="material">Esquis</li>
                                            <ul class="caract-prod">
                                                <li>Marca: <?php echo $row['marca'] ?></li>
                                                <li>Model: <?php echo $row['model'] ?></li>
                                                <li>Alçada: <?php echo $row['llargada'] ?></li>
                                            </ul>
                                        <li class="material">Pals</li>
                                            <ul class="caract-prod">
                                                <li>Marca: <?php echo $row['marca'] ?></li>
                                                <li>Model: <?php echo $row['model'] ?></li>
                                                <li>Alçada: <?php echo $row['alçada'] ?></li>
                                            </ul>
                                    </ul>
                                </div>
                                <p><button>Alquilar</button></p>
                            </div>
                        </div>
                    <?php } ?>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <footer>
    </footer>
    <script src="../js/desplegarinfo.js"></script>
</body>

</html>
