<?php

function con(){
    
    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "", "");

    //Comprovasio de la connexio
    if($connexio->connect_errno){
        die ("No s'ha pogut fer la connexió");
    }

    return $connexio;

}

function Desar_session(){

    if(isset($_POST['contra']) && isset($_POST['usuari'])){

        $usuari = "Usuari='".$_POST['usuari']."' ";
        $contra = "Contrasenya=MD5('".$_POST['contra']."') ";
    
        //Consulta
        $sql = "";
    
        $result = con()->query($sql);
    
        $message = '';
    
        if($result->num_rows > 0){
            while($row = $result->fetch_assoc()){
                $_SESSION['usuari'] = $row['Usuari'];
                $_SESSION['DNI'] = $row['DNI_Client'];
                $_SESSION['Nom'] = $row['Nom'];
                $_SESSION['Cognom'] = $row['Cognom'];
                $_SESSION['Data'] = $row['Data_naixement'];
                $_SESSION['Tele'] = $row['Tel'];
                $_SESSION['Correu'] = $row['Correu_e'];
                $_SESSION['Sexe'] = $row['Sexe'];
                $_SESSION['Condicio'] = $row['Condicio_Fisica'];
                $_SESSION['Comunicacio'] = $row['Comunicació_comercial'];
                
            }
            header("Location: ../php/home.view.php");
        } else {
            $message = 'L\'usuari o contrasenya son incorectes';
        }
    }
    
        

}

?>