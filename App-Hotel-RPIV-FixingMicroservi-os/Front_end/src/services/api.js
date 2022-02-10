import axios from 'axios';

const apiServico = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/serviços'
});


const apiCidade = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/Cidades'
});


const apiHotel = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/hoteis'
});

export default apiHotel;

const apiProduto = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/estoque/todos'
});


const apiQuarto = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/quartos/todos'
});


const apiTurismo = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/Turismo/todos'
});


const apiUsuario = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/usuarios/todos'
});

