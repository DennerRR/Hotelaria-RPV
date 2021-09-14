
async function getContent() {
    try {
        const response = await fetch('http://localhost:8081/CrudService/api/hoteis/todos')

        const data = await response.json()
        console.log(data)
        show(data)

    } catch (error) {
        console.error(error)
    }

}
getContent()

function show(hoteis) {
    let output = ''

    for (let hotel of hoteis) {
        output += `
                <tr>
                <td>${hotel.idHotel}</td>
                <td>${hotel.quartos}</td>
                <td>${hotel.codEndereco}</td>
                <td>${hotel.descricao}</td>
                <td>${hotel.endereco}</td>
                <td>${hotel.cidade}</td>
                </tr>
                 `
    }

    document.querySelector('tbody').innerHTML = output
}