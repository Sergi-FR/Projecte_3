<?php

include '../php/funcions.php';
session_start();
registre();

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

    <link rel="stylesheet" href="../css/registre.css">

</head>

<body>

    <!-- Nav
    ################################################# -->
    <nav>
        <div class="menu-main">
            <div class="logo">
                <a href="../index.html"><img src="../img/logo.png" alt="Logo"></a>
                <p><span>Sky</span>ling</p>
            </div>
        </div>
    </nav>

    <!-- Main
    ################################################# -->
    <main>
        <div class="login">
            <form action="" method="post">
                <div class="login-content">
                    <div class="dreta">
                        <label for="dni">DNI</label>
                        <input id="dni" type="text" name="dni">

                        <label for="nom">Nom</label>
                        <input id="nom" type="text" name="nom">

                        <label for="cognom">Cognom</label>
                        <input id="cognom" type="text" name="cognom">

                        <label for="data">Data Naixement</label>
                        <input id="data" type="text" name="data" placeholder="YYYY-MM-DD">

                        <label for="sexe">Genere</label>

                        <div class="genere">
                            <input type="radio" name="sexe" id="home" value="Masculi" >
                            <label for="sexe">Home</label> 
                        </div>
                        <div class="genere">
                            <input type="radio" name="sexe" id="dona" value="Femeni">
                            <label for="sexe">Dona</label>
                        </div>                   
                    </div>
                    
                    <div class="esquerra">
                        <label for="email">Email</label>
                        <input id="email" type="email" name="email" placeholder="exemple@gmail.com">

                        <label for="tele">Telefon</label>
                        <input id="tele" type="text" name="tele">

                        <label for="bancari">Compte Bancari</label>
                        <input id="bancari" type="text" name="bancari" >

                        <label for="usuari">Usuari</label>
                        <input id="usuari" type="text" name="usuari">

                        <label for="contra">Contrasenya</label>
                        <input id="contra" type="password" name="contra">
                        <input id="enviar" type="submit" value="Enviar">
                        <p>Ja estas donat d'alta? <a href="login.view.php">Fes Login!!!</a></p>
                    </div>       
                </div>
            </form>
        </div>

    </main>

    <footer>

    </footer>
</body>

</html>