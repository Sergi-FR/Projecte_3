
document.addEventListener('DOMContentLoaded', cargardades);

function cargardades(){

    let botoComprar = document.querySelectorAll('.id');
    let imatge, nom, model, preu, quantitat;

    let myJSON;

    for (i=0; i < botoComprar.length; i++){

        const producte = {};
        

        botoComprar[i].addEventListener('click', (e)=>{

            if(producte.quantitat=producte.quantitat){

                producte.id = e.target.parentElement.querySelector('.id').id;
                producte.model = e.target.parentElement.querySelector('.model').innerHTML;
                producte.imatge = e.target.parentElement.querySelector('.img').src;
                producte.preu = e.target.parentElement.querySelector('.preu').innerHTML;
                producte.quantitat++;

            }else{

                producte.id = e.target.parentElement.querySelector('.id').value;
                producte.model = e.target.parentElement.querySelector('.model').innerHTML;
                producte.imatge = e.target.parentElement.querySelector('.img').src;
                producte.preu = e.target.parentElement.querySelector('.preu').innerHTML;
                producte.quantitat=1;

            }
            myJSON = JSON.stringify(producte);
            localStorage.setItem(producte.id, myJSON);

        })

    }

}

document.addEventListener('DOMContentLoaded', mostrarinfo);

function mostrarinfo(){

    let clau;
    let info;

    document.getElementById('carrito').innerHTML = "";

    for(i=0; i < localStorage.length; i++){

        clau = localStorage.key(i);
        info = localStorage.getItem(clau);

        arrayProductes = JSON.parse(info);

        let quantitatLinia = parseFloat(arrayProductes.quantitat);
        let preuLinia = parseFloat(arrayProductes.preu);

        let totalLinia = quantitatLinia * preuLinia;

        document.getElementById("carrito").innerHTML += `<tr>
                                                        </div class="producte">
                                                            <div>
                                                                <img class="imgprod" src="${arrayProductes.imatge}" alt="producte">
                                                                <h3>Model: ${arrayProductes.model}</h3>
                                                            </div>
                                                            <p>${arrayProductes.quantitat}</p>
                                                            <p>${arrayProductes.preu}</p>
                                                            <p>${totalLinia}</p>
                                                            <input type="button" value="Eliminar" onclick="esborrarRegistre(${arrayProductes.id})">
                                                        </div>
                                                        </tr>`;

                                                                
    }
    
}

function esborrarRegistre(id){

    if(confirm("Estas segur que vols eliminar aquest producte?")){
        // comanda per esborrar solament un registre del LocalStorage
        localStorage.removeItem(id);
        mostrarinfo();
    }

}

function esborrarCarrito(){

    if(confirm("Estas segur que vols eliminar tot el Carrito?")){
        localStorage.clear();
        mostrarinfo();
    }

}



