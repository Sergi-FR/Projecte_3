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
        }
    }
    
}

function registre(){

    if(!empty($_POST['dni']) && !empty($_POST['nom'])){

        $dni = $_POST['dni'];
        $nom = $_POST['nom'];
        $cognom = $_POST['cognom'];
        $sexe = $_POST['sexe'];
        $datedata = $_POST['data'];
        // Passar de tipus de dada string a date
        $stringdata = strtotime($datedata);
        // Creant un nou format de data
        $data = date("Y-m-d", $stringdata);

        $tele = $_POST['tele'];
        $email = $_POST['email'];
        $usuari = $_POST['usuari'];
        $contra = $_POST['contra'];
        $bancari = $_POST['bancari'];

        $insertar = "insert into clients (DNI, nom ,cognom , sexe, data_naix, telefon, email, usuari, contrasenya, compte_bancari) values('$dni','$nom','$cognom','$sexe','$data','$tele','$email','$usuari',MD5('$data'),'$bancari')";

        $result = con()->query($insertar);

        return $result;

        header("Location: ../view/login.view.php");

    }

}


function obtenirKitsPOP(){

    $sql="SELECT k.ID, k.usos, k.preu, b.marca, b.model, bo.talla, e.marca, e.model, es.llargada, p.marca, p.model, pa.alçada
    from kit k, constar c, materials b, materials e, materials p ,pals pa, botes bo, esquis es
    where k.ID=c.id_kit
    and b.ID=c.id_materialB
    and e.ID=c.id_materialE
    and p.ID=c.id_materialP
    and pa.ID_pals=c.id_materialP
    and bo.ID_botes=c.id_materialB
    and es.ID_esqui=c.id_materialE
    order by usos desc
    limit 3";

    $result = con()->query($sql);

    return $result;

}

function obtenirProductes(){

    $sql="SELECT * from materials";        

    $result = con()->query($sql);

    return $result;

}
?>