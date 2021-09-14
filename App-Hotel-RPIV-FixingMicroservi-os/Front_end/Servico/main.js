
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
    let output = ''

    for (let servico of servicos) {
        output += `
                <tr>
                <td>${servico.id}</td>
                <td>${servico.nomeServico}</td>
                <td>${servico.valor}</td>
               
                </tr>
                 `
    }

    document.querySelector('tbody').innerHTML = output
}