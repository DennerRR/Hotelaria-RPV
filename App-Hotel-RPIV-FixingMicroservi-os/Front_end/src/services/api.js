import axios from 'axios';

const apiServico = axios.create({
    baseURL: 'http://localhost:8081/CrudService/api/serviços'
});

export default apiServico;