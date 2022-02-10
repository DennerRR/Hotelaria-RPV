import React, {useEffect, useState} from "react";
import Edit from "../Edit";
import apiHotel from '../../services/api';
import Excluir from "../Excluir";
import Save from "../Save";

export default function Layout(){
    const [hoteis, setHoteis] = useState([]);
    useEffect(() => {
        apiHotel.get('todos').then((response) => {
            console.log(response.data);
            setHoteis(response.data)
        });
    }, []);
    return(
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID do Hotel</th>
                        {/* <th scope="col">Quartos</th> */}
                        <th scope="col">Descricao</th>
                        <th scope="col">Endereço</th>
                        {/* <th scope="col">Cidade</th> */}
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    {hoteis.map(hotel => (
                        <tr>
                            <td>{hotel.idHotel}</td>
                            {/* <td>{hotel.quartos}</td> */}
                            <td>{hotel.descricao}</td>
                            <td>{hotel.endereco}</td>
                            {/* <td>{hotel?.cidade}</td> */}
                            <td> 
                                {/* <Edit id={hotel.idHotel}
                                    descricao={hotel.descricao}
                                    endereco={hotel.endereco}
                                    cidade={hotel.cidade}
                                /> */}
                            </td>
                            <td>
                                <Excluir id={hotel.idHotel}/>
                            </td>
                        </tr>
                    ))}
                    <Save/>
                </tbody>
            </table>
    )
}