let imagenes = new Array();
imagenes.push('media/img/slider/pala5.jpg');
imagenes.push('media/img/slider/palas.jpg');
imagenes.push('media/img/slider/palas2.jpg');
imagenes.push('media/img/slider/pala3.jpg');
imagenes.push('media/img/slider/pala4.jpg');
imagenes.push('media/img/slider/pala6.jpg');
imagenes.push('media/img/slider/pala7.jpg');



let cont = 0;
let fin = imagenes.length;


window.onload = () => {


       document.querySelector('.fa-angle-right').addEventListener('click', () => {
        cont++;
        if(cont == fin){
            cont = 0;
        }
        document.querySelector(".sliderpalas img").src = imagenes[cont];

    })
    document.querySelector('.fa-angle-left').addEventListener('click', () => {
        cont--;
        if(cont <= 0){
            cont = fin-1 ;
        }
        document.querySelector(".sliderpalas img").src = imagenes[cont];

    })


}