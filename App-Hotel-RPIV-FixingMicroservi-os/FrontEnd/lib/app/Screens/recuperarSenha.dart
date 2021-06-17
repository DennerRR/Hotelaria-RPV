import 'package:app_hotel/app/Screens/backgroundImage.dart';
import 'package:app_hotel/app/Screens/textInputField.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
//import 'package:http/http.dart' as http;

class RecuperarSenha extends StatelessWidget {
  const RecuperarSenha({
    Key key,
    this.email,
  }) : super(key: key);

  final String email;

  // void validarEmail(String email) async {
  //   final json = await fetch();
  //   var userEmail = json['email'];
  //   if (email == userEmail) {
  //     print('Enviamos um email de redefinição de senha para ${email}');
  //   } else {
  //     print('Este email não consta na nossa base de dados!');
  //   }
  // }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return BackgroundImage(
      child: Scaffold(
        backgroundColor: Colors.transparent,
        appBar: AppBar(
          backgroundColor: Colors.transparent,
          elevation: 0,
          leading: IconButton(
            onPressed: () {
              Navigator.of(context).pushReplacementNamed('/');
            },
            icon: Icon(
              Icons.arrow_back_ios,
              color: Colors.white,
            ),
          ),
          title: Text(
            'Recuperar Senha',
            style: TextStyle(color: Colors.white),
          ),
          centerTitle: true,
        ),
        body: Padding(
          padding: const EdgeInsets.all(15.0),
          child: Column(
            children: [
              Center(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    Container(
                      width: size.width * 0.8,
                      child: Text(
                        'Tudo bem! Insira seu endereço de email cadastrado para receber um link de redefinição de senha.',
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                    TextInputField(
                      icon: FontAwesomeIcons.envelope,
                      text: 'Email',
                      inputType: TextInputType.emailAddress,
                      inputAction: TextInputAction.done,
                    ),
                    TextButton(
                      onPressed: () {},
                      style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(Colors.white),
                      ),
                      child: Text('Recuperar Senha'),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// Future<Map> fetch() async {
//   var url = '/api/usuarios/$email';
//   var response = await http.get(url);
//   var json = jsonDecode(response.body);
//   return json;
// }
