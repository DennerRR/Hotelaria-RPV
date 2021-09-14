
async function getContent() {
    try {
        const response = await fetch('http://localhost:8081/CrudService/api/Cidades/todas/cidades')

        const data = await response.json()
        console.log(data)
        show(data)

    } catch (error) {
        console.error(error)
    }

}
getContent()

function show(cidades) {
    let output = ''

    for (let cidade of cidades) {
        output += `
                <tr>
                <td>${cidade.id}</td>
                <td>${cidade.nome}</td>
                <td>${cidade.ddd}</td>
                <td>${cidade.hoteis}</td>
                
                </tr>
                 `
    }

    document.querySelector('tbody').innerHTML = output
}