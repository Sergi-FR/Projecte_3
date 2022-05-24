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
                    <li><a href="home.view.php">Home</a></li>
                    <li><a href="alquilar.view.php">Alquilar</a></li>
                    <li><a href="carrito.view.php">Carrito</a></li>
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
                        <li><a href="../php/tancar.php"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <main>
        <div class="fromulari_perfil">
            <form action="" method="post">
                <div class="contenidor-perfil">             
                    <div class="perfil">
                        <div class="dreta">
                            <label for="dni">DNI</label>
                            <input id="dni" type="text" name="dni" value="<?php echo $_SESSION['DNI']?>" disabled>

                            <label for="nom">Nom</label>
                            <input id="nom" type="text" name="nom" value="<?php echo $_SESSION['nom']?>" disabled>

                            <label for="cognom">Cognom</label>
                            <input id="cognom" type="text" name="cognom" value="<?php echo $_SESSION['cognom']?>" disabled>

                            <label for="data">Data Naixement</label>
                            <input id="data" type="text" name="data" placeholder="YYYY-MM-DD" value="<?php echo $_SESSION['data']?>" disabled>

                            <label for="sexe">Genere</label>

                            <div class="genere">
                                <input type="text" name="sexe" id="home" placeholder="Masculi/Femeni" value="<?php echo $_SESSION['sexe']?>" disabled >
                            </div>                
                        </div>                 
                        <div class="esquerra">
                            <label for="email">Email</label>
                            <input id="email" type="email" name="email" placeholder="exemple@gmail.com" value="<?php echo $_SESSION['correu']?>">

                            <label for="tele">Telefon</label>
                            <input id="tele" type="text" name="tele" value="<?php echo $_SESSION['telefon']?>">

                            <label for="bancari">Compte Bancari</label>
                            <input id="bancari" type="text" name="bancari" value="<?php echo $_SESSION['compte_bancari']?>">

                            <label for="usuari">Usuari</label>
                            <input id="usuari" type="text" name="usuari" value="<?php echo $_SESSION['usuari']?>">
                            <input id="desar" type="submit" value="Desar">
                        </div> 

                    
                        <div class="ind">
                            <h4>Historial Individual</h4>

                            <div class="historial">
                            <?php $result= historialCursosInd();
                                while($row = $result->fetch_assoc()){
                                ?>
                                    <p><?php echo $row["nom"] ?>
                                    <?php echo $row["preu_client"]?>€
                                    <?php echo $row["ID_curs"] ?></p>          
                            <?php } ?>
                            </div>
                        </div>

                        <div class="col">
                            <h4>Historial Colectiu</h4>

                            <div class="historial">
                            <?php $result= historialCursosCol();
                                while($row = $result->fetch_assoc()){
                                ?>
                                    <p>Data: <?php echo $row["data_curs"]?>
                                    <?php echo $row["nom"]?>             
                                    <?php echo $row["preu_final"]?>€</p>
                            <?php } ?>
                            </div>
                        </div>

                        <div class="comp">
                            <h4>Historial Competició</h4>

                            <div class="historial">
                                <?php $result= historialCursosComp();
                                    while($row = $result->fetch_assoc()){
                                    ?>
                                        <p>Data: <?php echo $row["data_curs"]?>
                                        <?php echo $row["nom"] ?>
                                        <?php echo $row["nivell_curs"] ?>
                                        </p>
                                <?php } ?>
                            </div>
                        </div>
                        <div class="material">
                            <h4>Historial Material</h4>

                            <div class="historial">
                                <?php $result= historialCursosComp();
                                    while($row = $result->fetch_assoc()){
                                    ?>
                                        <p><?php echo $row["nom"]?>
                                        <?php echo $row["marca"]?>
                                        <?php echo $row["model"]?>
                                        <?php echo $row["preu"]?></p>
                                <?php } ?>
                            </div>
                        </div>
                    </div>
 
                    </div> 
                    <div id="perfil3">
                        <?php $result= historialMaterial();
                            while($row = $result->fetch_assoc()){
                            ?>
                                <p><?php echo $row["data"]?>
                                <?php echo $row["nom"]?>
                                <?php echo $row["marca"]?>
                                <?php echo $row["model"]?>
                                <?php echo $row["preu"]?></p>
                        <?php } ?>
                    </div>      
                </div>
            </form>
        </div>
    </main>
        <script src="../js/perfil.js"></script>        
    </html>