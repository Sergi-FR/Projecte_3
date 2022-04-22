<?php

include '../php/funcions.php';
session_start();
Desar_session();

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

    <link rel="stylesheet" href="/css/login.css">

</head>

<body>

    <!-- Nav
    ################################################# -->
    <nav>
        <div class="menu-main">
            <div class="logo">
                <a href="../index.html"><img src="../img/logo.png" alt="Logo"></a>
                <p>Marca</p>
            </div>
        </div>
    </nav>

    <!-- Main
    ################################################# -->
    <main>
        <div class="login">
            <form action="login.view.php" method="post">
                <div class="login-content">
                    <label for="email">Email</label>
                    <input id="email" type="email" name="email" placeholder="exemple@gmail.com">
                    <label for="contra">Contrasenya</label>
                    <input type="password" name="contra" id="contra">
                    <button type="submit" >Enviar</button>
                    <p>Encara no estas donat d'alta? <a href="registre.view.php">Registrat!!!</a></p>
                </div>
            </form>
        </div>

    </main>

    <footer>

    </footer>
</body>

</html>