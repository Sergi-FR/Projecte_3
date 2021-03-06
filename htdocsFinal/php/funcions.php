<?php

function con(){
    
    //Connexio a la BD
    $connexio = new mysqli("localhost", "root", "mySQL", "esqui");

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

        $insertar = "insert into clients (DNI, nom ,cognom , sexe, data_naix, telefon, email, usuari, contrasenya, compte_bancari) values('$dni','$nom','$cognom','$sexe','$data','$tele','$email','$usuari',MD5('$contra'),'$bancari')";

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

function obtenirProductesBotes(){

    $sql="SELECT *
    from materials M
    where M.ID = (select ID_botes
                        from botes B
                        where M.ID = B.ID_botes)";        

    $result = con()->query($sql);

    return $result;

}

function obtenirProductesEsquis(){

    $sql="SELECT *
    from materials M
    where M.ID = (select ID_esqui
                        from esquis E
                        where M.ID = E.ID_esqui)";        

    $result = con()->query($sql);

    return $result;

}

function obtenirProductesPals(){

    $sql="SELECT *
    from materials M
    where M.ID = (select ID_pals
                        from pals P
                        where M.ID = P.ID_pals)";        

    $result = con()->query($sql);

    return $result;

}

function historialCursosInd(){

    $sql="SELECT C.DNI, C.nom, I.ID_curs, I.preu_client
    from clients C, llogar_individual I
    where C.DNI='".$_SESSION['DNI']."' and
    C.DNI = I.DNI_client";        

    $result = con()->query($sql);

    return $result;

}

function historialCursosCol(){

    $sql="SELECT C.DNI, C.nom, CO.ID_curs, CO.preu_final, CO.data_curs
    from clients C, llogar_colectiu CO
    where C.DNI ='".$_SESSION['DNI']."' and
    C.DNI = CO.DNI_client";
    
    $result = con()->query($sql);

    return $result;

}

function historialCursosComp(){

    $sql="SELECT C.DNI, C.nom, COM.ID_curs, COMP.nivell_curs,COM.data_curs
    from clients C, federat F, competeix COM, competicio COMP
    where F.dni_federat='".$_SESSION['DNI']."' and
    C.DNI = F.dni_federat and
    F.dni_federat = COM.DNI_federat and
    COM.ID_curs = COMP.ID_comp";

           

    $result = con()->query($sql);

    return $result;

}

function historialMaterial(){

    $sql="SELECT *
    from clients c1, materials m1, llogar l1
    where c1.DNI= l1.dni_client and
    m1.ID=l1.id_material and
    c1.DNI ='".$_SESSION['DNI']."'";        

    $result = con()->query($sql);

    return $result;

}
?>