let carrito = [];
let arrayProductes = [];

document.addEventListener('DOMContentLoaded', iniciar);

function iniciar(){


    if(localStorage.length != null){
        carregarDades();
    }

    let esborrarCarrito = document.getElementById('esborrar');
    esborrarCarrito.addEventListener('click', (e)=>{

        e.preventDefault();

        if(confirm("Estas segur que vols buidar el carrito?")){
            localStorage.clear();
            carrito = [];
            carregarDades();
        }
    })

    let botoComprar = document.querySelectorAll('.comprar');
    let imatge, nom, model, preu, quantitat;

    let myJSON;

    for (i=0; i < botoComprar.length; i++){

        const producte = {};

        botoComprar[i].addEventListener('click', (e)=>{

            producte.model = e.target.parentElement.querySelector('.model').innerHTML;

            if(carrito.find(element => element.model == producte.model)){

                producte.quantitat++;

            }else{

                
                producte.preu = e.target.parentElement.querySelector('.preu').innerHTML;
                producte.quantitat=1;
            
                carrito.push(producte)

            }

            
            myJSON = JSON.stringify(carrito);
            localStorage.setItem("Comprar", myJSON);

            carregarDades();

        })

    }

}


function carregarDades(){

    let clau;
    let info;

    document.getElementById('producte_carrito').innerHTML = "";


        if(localStorage.length > 0) {

            clau = localStorage.key(0);
            info = localStorage.getItem(clau);

            arrayProductes = JSON.parse(info);

                for(i=0; i < arrayProductes.length; i++){

                    let quantitatLinia = parseFloat(arrayProductes[i].quantitat);
                    let preuLinia = parseFloat(arrayProductes[i].preu);

                    let totalLinia = quantitatLinia * preuLinia;

                    document.getElementById("carrito").innerHTML += `<div class="articleCompra">
                                                                    <img src="${arrayProductes[i].imatge}" alt="persona">
                                                                    <h1>Model: ${arrayProductes[i].model}</h1>
                                                                    <p>Preu: ${arrayProductes[i].preu}</p>
                                                                    <p>${arrayProductes[i].quantitat}</p>
                                                                    <p>${totalLinia}€</p>
                                                                    <input type="button" value="Eliminar" onclick="esborrarRegistre(${i})"> 
                                                                    </div>`;
                                                                    
                }

        }
    
    console.log(arrayProductes);

}