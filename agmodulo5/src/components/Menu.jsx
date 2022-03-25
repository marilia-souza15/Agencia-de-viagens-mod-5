import React from "react"
import { Link } from "react-router-dom"
<Link to="./Assets/css/style.css" />

export default function Menu() {
    return (
        <nav class="Menu" id="menu">
            <ul>
                <h1>                <Link to="/Home" class="nav">Home</Link>
                <Link to="/Destinos" class="nav">Destinos</Link>
                <Link to="/Promocoes" class="nav">Promoções</Link>
                <Link to="/Contato" class="nav">Contato</Link></h1>
 
            </ul>
           
        </nav>
    );
}