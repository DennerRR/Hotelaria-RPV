import 'package:flutter/material.dart';

class Hoteis_Disponiveis extends StatefulWidget {
  @override
  _Hoteis_DisponiveisState createState() => _Hoteis_DisponiveisState();
}

class _Hoteis_DisponiveisState extends State<Hoteis_Disponiveis> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Hoteis Disponíveis'),
      ),
      body: Container(
        child: Column(
          children: [
            Container(
              child: Card(
                child: Container(
                  decoration: myBoxDecoration(),
                  child: Row(
                    children: [
                      SizedBox(
                        height: 150,
                        width: 180,
                        child: Padding(
                          padding: const EdgeInsets.all(5.0),
                          child: Image.asset('Assets/imagens/cavera.jpg'),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.all(10),
                        child: Align(
                          alignment: Alignment.topLeft,
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.start,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                'Hotel Caverá',
                                style: TextStyle(fontSize: 20),
                              ),
                              Container(
                                height: 10,
                              ),
                              Text('Endereço: '),
                              Text('X quartos disponiveis'),
                              RaisedButton(
                                child: Text('Reservar'),
                                onPressed: () {
                                  Navigator.of(context).pushNamed('/quartos');
                                },
                                color: Colors.green,
                                textColor: Colors.white,
                              ),
                            ],
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

BoxDecoration myBoxDecoration() {
  return BoxDecoration(
    border: Border.all(width: 2.0),
    borderRadius: BorderRadius.all(Radius.circular(10.0) //
        ),
  );
}
