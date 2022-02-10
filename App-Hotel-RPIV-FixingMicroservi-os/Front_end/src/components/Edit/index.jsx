import React, {useState}from "react";

export default function Edit({id, descricao, endereco, cidade}) {
    
    const [id1, setId] = useState(id);
    const [descricao1, setDescricao] = useState(descricao);
    const [endereco1, setEndereco] = useState(endereco);
    const [cidade1, setCidade] = useState(cidade);
    
    return (
        
        <div>
            <button type="button" class="btn btn-warning" id="botao" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Editar
            </button>
            <div
                class="modal fade"
                id="staticBackdrop"
                data-bs-backdrop="static"
                data-bs-keyboard="false"
                tabindex="-1"
                aria-labelledby="staticBackdropLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">Editar Hotel</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3 row">
                                <label for="staticId" class="col-sm-2 col-form-label">ID</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control-plaintext" id="staticId" value={id1} onChange={(event) => setId(event.target.value)} />
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="descricaohotel" class="col-sm-2 col-form-label">Descrição</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="descricaohotel" value={descricao1} onChange={(event) => setDescricao(event.target.value)}/>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="enderecohotel" class="col-sm-2 col-form-label">Endereço</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="enderecohotel" value={endereco1} onChange={(event) => setEndereco(event.target.value)}/>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="cidadehotel" class="col-sm-2 col-form-label">Cidade</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="cidadehotel" value={cidade1} onChange={(event) => setCidade(event.target.value)}/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Editar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}