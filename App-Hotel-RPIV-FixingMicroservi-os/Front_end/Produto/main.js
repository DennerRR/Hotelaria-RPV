
async function getContent() {
    try {
        const response = await fetch('http://localhost:8081/CrudService/api/estoque/todos')

        const data = await response.json()
        console.log(data)
        show(data)

    } catch (error) {
        console.error(error)
    }

}
getContent()

function show(produtos) {
    let output = ''

    for (let produto of produtos) {
        output += `
                <tr>
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.quantidade}</td>
                <td>${produto.valor}</td>
                
                </tr>
                 `
    }

    document.querySelector('tbody').innerHTML = output
}