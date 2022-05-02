<?php

function con(){
    
    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "1234", "esqui");

    //Comprovasio de la connexio
    if($connexio->connect_errno){
        die ("No s'ha pogut fer la connexió");
    }

    return $connexio;

}

function Desar_session(){

    if(!empty($_POST['email']) && !empty($_POST['contra'])){

        $email = "email='".$_POST['email']."' ";
        $contra = "contrasenya=MD5('".$_POST['contra']."') ";
    
        //Consulta
        $sql ="SELECT * from clients where $email and $contra";
    
        $result = con()->query($sql);
    
        $message = '';
    
        if($result->num_rows > 0){
            
            while($row = $result->fetch_assoc()){
                
                $_SESSION['DNI'] = $row['DNI'];
                $_SESSION['nom'] = $row['nom'];
                $_SESSION['cognom'] = $row['cognom'];
                $_SESSION['sexe'] = $row['sexe'];
                $_SESSION['data'] = $row['data_naix'];
                $_SESSION['telefon'] = $row['telefon'];
                $_SESSION['correu'] = $row['email'];
                $_SESSION['usuari'] = $row['usuari'];
                $_SESSION['contrasenya'] = $row['contrasenya'];
                $_SESSION['compte_bancari'] = $row['compte_bancari'];

                
            }
            header("Location: ../view/home.view.php");
        } else {
            $message = 'L\'usuari o contrasenya son incorectes';
        }
    }
    
}

function registre(){

    if(!isset($_POST)){
    
        $dni = $_POST["dni"];
        $nom = $_POST["nom"];
        $cognom = $_POST["cognom"];
        $sexe = $_POST["sexe"];
        $data = $_POST["data"];
        $tele = $_POST["tele"];
        $email = $_POST["email"];
        $usuari = $_POST["usuari"];
        $contra = $_POST["contra"];
        $bancari = $_POST["bancari"];

        $insertar = `INSERT
        INTO clients (DNI, nom ,cognom , sexe, data_naix, telefon, email, usuari, contrasenya, compte_bancari) 
        VALUES('${dni}','${nom}','${cognom}','${sexe}','${data}','${tele}','${email}','${usuari}','${contra}','${bancari}');`;
        

        $result = con()->query($insertar);

        return $result;

    }
    
}

?>