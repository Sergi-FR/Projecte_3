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

    <link rel="stylesheet" href="../css/alquiler.css">

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
        </div>
    </nav>
    <main>
    <div class="linia"></div>
        <div class="filtre">

            <div class="filtre_mat">
                <form action="" method="get">
                    <div class="filtrar">
                        <a href="alquilar_botes.view.php">Botes</a>
                        <a href="alquilar_pals.view.php">Pals</a>
                        <a href="alquilar_esquis.view.php">Esquis</a>
                    </div>
                </form>
            </div>

            <table class="taula">
                <tr id="titol">
                    <th>Material</th>
                </tr>
                <tr>
                    <td id="info">
                        <?php $result= obtenirProductes();
                        while($row = $result->fetch_assoc()){
                        ?>
                            <div class="materials">
                                <div class="carta-prod">
                                    <img class="img" src="<?php echo $row['imatge'] ?>" alt="Imatge Producte">
                                    <h1 class="model"><?php echo $row['model'] ?></h1>
                                    <p class="preu"><?php echo $row['preu'] ?>.-€</p>
                                    <input class="id" type="button" value="Comprar" id="<?php echo $row['ID'] ?>">
                                </div>
                            </div>
                        <?php } ?>
                    </td>
                <tr>
            </table>

        </div>

    </main>
    <footer>
    </footer>
    <script src="../js/cargardades.js"></script>

</html>