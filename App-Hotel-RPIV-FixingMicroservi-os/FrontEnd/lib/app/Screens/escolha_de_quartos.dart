import 'package:flutter/material.dart';

class Quartos_livres extends StatefulWidget {
  @override
  _Quartos_livresState createState() => _Quartos_livresState();
}


class _Quartos_livresState extends State<Quartos_livres> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Quartos Disponíveis'),
        ),
        body: Container(
          child: Column(
            children: [
              Container( 
                child: Padding(
                  padding: EdgeInsets.all(20.0),
                  child: Card(
                    child: Container(
                      decoration: myBoxDecoration(),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceAround,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          Column(
                            children:[
                            Text('Quarto Solteiro',
                                  style: TextStyle(fontSize: 18),),
                            Text('Cama Solteiro'),
                            ],
                          ),
                          Column(
                            children:[
                              RaisedButton(
                                child: Text('Reservar'),
                                onPressed: (){
                                  Navigator.of(context).pushNamed('');
                                },
                                color: Colors.green,
                                textColor: Colors.white,
                              ),
                            ],
                          )
                        ],
                      ),
                    ),
                  ),
                ),
              ),
              Container( 
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Card(
                    child: Container(
                      decoration: myBoxDecoration(),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceAround,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          Column(
                            children:[
                            Text('Quarto Casal',
                                  style: TextStyle(fontSize: 18),),
                            Text('Cama Casal'),
                            ],
                          ),
                          Column(
                            children:[
                              RaisedButton(
                                child: Text('Reservar'),
                                onPressed: (){
                                  Navigator.of(context).pushNamed('');
                                },
                                color: Colors.green,
                                textColor: Colors.white,
                              ),
                            ],
                          )
                        ],
                      ),
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
    border: Border.all(
      width: 2.0
    ),
    borderRadius: BorderRadius.all(
        Radius.circular(10.0) //       
    ),
  );
}