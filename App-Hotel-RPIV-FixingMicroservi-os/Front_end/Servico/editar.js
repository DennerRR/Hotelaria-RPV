
async function getID(value) {
    try {
        const response = await fetch(`http://localhost:8081/CrudService/api/serviços/serviços/pegar/${value}`)
        const data = await response.json()
        console.log(data)
        preenche(data)

    } catch (error) {
        console.error(error)
    }

}
function preenche (servico){
    document.getElementById('staticId').value = servico.id
    document.getElementById('nomeservico').value = servico.nomeServico
    document.getElementById('valorservico').value = servico.valor
}

