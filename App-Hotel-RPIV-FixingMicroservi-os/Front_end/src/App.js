import React, { Component } from 'react';
import apiServico from './services/api';

class App extends Component {
  state = {
    servicos: [],
  }
  async componentDidMount() {
    const response = await apiServico.get('todos');

    this.setState({ servicos: response.data });
  }
   render() {

  const { servicos } = this.state;

     return (
      <table class="table">
      <thead>
          <tr>
              <th scope="col">Identificador de Serviço</th>
              <th scope="col">Nome</th>
              <th scope="col">Valor</th>
              <th scope="col">Editar</th>
          </tr>
      </thead>
        <tbody>
      {servicos.map(servico => (
        <tr>
          <td>{servico.id}</td>
          <td>{servico.nomeServico}</td>
          <td>{servico.valor}</td>
          <td><td id="" >
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
                    <h5 class="modal-title" id="staticBackdropLabel">Editar Servico</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="staticId" class="col-sm-2 col-form-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control-plaintext" id="staticId" value={servico.id} />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="nomeservico" class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nomeservico" value={servico.nomeServico}/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="valorservico" class="col-sm-2 col-form-label">Valor</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="valorservico" step="0.01" value={servico.valor}/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Editar</button>
                </div>
            </div>
        </div>
    </div></td></td>
        </tr>
      ))}
        </tbody>
      </table>
    );
  };
};

export default App;
