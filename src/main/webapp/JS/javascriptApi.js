
window.onload =()=>{
document.querySelector("#btFormu").addEventListener("click",() => {validar()});

                function validar() {
                   
                    let ok = true;
                    if (document.querySelector("#nombre").value == "") {
                        ok = false;
                        result = window.prompt("El campo no puede estar vacio");
                    }
                /*    
                    if (document.querySelector("#apellidos").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#contraseña").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#email").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#dni").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#contacto").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#nacionalidad").value == "") {
                        ok = false;
                    }
                    
                    if (document.querySelector("#condiciones").value == "1") {
                        ok = false;
                    }
                   
                  */
                    if (ok) {
                        document.querySelector("form").submit();
                        console.log("Enviado");
                       // response.sendRedirect("Contacto.html");
                    }


                }
 
     
    const $us=document.querySelector("#us"),
        $temp_card=document.querySelector("#temp_card"),
        $frag=document.createDocumentFragment(),
        $person_card=document.querySelector(".person_card"),
        $us_h3=document.querySelector("#us h3");  
        // vamos a hacer la carta individual
    const $cartaindividual=document.querySelector(".cartaindividual"),
        $temp_us=document.querySelector("#temp_us"),
        $frag2=document.createDocumentFragment();

    $us.addEventListener("click",function(){
        $person_card.classList.toggle("ocultar")
        $us.classList.toggle("Cerrar")
        if($us.classList.contains("Cerrar")){
            $us_h3.textContent="Cerrar"
        }else{
            $us_h3.textContent="Registros"
        }
    })    

    function pinta_elementos(data){

        console.log(data[1])
       /*Pinta todos los usuarios en el div user*/
       data.forEach((dt,i)=>{
           const clone = $temp_card.content.firstElementChild.cloneNode(true)
           clone.querySelector(".nom").textContent=dt.nombre
           clone.querySelector(".Apellido").textContent=dt.apellido
           clone.querySelector(".botoninfo").addEventListener("click",function(){
               $person_card.classList.add("ocultar")
               $cartaindividual.classList.remove("ocultar")
               pintacarta(dt)
           })
           $frag.appendChild(clone)
                 
   })

   function pintacarta(dt){
    const clone = $temp_us.content.firstElementChild.cloneNode(true)
          clone.querySelector(".nom1").textContent=dt.nombre
          clone.querySelector(".apll").textContent=dt.apellidos
          clone.querySelector(".email").textContent=dt.email
          clone.querySelector(".pais1").textContent=dt.pais
          clone.querySelector(".reg").textContent=dt.registro

 //tengo que arrastrar la info de la persona al ModificarContacto
          clone.querySelector(".Modi").addEventListener("click",function(){
            location.href="ModificarContacto.html"

          })

       // tengo que arrastrar la info de la persona a EliminarContacto  
          clone.querySelector(".Eli").addEventListener("click",function(){
            location.href="EliminarContacto.html"
    })

          clone.querySelector(".back").addEventListener("click",function(){
            
            $cartaindividual.classList.add("ocultar")
            $person_card.classList.remove("ocultar")
            // para que no se me duplique la info de carta roja
            $cartaindividual.removeChild(document.querySelector(".card_us"))
            
          })
          $frag2.appendChild(clone)
          $cartaindividual.appendChild($frag2)
   }

    $person_card.appendChild($frag)

}

    fetch('http://localhost:8080/IPadel/ListarRegistros')
    .then(response => response.json())
    .then(data => pinta_elementos(data))

}     
    
    




