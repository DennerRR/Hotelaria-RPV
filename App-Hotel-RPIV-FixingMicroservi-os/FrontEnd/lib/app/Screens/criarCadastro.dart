import 'package:app_hotel/app/Screens/backgroundImage.dart';
import 'package:app_hotel/app/Screens/textInputField.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class CriarCadastro extends StatefulWidget {
  CriarCadastro({Key key}) : super(key: key);

  @override
  _CriarCadastroState createState() => _CriarCadastroState();
}

class _CriarCadastroState extends State<CriarCadastro> {
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
            'Criar Cadastro',
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
                        'Por favor, preencha os campos abaixo para criar sua conta.',
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                    TextInputField(
                      icon: FontAwesomeIcons.envelope,
                      text: 'Email',
                      inputType: TextInputType.emailAddress,
                      inputAction: TextInputAction.next,
                    ),
                    TextInputField(
                      icon: FontAwesomeIcons.lock,
                      text: 'Senha',
                      inputType: TextInputType.name,
                      inputAction: TextInputAction.next,
                    ),
                    TextInputField(
                      icon: FontAwesomeIcons.lock,
                      text: 'Confirmar Senha',
                      inputType: TextInputType.name,
                      inputAction: TextInputAction.done,
                    ),
                    TextButton(
                      onPressed: () {
                        Navigator.of(context).pushReplacementNamed('/');
                      },
                      style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(Colors.white),
                      ),
                      child: Text('Criar Cadastro'),
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
