import React from "react";
import apiHotel from "../../services/api";

export default function Excluir(id){
    function deleteData(){
        console.log(id.id);
        apiHotel.delete(`hotel/excluir/${id.id}`);
    }
    return(
        <div>
            <button type="button" class="btn btn-danger" onClick={() => deleteData()}>
                Excluir
            </button>
        </div>
    )
}