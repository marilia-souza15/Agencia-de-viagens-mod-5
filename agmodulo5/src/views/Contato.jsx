import React from "react";



export default function Contato() {
    return (
    <div>
           <div class="titleDes">
               <h2 class="t">Contato</h2>
           </div>

     <div class="forminput"> 
        <div>
            <label for="nome" class="s">Nome: </label><br />
            <textarea rows="2" cols="52.5"></textarea><br /><br />
           
            <label for="mensagem" class="s">Mensagem: </label><br />
            <textarea rows="20" cols="52.5"></textarea>
            <input type="Submit" value="Enviar" />     
        </div>                                                                         
     </div>
    </div>
    );
}
