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

    <link rel="stylesheet" href="../css/perfil.css">

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
                    <li><a href="#">Perfil</a></li>
                    <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main>
        <div class="fromulari_perfil">
            <form action="" method="post">
                <div class="contenidor-perfil">
                    <div class="botons">
                        <button>Info</button>
                        <button>Historial Material</button>
                        <button>Historial Cursos</button>
                    </div>               
                    <div class="perfil">
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

                            <input id="desar" type="submit" value="Desar">
                        </div> 
                    </div> 
                    <div id="perfil2">
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

                            <input id="desar" type="submit" value="Desar">
                        </div> 
                    </div> 
                    <div id="perfil3">
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

                            <input id="desar" type="submit" value="Desar">
                        </div> 
                    </div>      
                </div>
            </form>
        </div>
    </main>
        <script src="../js/perfil.js"></script>
    </html>