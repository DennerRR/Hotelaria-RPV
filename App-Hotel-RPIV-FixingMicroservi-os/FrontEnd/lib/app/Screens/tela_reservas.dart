import 'package:app_hotel/classes/reserva.dart';
import 'package:flutter/material.dart';

class TelaReservas extends StatefulWidget {
  // This widget is the root of your application.
  @override
  State<TelaReservas> createState() {
    return DadosReserva();
  }
}

class DadosReserva extends State<TelaReservas> {
  String dataIn = ' ';
  String dataOut = ' ';
  String cidade = ' ';
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: Drawer(
        child: Column(
          children: [
            ListTile(
              leading: Icon(Icons.card_travel),
              title: Text('Minhas Reservas'),
              subtitle: Text('confira suas reservas!'),
              onTap: () {
                print('viagens');
              },
            ),
            ListTile(
                leading: Icon(Icons.logout),
                title: Text('Sair'),
                onTap: () {
                  Navigator.of(context).pushReplacementNamed('/');
                }),
          ],
        ),
      ),
      appBar: AppBar(
        title: Text('Buscar Hotéis'),
      ),
      body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset('Assets/imagens/login.jpg'),
            Container(
              height: 30,
            ),
            Text('Data de check-in:'),
            TextField(
              onChanged: (text) {
                dataIn = text;
              },
              keyboardType: TextInputType.datetime,
              decoration: InputDecoration(
                labelText: 'DD/MM/AAAA',
                border: OutlineInputBorder(),
              ),
            ),
            Container(
              height: 25,
            ),
            Text('Data de check-out:'),
            TextField(
              onChanged: (text) {
                dataOut = text;
              },
              keyboardType: TextInputType.datetime,
              decoration: InputDecoration(
                labelText: 'DD/MM/AAAA',
                border: OutlineInputBorder(),
              ),
            ),
            Container(
              height: 25,
            ),
            Text('Cidade:'),
            TextField(
              onChanged: (text) {
                cidade = text;
              },
              decoration: InputDecoration(
                labelText: 'Cidade de destino',
                border: OutlineInputBorder(),
              ),
            ),
            RaisedButton(
              child: Text('Buscar'),
              onPressed: () {
                var reserva =
                    Reserva(dataIn: dataIn, dataOut: dataOut, cidade: cidade);
                print(reserva.toJson());
                Navigator.of(context).pushNamed('/hoteis');
              },
              color: Colors.green,
              textColor: Colors.white,
            ),
          ],
        ),
      ),
    );
  }
}
