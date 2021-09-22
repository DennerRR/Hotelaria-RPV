
async function getContent() {
    try {
        const response = await fetch('http://localhost:8081/CrudService/api/serviços/todos')

        const data = await response.json()
        console.log(data)
        show(data)
        

    } catch (error) {
        console.error(error)
    }

}
getContent()

function show(servicos) {
    let cont = 0
    let output = servicos.map(servico => (`
    <tr>
    <td id="">${servico.id}</td>
    <td>${servico.nomeServico}</td>
    <td>${servico.valor}</td>
    <td id="" ><!-- Button trigger modal -->
    <button value="${++cont}" type="button" class="btn btn-warning" id="botao" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onmouseover="getID(${cont})">
        Editar
    </button>
    <!-- Modal -->
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
                    <h5 class="modal-title" id="staticBackdropLabel">Editar Servico</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="staticId" class="col-sm-2 col-form-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control-plaintext" id="staticId" >
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="nomeservico" class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nomeservico" >
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="valorservico" class="col-sm-2 col-form-label">Valor</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="valorservico" step="0.01" >
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Editar</button>
                </div>
            </div>
        </div>
    </div></td>
    </tr>
     `)) 

    
    document.querySelector('tbody').innerHTML = output
 
    
}
