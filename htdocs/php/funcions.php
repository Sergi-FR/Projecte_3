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

    if(!empty($_POST['dni']) && !empty($_POST['email']) && !empty($_POST['bancari'])){
    
        //Consulta
        $sql ="insert into clients values('" . $_POST['dni'] . "','" . $_POST['nom'] . "','" . $_POST['cognom'] . "','" . $_POST['sexe'] . "','" . $_POST['data'] . "','" . $_POST['tele'] . "','" . $_POST['email'] . "','" . $_POST['usuari'] . "',MD5(''" . $_POST['contra'] . "''),'" . $_POST['bancari'] . "')";
         
        $result = con()->query($sql);



        header("Location: ../view/login.view.php");

    }
    
}

?>