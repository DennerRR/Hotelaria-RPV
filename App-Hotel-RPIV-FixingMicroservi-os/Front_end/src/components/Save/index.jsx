import React, { useState } from "react";
import apiHotel from "../../services/api";


export default function Save(){
    const [codEndereco] = useState("");
    const [descricao, setDescricao] = useState("");
    const [endereco, setEndereco] = useState("");
    const [idCidade, setCidade] = useState("");
    const [idHotel] = useState("");


    function saveData(){
        const hotel = {
             codEndereco, descricao, endereco, idCidade, idHotel
        }
        console.log(hotel);
        apiHotel.post('salvar', hotel);
    }
    return(
        <div>
        <button type="button" class="btn btn-primary" id="botao" data-bs-toggle="modal" data-bs-target="#staticBackdropi">
            Cadastrar hotel
        </button>
        <div
            class="modal fade"
            id="staticBackdropi"
            data-bs-backdrop="static"
            data-bs-keyboard="false"
            tabindex="-1"
            aria-labelledby="staticBackdropLabel"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Cadastrar Hotel</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        
                        <div class="mb-3 row">
                            <label for="descricaohotel" class="col-sm-2 col-form-label">Descrição</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="descricaohotel" value={descricao} onChange={(event) => setDescricao(event.target.value)}/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="enderecohotel" class="col-sm-2 col-form-label">Endereço</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="enderecohotel" value={endereco} onChange={(event) => setEndereco(event.target.value)}/>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="cidadehotel" class="col-sm-2 col-form-label">Cidade</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="cidadehotel" value={idCidade} onChange={(event) => setCidade(event.target.value)}/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onClick={saveData}>Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    )
}